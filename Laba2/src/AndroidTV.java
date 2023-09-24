/**
 * Class <code>AndroidTV</code> implements AndroidTV OS of television
 */
public class AndroidTV {

    enum Apps {
        HOME, NETFLIX, YOUTUBE, MEGOGO
    };

    private Apps app;
    private String wifiSSID;
    private String wifiPassword;
    private boolean isWifiConnected;

        /**
     * Constructor
     */
    public AndroidTV() {
        app = Apps.HOME;
        wifiSSID = "test";
        wifiPassword = "test";
        isWifiConnected = false;
    }

    /**
     * Constructor
     * 
     * @param ssid WIFI SSID
     * @param ssid WIFI password
     */
    public AndroidTV(String ssid, String password) {
        app = Apps.HOME;
        wifiSSID = ssid;
        wifiPassword = password;
        isWifiConnected = false;
    }
    
    /** 
     * Return current opened app
     * @return Apps
     */
    public Apps getOpenedApp(){
        return app;
    }

    /** 
     * Method opens app by app id
     * @param appIndex app id
     */
    public String openApp(int appIndex) {
        if (isWifiConnected) {
            if (appIndex < 0) {
                appIndex = 0;
            } else if (appIndex > 3) {
                appIndex = 3;
            }
            app = Apps.values()[appIndex];
            return app + " opened successfully";
        }
        return app + " not opened";
    }

    /** 
     * Method is used for changing WIFI SSID
     * @param ssid
     */
    public void setWifiSSID(String ssid) {
        isWifiConnected = false;
        wifiSSID = ssid;
    }

    
    /** 
     * Method is used for changing WIFI password
     * @param password
     */
    public void setWifiPassword(String password) {
        isWifiConnected = false;
        wifiPassword = password;
    }

    /** 
     * Method is used for connecting to WIFI
     */
    public void connectToWifi() {
        if (!wifiSSID.isEmpty() && !wifiPassword.isEmpty())
            isWifiConnected = true;
        
    }

    /** 
     * Method returns wifi status
     */
    public String getWifiStatus(){
        if(isWifiConnected)
            return "Wifi connected";
        return "Wifi not connected";
    }
}
