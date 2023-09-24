/**
 * Class <code>Screen</code> implements screen of television
 */
public class Screen {

    enum Types {
        IPS, OLED, AMOLED, RETINA
    };

    enum Modes {
        STANDART, MOVIE, GAMING
    };

    private Types type;
    private Modes mode;

    /**
     * Constructor
     */
    public Screen() {
        type = Types.IPS;
        mode = Modes.STANDART;
    }

    /**
     * Constructor
     * 
     * @param t Screen type
     */
    public Screen(int t) {
        if (t < 0) {
            t = 0;
        } else if (t > 3) {
            t = 3;
        }
        type = Types.values()[t];
        mode = Modes.STANDART;
    }

    /**
     * Method change screen mode to standart
     */
    public void setStandartMode() {
        mode = Modes.STANDART;
    }

    /**
     * Method change screen mode to movie
     */
    public void setMovieMode() {
        mode = Modes.MOVIE;
    }

    /**
     * Method change screen mode to gaming
     */
    public void setGamingMode() {
        mode = Modes.GAMING;
    }

    /**
     * Return screen type
     * 
     * @return Types
     */
    public Types getType() {
        return type;
    }

    /**
     * Return screen mode
     * 
     * @return Modes
     */
    public Modes getMode() {
        return mode;
    }
}
