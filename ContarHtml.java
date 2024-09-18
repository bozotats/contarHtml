//Programa para recibir un archivo, y un texto en los args, y contar cuantas veces aparece el texto en el archivo
import javax.swing.text.html.*;
import java.util.logging.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ContarHtml {
    private static final Logger LOGGER = Logger.getLogger(ContarHtml.class.getName());

    public static void main(String[] args) throws IOException{
        if (args.length != 2) {
            System.out.println("Uso: java ContarHtml direccion-archivo palabra-clave");
            return;
        }
        Handler cHandler = new ConsoleHandler();
        cHandler.setFormatter(new ContarFormatter());
        FileHandler archivo = new FileHandler("file-" + args[1] + ".log");
        ContarFormatter contForm = new ContarFormatter();
        archivo.setFormatter(contForm);

        LOGGER.addHandler(archivo);
        LOGGER.setLevel(Level.ALL);
        FileReader fReader = null;

        try {
            fReader = new FileReader(args[0]);
        } catch (FileNotFoundException e) {
            LOGGER.severe("No se puede abrir el archivo");
            System.exit(1);
        }

        ContarParse parser = new ContarParse();
        HTMLEditorKit.Parser procesador = parser.getParser();

        try {
            HTMLTagHandlerContar manejoEtiquetas = new HTMLTagHandlerContar();
            manejoEtiquetas.keyword = args[1];
            manejoEtiquetas.LOGGER = LOGGER;

            procesador.parse(fReader, manejoEtiquetas, true);

        } catch (IOException e) {
            LOGGER.severe("No se puede leer el archivo");
            System.exit(2);
        }

    }

}