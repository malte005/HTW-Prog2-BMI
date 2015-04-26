
package exceptions;

/**
 * BESCHREIBUNG
 *
 * @author Malte
 * @version 0.1
 */
public class InputException extends Exception{

    public InputException(String message) {
        super("Eingabefehler: " + message);
    }
}
