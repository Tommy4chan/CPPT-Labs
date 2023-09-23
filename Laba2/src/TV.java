import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class <code>TV</code> implements television
 */
public class TV {
    private AndroidTV androidTV;
    private Screen screen;
    private Speakers speakers;
    private PrintWriter file;

    public boolean isEnabled;

    /**
     * Constructor
     * 
     * @throws FileNotFoundException
     */
    public TV() throws FileNotFoundException {
        androidTV = new AndroidTV();
        screen = new Screen();
        speakers = new Speakers();
        isEnabled = false;

        file = new PrintWriter(new File("Log.txt"));
    }

    /**
     * Constructor
     * 
     * @param ssid WIFI SSID
     * @param password WIFI password
     * @param screenType Type of screen
     * @param volume Base television volume
     * @param maxVolume Max television volume
     * @throws FileNotFoundException
     */
    public TV(String ssid, String password, int screenType, int volume, int maxVolume) throws FileNotFoundException {
        androidTV = new AndroidTV(ssid, password);
        screen = new Screen(screenType);
        speakers = new Speakers(volume, maxVolume);
        isEnabled = false;

        file = new PrintWriter(new File("Log.txt"));
    }

    /**
     * Method change televison state from off to on
     */
    public void turnOn() {
        androidTV.connectToWifi();
        isEnabled = true;

        file.println("TV enabled");
        file.println(androidTV.getWifiStatus());
        file.println(androidTV.openApp(0));
        file.println();
        file.flush();
    }

    /**
     * Method change televison state from on to off
     */
    public void turnOff() {
        isEnabled = false;

        file.println("TV disabled");
        file.println();
        file.flush();
    }

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

    /**
     * Method open app by id
     * 
     * @param app
     */
    public void openApp(int app) {
        file.println(androidTV.openApp(app));
        file.println();
        file.flush();
    }

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

    /**
     * Method provides televison data in logs
     */
    public void getTVData() {
        file.println("Screen mode: " + screen.getMode());
        file.println("Screen type: " + screen.getType());
        file.println("Volume: " + speakers.getVolume());
        file.println("Enabled: " + isEnabled);
        file.println("Wifi: " + androidTV.getWifiStatus());
        file.println("Opened App: " + androidTV.getOpenedApp());
        file.println();
        file.flush();
    }

    /**
     * Method releases used recourses
     */
    public void dispose() {
        file.close();
    }
}
