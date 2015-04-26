package bmiHelper;

/**
 * @version 0.2
 * @author Malte
 */
public class Bmi {

    private float bmiWert;
    private float idealGewicht;
    private float normalGewicht;

    /**
     *
     * @param koerperGewicht Das Körpergewicht der Person in kg.
     * @param koerperGroesse Die Körpergröße der Person in cm.
     * @return Der BMI-Wert wird zurückgegeben.
     */
    public float getBmiWert(float koerperGewicht, int koerperGroesse) {
        bmiWert = koerperGewicht / ((koerperGroesse * koerperGroesse)/10000);
        return bmiWert;
    }

    /**
     *
     * @param geschlecht Das Geschlecht der Person als Boolean (Mann = true / Frau = false).
     * @param normalGewicht Das Berechnete Normalgewicht der Person in kg.
     * @return Das Idealgewicht der Person wird in kg zurückgegeben.
     */
    public float getIdealGewicht(boolean geschlecht, float normalGewicht) {
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
    public float getNormalGewicht(int koerperGroesse) {
        normalGewicht = koerperGroesse - 100;
        return normalGewicht;
    }

}
