/**
 * main Main-Package in der sich der Programmeinstieg befindet.
 */
package userInterface;

import objects.Person;

/**
 * BESCHREIBUNG
 *
 * @author Malte
 * @version 0.1
 */
public class UserInterface {

    public static final int MAXPERSONEN = 100;
    private static final Person[] PERSONEN_ARRAY = new Person[MAXPERSONEN];
    private static boolean auswahlMehrPersonenEinlesen, auswahlAllePersonenAusgeben, loopMehrPersonen;
    private static int auswahlDetailierung, index, freeIndex;

    /**
     * Hauptmethode, in der die User-Interaktion stattfindet.
     *
     * @throws java.lang.Exception
     */
    public void start() throws Exception {

        // init
        Eingabe.init();

        menuBegruessung();
        menuAuswahlPersonenHinzufuegen();

        if (auswahlMehrPersonenEinlesen) {
            //Personen hinzufügen
            do {
                freeIndex = getFreeIndex();
                PERSONEN_ARRAY[freeIndex] = Eingabe.liesPerson();

                menuAusgabe("Willst du noch eine weitere Person hinzufügen? (ja = true / nein = false)");
                loopMehrPersonen = Eingabe.liesAuswahlBoolean();
            } while (loopMehrPersonen);

        }

        menuAuswahlPersonenAusgeben();

        if (auswahlAllePersonenAusgeben) {
            // Alle Personen ausgeben
            menuAuswahlDetailierung();
            ausgabeArray(auswahlDetailierung);

        } else {
            // Nur eine bestimmte Person ausgeben            
            menuIndex();
            menuAuswahlDetailierung();

            try {
                switch (auswahlDetailierung) {
                    case 1:
                        Ausgabe.gibAusPerson(PERSONEN_ARRAY[index]);
                        break;
                    case 2:
                        Ausgabe.gibAusPersonMitGewichten(PERSONEN_ARRAY[index]);
                        break;
                    case 3:
                        Ausgabe.gibAusPersonMitGewichtenUndBmi(PERSONEN_ARRAY[index]);
                        break;
                    default:
                        System.err.println("");
                        break;
                }
            } catch (Exception e) {
                System.err.println("Index ist nicht gültig - " + e.getMessage());
            }
        }
    }

    private static void menuBegruessung() {
        erzeugePersonen();
        menuAusgabe("Hallo. Es wurde 10 Personen angelegt. Du kannst weitere Personen anlegen wenn du möchtest.");
    }

    private static void menuAuswahlPersonenHinzufuegen() {
        menuAusgabe("Möchtest du noch mehr Personen hinzufügen? (true / false)");
        auswahlMehrPersonenEinlesen = Eingabe.liesAuswahlBoolean();
    }

    private static void menuAuswahlPersonenAusgeben() {
        menuAusgabe("Sollen alle Personen ausgegeben werden oder nur eine bestimmte? (true = alle / false = eine)");
        auswahlAllePersonenAusgeben = Eingabe.liesAuswahlBoolean();
    }

    private static void menuAuswahlDetailierung() {
        menuAusgabe("Wie detailiert soll die Ausgabe sein? "
                + "\n 1 = nur Personendaten \n 2 = Personendaten mit Ideal- und Normalgewicht \n 3 = Personendaten, Ideal- und Normalgewicht und BMI-Wert");
        auswahlDetailierung = Eingabe.liesAuswahlZahl();
    }

    private static void menuIndex() {
        menuAusgabe("Welche Person soll ausgegeben werden? (Index eingeben)");
        index = Eingabe.liesAuswahlZahl();
    }

    private static void menuAusgabe(String value) {
        System.out.println(value);
    }

    private static void erzeugePersonen() {
        for (int i = 0; i < 10; i++) {
            PERSONEN_ARRAY[i] = new Person();
        }
    }

    /**
     *
     * @return Index der ersten freien Stelle im Array
     */
    private int getFreeIndex() {
        int value = 0;

        for (int i = 0; i < PERSONEN_ARRAY.length; i++) {
            if (PERSONEN_ARRAY[i] == null) {
                value = i;
                break;
            }
        }

        return value;
    }

    /**
     *
     * @param index Index der Detailierung geht von 1 bis 3.
     */
    public void ausgabeArray(int index) {
        for (Person PERSONEN_ARRAY_LOOP : PERSONEN_ARRAY) {
            if (PERSONEN_ARRAY_LOOP != null) {

                switch (index) {
                    case 1:
                        Ausgabe.gibAusPerson(PERSONEN_ARRAY_LOOP);
                        break;
                    case 2:
                        Ausgabe.gibAusPersonMitGewichten(PERSONEN_ARRAY_LOOP);
                        break;
                    case 3:
                        Ausgabe.gibAusPersonMitGewichtenUndBmi(PERSONEN_ARRAY_LOOP);
                        break;
                }
            }
        }
    }

}
