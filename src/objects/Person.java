/**
 * bmi Packet in dem sich die Objektklassen befniden.
 */
package objects;

import bmiHelper.Bmi;

/**
 * @version 0.2
 * @author Malte
 */
public class Person {

    //Attribute
    private String name;
    private boolean geschlecht; //Mann = true
    private int koerperGroesse; // in cm
    private float koerperGewicht; // in kg
    
    private final Bmi BMI = new Bmi();

    //Konstruktoren
    public Person() {
        this("Mustermann", true, 190, 90.0f);
    }

    /**
     *
     * @param name Der Name der Person.
     */
    public Person(String name) {
        this(name, true, 190, 90.0f);
    }

    /**
     *
     * @param name Der Name der Person.
     * @param koerperGroesse Die Größer der Person in cm.
     */
    public Person(String name, int koerperGroesse) {
        this(name, true, koerperGroesse, 90.0f);
    }

    /**
     *
     * @param name Der Name der Person.
     * @param koerperGroesse Die Größer der Person in cm.
     * @param koerperGewicht Das Körpergewicht der Person in kg.
     */
    public Person(String name, int koerperGroesse, float koerperGewicht) {
        this(name, true, koerperGroesse, koerperGewicht);
    }

    /**
     *
     * @param name Der Name der Person.
     * @param geschlecht Das Geschlecht der Person (Mann = true / Frau = false).
     * @param koerperGroesse Die Größer der Person in cm.
     * @param koerperGewicht Das Körpergewicht der Person in kg.
     */
    public Person(String name, boolean geschlecht, int koerperGroesse, float koerperGewicht) {
        super();
        this.name = name;
        this.geschlecht = geschlecht;
        this.koerperGroesse = koerperGroesse;
        this.koerperGewicht = koerperGewicht;
    }

    /**
     *
     * @return Der Name der Person wird zurückgegeben.
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name Der Name der Person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return Das Geschlecht der Person wird zurückgegeben (Mann = true / Frau = false).
     */
    public boolean isGeschlecht() {
        return geschlecht;
    }

    /**
     *
     * @param geschlecht Das Geschlecht der Person (Mann = true / Frau = false).
     */
    public void setGeschlecht(boolean geschlecht) {
        this.geschlecht = geschlecht;
    }

    /**
     *
     * @return Die Körpergröße der Person in cm wird zurückgegeben.
     */
    public int getKoerperGroesse() {
        return koerperGroesse;
    }

    /**
     *
     * @param koerperGroesse Die Körpergröße der Person in cm.
     */
    public void setKoerperGroesse(int koerperGroesse) {
        this.koerperGroesse = koerperGroesse;
    }

    /**
     *
     * @return Das Körpergewicht der Person in kg wird zurückgegeben.
     */
    public float getKoerperGewicht() {
        return koerperGewicht;
    }

    /**
     *
     * @param koerperGewicht Das Körpergewicht der Person in kg.
     */
    public void setKoerperGewicht(float koerperGewicht) {
        this.koerperGewicht = koerperGewicht;
    }

    /**
     *
     * @return Den BMI-Wert der Person.
     */
    public float getBmiWert() {
        return BMI.getBmiWert(this.koerperGewicht, this.koerperGroesse);
    }

    /**
     *
     * @return Das Idealgewicht der Person in kg.
     */
    public float getIdealgweicht() {
        return BMI.getIdealGewicht(this.geschlecht, getNormalgewicht());
    }

    /**
     *
     * @return Das Normalgewicht der Person in kg.
     */
    public float getNormalgewicht() {
        return BMI.getNormalGewicht(this.koerperGroesse);
    }

    @Override
    public String toString() {
        String temp = "Person{" + "name=" + name
                + ", koerperGroesse=" + koerperGroesse + " cm"
                + ", koerperGewicht=" + koerperGewicht + " kg";

        if (geschlecht == true) {
            temp += ", geschlecht=Mann }";
        } else {
            temp += ", geschlecht=Frau }";
        }

        return temp;
    }

}
