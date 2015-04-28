/**
 * userInterfaces Hier befinden sich alle Klassen die mit dem User-Interface zu tun haben.
 */
package userInterface;

import objects.Person;

/**
 * Beschreibung:
 * Diese Klasse handelt die Gewichtsausgabe einer Person.
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
 * @version 0.3
 *
 */
public abstract class Ausgabe {

    /**
     * Das Personen-Objekt wird mit allen Attributen ausgegeben.
     * @param person Das auszugebene Personenobjekt wird übergeben.
     */
    public static void gibAusPerson(Person person) {
        System.out.println(person.toString() + "\n\t-------------------" );

    }

    /**
     * Das Personen-Objekt wird mit allen Attributen, sowie dem Normal- und Idealgewicht ausgegeben.
     * @param person Das auszugebene Personenobjekt wird übergeben.
     */
    public static void gibAusPersonMitGewichten(Person person) {
        System.out.println(person.toString() + getNormalUndIdeal(person) + "\n\t-------------------");

    }

    /**
     * Das Personen-Objekt wird mit allen Attributen, sowie mit dem Normal- und Idealgewicht und dem BMI-Wert ausgegeben.
     * @param person Das auszugebene Personenobjekt wird übergeben.
     */
    public static void gibAusPersonMitGewichtenUndBmi(Person person) {
        System.out.println(person.toString()
                + getNormalUndIdeal(person)
                + "\n\t-> BMI-Wert: " + person.getBmiWert() + "\n\t-------------------");

    }

    /**
     * @param person Das auszugebene Personenobjekt wird übergeben.
     * @return       Der zusammengesetzten String aus Normalgewicht und Idealgewicht wird zurückgegeben.
     */
    private static String getNormalUndIdeal(Person person) {
        String value = "\n\t-> Normalgewicht: " + person.getNormalgewicht() + " kg"
                     + "\n\t-> Idealgewicht: " + person.getIdealgweicht() + " kg";

        return value;
    }
}
