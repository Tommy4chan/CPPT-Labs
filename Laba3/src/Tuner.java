import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Class <code>Tuner</code> implements Source and extends TV
 */
public class Tuner extends TV implements Source {

    enum Sources {
        TELEVISION, ANDROIDTV
    };

    private Sources source;
    private int channelNumber;
    private int maxChannelNumber;

    /**
     * Constructor
     * 
     * @throws FileNotFoundException
     */
    public Tuner() throws FileNotFoundException {
        androidTV = new AndroidTV();
        screen = new Screen();
        speakers = new Speakers();
        isEnabled = false;
        source = Sources.TELEVISION;
        channelNumber = 0;
        maxChannelNumber = 100;

        file = new PrintWriter(new File("Log.txt"));
    }

    /**
     * Constructor
     * 
     * @param ssid             WIFI SSID
     * @param password         WIFI password
     * @param screenType       Type of screen
     * @param volume           Base television volume
     * @param maxVolume        Max television volume
     * @param maxChannelNumber Max channel number
     * @throws FileNotFoundException
     */
    public Tuner(String ssid, String password, int screenType, int volume, int maxVolume, int maxChannelNumber)
            throws FileNotFoundException {
        androidTV = new AndroidTV(ssid, password);
        screen = new Screen(screenType);
        speakers = new Speakers(volume, maxVolume);
        isEnabled = false;
        source = Sources.TELEVISION;
        channelNumber = 0;
        this.maxChannelNumber = maxChannelNumber;

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
     * Method open app by id
     * 
     * @param app
     */
    public void openApp(int app) {
        if (source == Sources.ANDROIDTV)
            file.println(androidTV.openApp(app));
        else
            file.println("Change source to Android TV");

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
        file.println("Source: " + source);
        file.println("Channel number: " + channelNumber);
        file.println("Opened App: " + androidTV.getOpenedApp());
        file.println();
        file.flush();
    }

    /**
     * Method change television source
     * 
     * @param source
     */
    public void changeSource(int source) {
        if (source < 0) {
            source = 0;
        } else if (source > 1) {
            source = 1;
        }
        this.source = Sources.values()[source];

        file.println("Source changed to " + this.source);

        file.println();
        file.flush();
    }

    /**
     * Method go to next channel
     */
    public void nextChannel() {
        changeChannel(channelNumber + 1);
    }

    /**
     * Method go to previous channel
     */
    public void previousChannel() {
        changeChannel(channelNumber - 1);
    }

    /**
     * Method change channel
     * 
     * @param channel
     */
    public void changeChannel(int channel) {
        if (source == Sources.TELEVISION) {
            channelNumber = channel;

            if (channelNumber < 0) {
                channelNumber = maxChannelNumber;
            } else if (channelNumber > maxChannelNumber) {
                channelNumber = 0;
            }

            file.println("Channel changed to " + channelNumber);
        } else
            file.println("Change source to Televison");

        file.println();
        file.flush();
    }
}
