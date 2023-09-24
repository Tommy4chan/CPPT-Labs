from enum import Enum

class AndroidTV:

    class Apps(Enum):
        HOME = 0
        NETFLIX = 1
        YOUTUBE = 2
        MEGOGO = 3

    #Constructor
    def __init__(self, ssid = "test", password = "test"):
        self.__app = self.Apps.HOME
        self.__wifiSSID = ssid
        self.__wifiPassword = password
        self.__isWifiConnected = False

    #Return current opened app
    def getOpenedApp(self):
        return self.__app.name;

    #Method opens app by app id
    def openApp(self, appIndex):
        if self.__isWifiConnected:
            if appIndex < 0:
                appIndex = 0
            elif appIndex > 3:
                appIndex = 3
            self.__app = self.Apps(appIndex);
            return self.__app.name + " opened successfully";
        return self.__app.name + " not opened";
    
    #Method is used for changing WIFI SSID
    def setWifiSSID(self, ssid):
        self.__isWifiConnected = False
        self.__wifiSSID = ssid

    #Method is used for changing WIFI password
    def setWifiPassword(self, password):
        self.__isWifiConnected = False
        self.__wifiPassword = password

    #Method is used for connecting to WIFI
    def connectToWifi(self):
        if len(self.__wifiSSID) != 0 and len(self.__wifiPassword) != 0:
            self.__isWifiConnected = True

    #Method returns wifi status
    def getWifiStatus(self):
        if self.__isWifiConnected:
            return "Wifi connected"
        return "Wifi not connected"