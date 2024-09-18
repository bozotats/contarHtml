import javax.swing.text.html.HTMLEditorKit;
import java.util.logging.Logger;

public class HTMLTagHandlerContar extends HTMLEditorKit.ParserCallback {
    @Override
    public void handleText(char[] data, int pos) {

        if (keyword == null) {
            LOGGER.severe("No se ha especificado una palabra clave");
            return;
        }

        if (data == null) {
            LOGGER.severe("No hay texto para leer");
            return;
        }

        String texto = new String( data );
        for (int i = -1; (i = texto.indexOf(keyword, i + 1)) != -1; i++) {
            LOGGER.fine("Palabra clave encontrada en la posicion: " + i);
        }
        
    }

    public String keyword = null;
    public Logger LOGGER = null;


}