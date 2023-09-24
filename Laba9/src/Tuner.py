from src.TV import TV
from enum import Enum

class Tuner(TV):

    class Sources(Enum):
        TELEVISION = 0
        ANDROIDTV = 1

    #Constructor
    def __init__(self, ssid = "test", password = "test", type = 0, volume = 10, maxVolume = 100, maxChannelNumber = 100):
        super().__init__(ssid, password, type, volume, maxVolume)
        self.__source = self.Sources.TELEVISION
        self.__channelNumber = 0
        self.__maxChannelNumber = maxChannelNumber

    #Method open app by id
    def openApp(self, appIndex):
        if self.__source == self.Sources.ANDROIDTV:
            print(self._TV__androidTV.openApp(appIndex))
        else:
            print("Change source to Android TV")
        print()

    #Method provides televison data
    def getTVData(self):
        print("Screen mode: " + str(self._TV__screen.getMode()))
        print("Screen type: " + str(self._TV__screen.getType()))
        print("Volume: " + str(self._TV__speakers.getVolume()))
        print("Enabled: " + str(self._TV__isEnabled))
        print("Wifi: " + str(self._TV__androidTV.getWifiStatus()))
        print("Source: " + str(self.__source.name))
        print("Channel Number: " + str(self.__channelNumber))
        print("Opened App: " + str(self._TV__androidTV.getOpenedApp()))
        print()

    #Method change television source
    def changeSource(self, source):
        if (source < 0):
            source = 0
        elif (source > 1):
            source = 1

        self.__source = self.Sources(source)

        print("Source changed to " + self.__source.name)
        print()

    #Method go to next channel
    def nextChannel(self):
        self.changeChannel(self.__channelNumber + 1)

    #Method go to previous channel
    def previousChannel(self):
        self.changeChannel(self.__channelNumber - 1)

    #Method change channel
    def changeChannel(self, channel):
        if self.__source == self.Sources.TELEVISION:
            self.__channelNumber = channel;

            if self.__channelNumber < 0:
                self.__channelNumber = self.__maxChannelNumber;
            elif self.__channelNumber > self.__maxChannelNumber:
                self.__channelNumber = 0

            print("Channel changed to " + str(self.__channelNumber));
        else:
            print("Change source to Televison");
        print()