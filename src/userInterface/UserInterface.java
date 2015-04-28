/**
 * userInterfaces Hier befinden sich alle Klassen die mit dem User-Interface zu
 * tun haben.
 */
package userInterface;

import exceptions.InputException;
import objects.Person;

/**
 * Beschreibung: Diese Klasse handelt die Gewichtsausgabe einer Person.
 *
 * @author Malte Dammann E-Mail: s0549309@htw-berlin.de Bearbeitungszeitraum:
 * 22.04.15 - 28.04.2015
 *
 * Modul: Programmierung 2
 *
 * Dateiname: Engine.java IDE: NetBeans IDE 8.0.2 Java: 1.8.0_20; Java
 * HotSpot(TM) 64-Bit
 *
 * @since 2015-04-22
 * @version 0.5
 *
 */
public class UserInterface {

    public static final int MAXPERSONEN = 100;
    private static final Person[] PERSONEN_ARRAY = new Person[MAXPERSONEN];
    private static boolean auswahlMehrPersonenEinlesen, auswahlAllePersonenAusgeben, loopMehrPersonen;
    private static int auswahlDetailierung, index, freeIndex;
    private int counter = 10;

    /**
     * Hauptmethode, in der die User-Interaktion stattfindet.
     *
     * @throws java.lang.Exception
     */
    public void start() throws Exception {

        boolean weiter = false, weiter1 = false;

        // Initialisierung des Scanners
        Eingabe.init();

        menuBegruessung();
        menuAuswahlPersonenHinzufuegen();

        if (auswahlMehrPersonenEinlesen) {
            //Personen hinzufügen
            do {
                freeIndex = getFirstFreeIndex();
                try {
                    PERSONEN_ARRAY[freeIndex] = Eingabe.liesPerson();
                    counter++;
                } catch (InputException e) {
                    System.err.println("Eingabe: Bitte korrekte Daten eingeben...");
                }

                if (counter < MAXPERSONEN) {
                    do {
                        menuAusgabe("Willst du noch eine weitere Person hinzufügen? (ja = true / nein = false)");
                        try {
                            loopMehrPersonen = Eingabe.liesAuswahlBoolean();
                            weiter1 = true;
                        } catch (InputException e) {
                            System.err.println("Bitte einen Boolean eingeben...");
                            weiter1 = false;
                        }
                    } while (!weiter1);
                } else {
                    loopMehrPersonen = false;
                    System.err.println("Maximnale Anzahl für das Array ist erreicht.");
                }
            } while (loopMehrPersonen);

        }

        menuAuswahlPersonenAusgeben();

        if (auswahlAllePersonenAusgeben) {
            // Alle Personen ausgeben
            menuAuswahlDetailierung();
            ausgabeArray(auswahlDetailierung);

        } else {
            // Nur eine bestimmte Person ausgeben  
            do {
                menuAuswahlDetailierung();
                menuIndex();
                try {
                    switch (auswahlDetailierung) {
                        case 1:
                            Ausgabe.gibAusPerson(PERSONEN_ARRAY[index]);
                            weiter = true;
                            break;
                        case 2:
                            Ausgabe.gibAusPersonMitGewichten(PERSONEN_ARRAY[index]);
                            weiter = true;
                            break;
                        case 3:
                            Ausgabe.gibAusPersonMitGewichtenUndBmi(PERSONEN_ARRAY[index]);
                            weiter = true;
                            break;
                        default:
                            System.err.println("Falsche Zahl wurde eingegeben...");
                            weiter = false;
                            break;
                    }
                } catch (Exception e) {
                    System.err.println("Index ist nicht gültig: Bitte eine ganze Zahl zwischen 0 und " + getUsedIndizes() + " eingeben...");
                    weiter = false;
                }
            } while (!weiter);
        }
    }

    private void menuBegruessung() {
        erzeugePersonen();
        menuAusgabe("Hallo. Es wurden 10 Personen angelegt. Du kannst weitere Personen anlegen wenn du möchtest.");
    }

    private void menuAuswahlPersonenHinzufuegen() throws InputException {
        boolean ok = false;
        menuAusgabe("Möchtest du noch mehr Personen hinzufügen? (true / false)");

        do {
            try {
                auswahlMehrPersonenEinlesen = Eingabe.liesAuswahlBoolean();
                ok = true;
            } catch (InputException e) {
                System.err.println("Eingabe: Bitte einen Boolean(true/false) eingeben...");
                ok = false;
            }
        } while (!ok);
    }

    private void menuAuswahlPersonenAusgeben() throws InputException {
        boolean ok = false;
        menuAusgabe("Sollen alle Personen ausgegeben werden oder nur eine bestimmte? (true = alle / false = eine)");

        do {
            try {
                auswahlAllePersonenAusgeben = Eingabe.liesAuswahlBoolean();
                ok = true;
            } catch (InputException e) {
                System.err.println("Eingabe: Bitte einen Boolean(true/false) eingeben...");
                ok = false;
            }
        } while (!ok);
    }

    private void menuAuswahlDetailierung() throws InputException {
        boolean ok = false;
        menuAusgabe("Wie detailiert soll die Ausgabe sein? "
                + "\n 1 = nur Personendaten \n 2 = Personendaten mit Ideal- und Normalgewicht \n 3 = Personendaten, Ideal- und Normalgewicht und BMI-Wert");

        do {
            try {
                auswahlDetailierung = Eingabe.liesAuswahlZahl();
                if (auswahlDetailierung >= 1 && auswahlDetailierung <= 3) {
                    ok = true;
                } else {
                    ok = false;
                    System.err.println("Eingabe: Bitte eine Zahl von 1 - 3 eingeben...");
                }

            } catch (InputException e) {
                System.err.println("Eingabe: Bitte eine Zahl von 1 - 3 eingeben...");
                ok = false;
            }
        } while (!ok);
    }

    private void menuIndex() throws InputException {
        boolean ok = false;
        menuAusgabe("Welche Person soll ausgegeben werden? (Index eingeben von 0 bis " + getUsedIndizes() + ")");

        do {
            try {
                index = Eingabe.liesAuswahlZahl();
                ok = true;
            } catch (InputException e) {
                System.err.println("Eingabe: Bitte eine Zahl von 0 - " + getUsedIndizes() + " eingeben...");
                ok = false;
            }
        } while (!ok);
    }

    private void menuAusgabe(String value) {
        System.out.println(value);
    }

    private void erzeugePersonen() {
        for (int i = 0; i < 10; i++) {
            Person temp_person = new Person();
            String temp_name = temp_person.getName();
            temp_person.setName(i + ". " + temp_name);
            PERSONEN_ARRAY[i] = temp_person;
        }
    }

    /**
     *
     * @return Index der ersten freien Stelle im Array.
     */
    private int getFirstFreeIndex() {
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
     * @return Anzahl der belegten Specihereinheiten in dem Array
     * PERSONEN_ARRAY.
     */
    private int getUsedIndizes() {
        int anzahl = 0;

        for (Person PERSONEN_ARRAY_LOOP : PERSONEN_ARRAY) {
            if (PERSONEN_ARRAY_LOOP != null) {
                anzahl++;
            }
        }

        return anzahl - 1;
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
                    default:
                        break;
                }
            }
        }
    }

}
