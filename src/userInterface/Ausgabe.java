package userInterface;

import objects.Person;

/**
 * @version 0.3
 * @author Malte
 */
public abstract class Ausgabe {

    /**
     * Das Personen-Objekt wird mit allen Attributen ausgegeben.
     * @param person Das auszugebene Personenobjekt wird übergeben.
     */
    public static void gibAusPerson(Person person) {
        System.out.println(person.toString());

    }

    /**
     * Das Personen-Objekt wird mit allen Attributen, sowie dem Normal- und Idealgewicht ausgegeben.
     * @param person Das auszugebene Personenobjekt wird übergeben.
     */
    public static void gibAusPersonMitGewichten(Person person) {
        System.out.println(person.toString() + getNormalUndIdeal(person));

    }

    /**
     * Das Personen-Objekt wird mit allen Attributen, sowie mit dem Normal- und Idealgewicht und dem BMI-Wert ausgegeben.
     * @param person Das auszugebene Personenobjekt wird übergeben.
     */
    public static void gibAusPersonMitGewichtenUndBmi(Person person) {
        System.out.println("Person: " + person.toString()
                + getNormalUndIdeal(person)
                + "\n\tBMI-Wert: " + person.getBmiWert());

    }

    /**
     *
     * @param person Das auszugebene Personenobjekt wird übergeben.
     */
    private static String getNormalUndIdeal(Person person) {
        String value = "\n\tNormalgewicht: " + person.getNormalgewicht() + " kg"
                     + "\n\tIdealgewicht: " + person.getIdealgweicht() + " kg";

        return value;
    }
}
