/**
 * bmiHelper Package in der sich der Helper-Klassen befinden.
 */
package bmiHelper;

/**
 * Beschreibung:
 * Helper-Klasse um die Gewichte auszurechnen.
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
 * @version 0.8
 *
 */
public abstract class Bmi {

    private static float bmiWert;
    private static float idealGewicht;
    private static float normalGewicht;

    /**
     *
     * @param koerperGewicht Das Körpergewicht der Person in kg.
     * @param koerperGroesse Die Körpergröße der Person in cm.
     * @return Der BMI-Wert wird zurückgegeben.
     */
    public static float getBmiWert(float koerperGewicht, int koerperGroesse) {
        bmiWert = koerperGewicht / ((koerperGroesse * koerperGroesse) / (float)10000);
        return bmiWert;
    }

    /**
     *
     * @param geschlecht Das Geschlecht der Person als Boolean (Mann = true / Frau = false).
     * @param normalGewicht Das Berechnete Normalgewicht der Person in kg.
     * @return Das Idealgewicht der Person wird in kg zurückgegeben.
     */
    public static float getIdealGewicht(boolean geschlecht, float normalGewicht) {
        if (geschlecht) {
            idealGewicht = (float) (normalGewicht * 0.9);
        } else {
            idealGewicht = (float) (normalGewicht * 0.85);
        }

        return idealGewicht;
    }

    /**
     *
     * @param koerperGroesse Die Körpergröße der Person in cm.
     * @return Das berechnete Normalgewicht der Person wird in kg zurückgegeben.
     */
    public static float getNormalGewicht(int koerperGroesse) {
        normalGewicht = koerperGroesse - 100;
        return normalGewicht;
    }

}
