/**
 * Class <code>Speakers</code> implements speakers of television
 */
public class Speakers {

    private int volume;
    private int maxVolume;

    /**
     * Constructor
     */
    public Speakers() {
        volume = 10;
        maxVolume = 100;
    }

    /**
     * Constructor
     * 
     * @param v Base volume
     * @param password Max volume
     */
    public Speakers(int v, int mV) {
        volume = v;
        maxVolume = mV;
    }

    /** 
     * Return volume
     * @return int
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Method increase speakers volume
     */
    public void increaseVolume() {
        volume++;

        if (volume > maxVolume) {
            volume = 100;
        }
    }

    /**
     * Method decrease speakers volume
     */
    public void decreaseVolume() {
        volume--;

        if (volume < 0) {
            volume = 0;
        }
    }

    /**
     * Method mute speakers
     */
    public void mute() {
        volume = 0;
    }
}
