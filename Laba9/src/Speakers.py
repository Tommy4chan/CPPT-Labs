class Speakers:

    #Constructor
    def __init__(self, volume = 10, maxVolume = 100):
        self.__volume = volume
        self.__maxVolume = maxVolume

    #Return volume
    def getVolume(self):
        return self.__volume
    
    #Method increase speakers volume
    def increaseVolume(self):
        self.__volume += 1

        if self.__volume > self.__maxVolume:
            self.__volume = self.__maxVolume;

    #Method decrease speakers volume
    def decreaseVolume(self):
        self.__volume -= 1

        if self.__volume < 0:
            self.__volume = 0;