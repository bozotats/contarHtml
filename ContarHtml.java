//Programa para recibir un archivo, y un texto en los args, y contar cuantas veces aparece el texto en el archivo
import javax.swing.*;
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

    }

}