import java.io.PrintWriter;

/**
 * Abstract class <code>TV</code> implements television
 */
public abstract class TV {
    protected AndroidTV androidTV;
    protected Screen screen;
    protected Speakers speakers;
    protected PrintWriter file;

    boolean isEnabled;

    abstract public void turnOn();

    abstract public void turnOff();

    /**
     * Method provides screen info in logs
     */
    public void getScreenInfo() {
        file.println("Screen mode: " + screen.getMode());
        file.println("Screen type: " + screen.getType());
        file.println();
        file.flush();
    }

    /**
     * Method provides screen mode in logs
     */
    public void getScreenMode() {
        file.println("Screen mode is set to " + screen.getMode());
        file.println();
        file.flush();
    }

    /**
     * Method change screen mode by id
     * 
     * @param mode
     */
    public void changeScreenMode(int mode) {
        if (mode == 1) {
            screen.setMovieMode();
        } else if (mode == 2) {
            screen.setGamingMode();
        } else {
            screen.setStandartMode();
        }

        file.println("Screen mode changed to " + screen.getMode());
        file.println();
        file.flush();
    }

    /**
     * Method connect televison to wifi
     */
    public void connectToWifi() {
        androidTV.connectToWifi();

        file.println(androidTV.getWifiStatus());
        file.println();
        file.flush();
    }

    /**
     * Method change WIFI credentials
     * 
     * @param ssid
     * @param password
     */
    public void changeWifiCredentials(String ssid, String password) {
        androidTV.setWifiSSID(ssid);
        androidTV.setWifiPassword(password);
        file.println("Wifi credentials changed to SSID:" + ssid + " Password: " + password);
        file.println();
        file.flush();
    }

    abstract public void openApp(int app);

    /**
     * Method increase television volume
     */
    public void increaseVolume() {
        speakers.increaseVolume();

        file.println("Volume increased to " + speakers.getVolume());
        file.println();
        file.flush();
    }

    /**
     * Method decrease television volume
     */
    public void decreaseVolume() {
        speakers.decreaseVolume();

        file.println("Volume decreased to " + speakers.getVolume());
        file.println();
        file.flush();
    }

    abstract public void getTVData();

    /**
     * Method releases used recourses
     */
    public void dispose() {
        file.close();
    }
}
