package userInterface;

import exceptions.InputException;
import objects.Person;
import java.util.Scanner;

/**
 * @version 0.2
 * @author Malte
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
        } catch (Exception e) {
            throw new InputException("Bitte einen String für den Namen, einen Boolean für dsa Geschlecht, eine ganze Zahl für die Größe und eine Dezimalzahl für das Gewicht eingeben...");
        }

        return pTemp;
    }

    /**
     *
     * @return Einen boolischen Wert, je nachdem welcher eingegeben wurde.
     *
     * @throws exceptions.InputException
     */
    public static boolean liesAuswahlBoolean() throws InputException {
        boolean eingabe;

        try {
            eingabe = scanner.nextBoolean();
        } catch (Exception e) {
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
        } catch (Exception e) {
            throw new InputException("Bitte einen Boolean eingeben...");
        }

        return eingabe;
    }

}
