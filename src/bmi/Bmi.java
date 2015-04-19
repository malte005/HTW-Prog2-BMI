package bmi;

/**
 * @version 0.1
 * @author Malte
 */
public class Bmi {

    private float bmiWert;
    private float idealGewicht;
    private float normalGewicht;

    /**
     *
     * @param koerperGewicht
     * @param koerperGroesse
     * @return
     */
    public float getBmiWert(float koerperGewicht, int koerperGroesse) {
        bmiWert = koerperGewicht / (koerperGewicht * koerperGewicht);
        return bmiWert;
    }

    /**
     *
     * @param mann
     * @param koerperGewicht
     * @return
     */
    public float getIdealGewicht(boolean mann, int koerperGewicht) {

        if (mann) {
            idealGewicht = (float) (koerperGewicht * 0.9);
        } else {
            idealGewicht = (float) (koerperGewicht * 0.85);
        }

        return idealGewicht;
    }

    /**
     *
     * @param koerperGroesse
     * @return
     */
    public float getNormalGewicht(int koerperGroesse) {
        normalGewicht = koerperGroesse - 100;
        return koerperGroesse;
    }

}
