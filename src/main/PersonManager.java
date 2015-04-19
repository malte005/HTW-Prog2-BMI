/**
 * main Main-Package
 */
package main;

import bmi.Ausgabe;
import bmi.Eingabe;
import bmi.Person;

/**
 * @version 0.1
 * @author Malte
 */
public class PersonManager {

    public static final int MAXPERSONEN = 100;
    private static Person[] personenArray = new Person[100];
    static boolean auswahl;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // init
        PersonManager pm = new PersonManager();
        Eingabe.init();
        
//        pm.testeAusgabePerson();
//        pm.testeEingabePerson();
        pm.testeArrayPersonenFuellen();
        boolean hinzu = pm.testePersonHinzufuegenZumArray();
        if(!hinzu)
            System.err.println("Kann nicht hinzugefügt werden");
        pm.testeAusgabeArray();

        for (int i = 0; i < 10; i++) {
            personenArray[i] = new Person(String.valueOf(i) + ".");
        }

        System.out.println(menuVorab());
        auswahl = Eingabe.liesAuswahl();

        if (auswahl) {

        } else {

        }
    }

    private static String menuVorab() {
        String value = "";
        value += "Hallo. Es wurde 10 Personen angelegt. Du kannst weitere Personen anlegen wenn du möchtest.";
        value += "\nDas Array hat folgende einträge: \n";

        for (int i = 0; i < 10; i++) {
            value += personenArray[i].getName() + "\n";
        }

        value += "Möchtest du noch mehr Personen hinzufügen? (j/n)";
        return value;
    }

    public void testeAusgabePerson() {
        Person p = new Person();
        Ausgabe.gibAusPerson(p);
    }

    public void testeEingabePerson() {
        Person p = Eingabe.liesPersonen();
        Ausgabe.gibAusPerson(p);

    }

    public void testeAusgabeArray() {
        for (int i = 0; i < personenArray.length; i++) {
            if (personenArray[i] != null) {
                Ausgabe.gibAusPerson(personenArray[i]);        
            }
        }
    }

    public void testeArrayPersonenFuellen() {
        for (int i = 0; i < personenArray.length; i++) {
            if (i < 10) {
                personenArray[i] = new Person();
            } else {
                personenArray[i] = null;
            }
        }
    }
    
    public boolean testePersonHinzufuegenZumArray(){
        boolean gefunden = false;
        Person p = Eingabe.liesPersonen();
        
        for(int i = 0; i <personenArray.length; i++){
            if(personenArray[i] == null){
                personenArray[i] = p;
                gefunden = true;
                break;
            }
        }
        
        return gefunden;
    }

}
