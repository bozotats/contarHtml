import javax.swing.text.MutableAttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLEditorKit;
import java.util.logging.Logger;

public class HTMLTagHandlerContar extends HTMLEditorKit.ParserCallback {
    
    private boolean inParagraph;

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
        if (inParagraph) {
            for (int i = -1; (i = texto.indexOf(keyword, i + 1)) != -1; i++) {
                LOGGER.fine("Palabra clave encontrada en la posicion: " + i);
            }
        }
            
        
    }

    @Override
    public void handleStartTag(HTML.Tag t, MutableAttributeSet a, int pos) {
        if( t == HTML.Tag.P ) {
            inParagraph = true;
        }
    }

    @Override
    public void handleEndTag(HTML.Tag t, int pos) {
        if( t == HTML.Tag.P ) {
            inParagraph = false;
        }
    }

    public String keyword = null;
    public Logger LOGGER = null;


}