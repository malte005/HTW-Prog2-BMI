/**
 * exceptions Main-Package in der sich der Programmeinstieg befindet.
 */
package exceptions;

/**
 * Beschreibung:
 * Die Exceptionklasse des Programms bei fehlerhaften Benutzereingaben.
 *
 * @author Malte Dammann
 * E-Mail: s0549309@htw-berlin.de
 * Bearbeitungszeitraum: 22.04.15 - 28.04.2015
 *
 * Modul: Programmierung 2
 * 
 * Dateiname: Engine.java
 * IDE: NetBeans IDE 8.0.2
 * Java: 1.8.0_20; Java HotSpot(TM) 64-Bit
 *
 * @since 2015-04-22
 * @version 0.1
 *
 */
public class InputException extends Exception{

    /**
     *
     * @param message Zusätzliche Fehlermeldung.
     */
    public InputException(String message) {
        super("Eingabefehler: " + message);
    }
}
