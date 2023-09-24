from enum import Enum

class Screen:

    class Types(Enum):
        HOME = 0
        NETFLIX = 1
        YOUTUBE = 2
        MEGOGO = 3

    class Modes(Enum):
        STANDART = 0
        MOVIE = 1
        GAMING = 2

    #Constructor
    def __init__(self, type = 0):
        self.__type = self.Types(type)
        self.__mode = self.Modes.STANDART

    #Method change screen mode
    def setMode(self, mode):
        self.__mode = self.Modes(mode)

    #Return screen type
    def getType(self):
        return self.__type.name
    
    #Return screen mode
    def getMode(self):
        return self.__mode.name

