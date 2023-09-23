
/**
 * Class App realize example program for lab 2
 * @author Panurin Anton
 * @version 1.1
 * @since version 1.0
 */


public class App {
    
    /** 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        
        TV television = new TV();
        television.turnOn();
        television.increaseVolume();
        television.getTVData();
        television.openApp(1);
        television.getScreenInfo();
        television.openApp(2);
        television.changeScreenMode(2);
        television.getScreenInfo();
        television.changeScreenMode(124);
        television.decreaseVolume();
        television.decreaseVolume();
        television.changeWifiCredentials("", "123");
        television.openApp(1);
        television.connectToWifi();
        television.changeWifiCredentials("321", "123");
        television.connectToWifi();
        television.openApp(1);
        television.getTVData();
        television.turnOff();
        television.dispose();
    }
}
