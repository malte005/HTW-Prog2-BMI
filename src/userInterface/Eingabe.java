/**
 * userInterfaces Hier befinden sich alle Klassen die mit dem User-Interface zu tun haben.
 */
package userInterface;

import exceptions.InputException;
import java.util.InputMismatchException;
import objects.Person;
import java.util.Scanner;

/**
 * Beschreibung:
 * Diese Klasse handelt das Einlesen einer Person durch den Benutzer.
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
 * @version 0.5
 *
 */
public abstract class Eingabe {

    static Scanner scanner;

    /**
     * Initialisierung des Scanners.
     */
    public static void init() {
        scanner = new Scanner(System.in);
    }

    /**
     *
     * @return Ein Person-Objekt mmit den eingegebenen Werten (Name, Geschlecht, Größe, Gewicht) wird zurückgegeben.
     *
     * @throws exceptions.InputException
     */
    public static Person liesPerson() throws InputException {
        Person pTemp;

        try {
            System.out.println("Namen eingaben:");
            String name = scanner.next();

            System.out.println("Geschlecht eingaben (Mann = true / Frau = false):");
            boolean geschlecht = scanner.nextBoolean();

            System.out.println("Größe in cm eingaben:");
            int groesse = scanner.nextInt();

            System.out.println("Gewicht in kg eingaben:");
            float gewicht = scanner.nextFloat();

            pTemp = new Person(name, geschlecht, groesse, gewicht);
        } catch (IllegalStateException | InputMismatchException e) {
            scanner.next();
            throw new InputException("Bitte einen String für den Namen, einen Boolean für dsa Geschlecht, eine ganze Zahl für die Größe und eine Dezimalzahl für das Gewicht eingeben...");
        }

        return pTemp;
    }

    /**
     *
     * @return Einen boolischen Wert, je nachdem welcher eingegeben wurde.
     *
     * @throws exceptions.InputException IllegalStateException
     */
    public static boolean liesAuswahlBoolean() throws InputException {
        boolean eingabe;

        try {
            eingabe = scanner.nextBoolean();
        } catch (Exception e) {
            scanner.next();
            throw new InputException("Bitte einen Boolean eingeben...");
        }

        return eingabe;
    }

    /**
     *
     * @return Eine Zahl, je nachdem werlche eingegeben wurde.
     *
     * @throws InputException
     */
    public static int liesAuswahlZahl() throws InputException {
        int eingabe;

        try {
            eingabe = scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner.next();
            throw new InputException("Bitte eine Zahl von 1-3 eingeben eingeben...");
        }

        return eingabe;
    }

}
