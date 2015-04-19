/**
 * bmi Alle Klassen zum Berechnen des BMIs
 */
package bmi;

/**
 * @version 0.1
 * @author Malte
 */
public class Person {

    private String name = null;
    private boolean geschlecht = true; //Mann = true
    private int koerperGroesse = 0; // in cm
    private float koerperGewicht = 0.0f; // in kg
    
    private Bmi bmi = new Bmi();

    public Person() {
        this("Mustermann", 190, 90.0f);
    }

    /**
     *
     * @param name
     */
    public Person(String name) {
        this(name, 190, 90.0f);
    }

    /**
     *
     * @param name
     * @param koerperGroesse
     */
    public Person(String name, int koerperGroesse) {
        this(name, koerperGroesse, 90.0f);
    }

    /**
     *
     * @param name
     * @param koerperGroesse
     * @param koerperGewicht
     */
    public Person(String name, int koerperGroesse, float koerperGewicht) {
        super();
        this.name = name;
        this.koerperGroesse = koerperGroesse;
        this.koerperGewicht = koerperGewicht;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public boolean isGeschlecht() {
        return geschlecht;
    }

    /**
     *
     * @param geschlecht
     */
    public void setGeschlecht(boolean geschlecht) {
        this.geschlecht = geschlecht;
    }

    /**
     *
     * @return
     */
    public int getKoerperGroesse() {
        return koerperGroesse;
    }

    /**
     *
     * @param koerperGroesse
     */
    public void setKoerperGroesse(int koerperGroesse) {
        this.koerperGroesse = koerperGroesse;
    }

    /**
     *
     * @return
     */
    public float getKoerperGewicht() {
        return koerperGewicht;
    }

    /**
     *
     * @param koerperGewicht
     */
    public void setKoerperGewicht(float koerperGewicht) {
        this.koerperGewicht = koerperGewicht;
    }

    /**
     *
     * @return
     */
    private int berechneMeinGwewicht() {
        return 1;
    }

    /**
     *
     * @return
     */
    public double getBmiWert() {
        return bmi.getBmiWert(this.koerperGewicht, this.koerperGroesse);
    }

    /**
     *
     * @return
     */
    public float getIdealgweicht() {
        return bmi.getIdealGewicht(this.geschlecht, this.koerperGroesse);
    }

    /**
     *
     * @return
     */
    public float getNormalgewicht() {
        return bmi.getNormalGewicht(this.koerperGroesse);
    }

    @Override
    public String toString() {
        String temp = "Person{" + "name=" + name
                + ", geschlecht=" + geschlecht
                + ", koerperGroesse=" + koerperGroesse
                + ", koerperGewicht=" + koerperGewicht;

        if (geschlecht == true) {
            temp += ", geschlecht=Mann }";
        } else {
            temp += ", geschlecht=Frau }";
        }

        return temp;
    }

}
