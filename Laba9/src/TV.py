from src.AndroidTV import AndroidTV
from src.Screen import Screen
from src.Speakers import Speakers

class TV:
    
    #Constructor
    def __init__(self, ssid = "test", password = "test", type = 0, volume = 10, maxVolume = 100):
        self.__androidTV = AndroidTV(ssid, password)
        self.__screen = Screen(type)
        self.__speakers = Speakers(volume, maxVolume)
        self.__isEnabled = False

    #Method change televison state from off to on
    def turnOn(self):
        self.__androidTV.connectToWifi()
        self.__isEnabled = True

        print("TV enabled")
        print()

    #Method change televison state from on to off
    def turnOff(self):
        self.__isEnabled = False

        print("TV disabled")
        print()

    #Method provides screen info
    def getScreenInfo(self):
        print("Screen mode: " + self.__screen.getMode() + "\nScreen type: " + self.__screen.getType())
        print()
    
    #Method provides screen mode
    def getScreenMode(self):
        print("Screen mode: " + self.__screen.getMode())
        print()

    #Method change screen mode by id
    def changeScreenMode(self, mode):
        if mode < 0:
            mode = 0
        elif mode > 2:
            mode = 2

        self.__screen.setMode(mode)

    #Method connect televison to wifi
    def connectToWifi(self):
        self.__androidTV.connectToWifi()

        print(self.__androidTV.getWifiStatus())
        print()
    
    #Method change WIFI credentials
    def changeWifiCredentials(self, ssid, password):
        self.__androidTV.setWifiSSID(ssid)
        self.__androidTV.setWifiPassword(password)

        print("Wifi credentials changed")
        print()

    #Method open app by id
    def openApp(self, appIndex):
        print(self.__androidTV.openApp(appIndex))
        print()

    #Method increase television volume
    def increaseVolume(self):
        self.__speakers.increaseVolume()

        print("Volume increased to " + str(self.__speakers.getVolume()))
        print()

    #Method decrease television volume
    def decreaseVolume(self):
        self.__speakers.decreaseVolume()

        print("Volume decreased to " + str(self.__speakers.getVolume()))
        print()

    #Method provides televison data
    def getTVData(self):
        print("Screen mode: " + str(self.__screen.getMode()))
        print("Screen type: " + str(self.__screen.getType()))
        print("Volume: " + str(self.__speakers.getVolume()))
        print("Enabled: " + str(self.__isEnabled))
        print("Wifi: " + str(self.__androidTV.getWifiStatus()))
        print("Opened App: " + str(self.__androidTV.getOpenedApp()))
        print()

    