package bmi;

/**
 * @version 0.2
 * @author Malte
 */
public class Ausgabe {

    public static void gibAusPerson(Person person) {
        System.out.println(person.toString());

    }

    public static void gibAusPersonMitGewichten(Person person) {
        System.out.println(person.toString() + getNormalUndIdeal(person));

    }

    public static void gibAusPersonMitGewichtenUndBmi(Person person) {
        System.out.println("Person: " + person.toString()
                + getNormalUndIdeal(person)
                + "\n\tBMI-Wert: " + person.getBmiWert());

    }

    private static String getNormalUndIdeal(Person person) {
        String value = "\n\tNormalgewicht: " + person.getNormalgewicht()
                     + "\n\tIdealgewicht: " + person.getIdealgweicht();

        return value;
    }
}
