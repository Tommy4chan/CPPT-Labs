from src.Tuner import Tuner

if __name__ == "__main__":
    television = Tuner()
    television.turnOn()
    television.increaseVolume()
    television.nextChannel()
    television.nextChannel()
    television.changeChannel(213)
    television.getTVData()
    television.openApp(1)
    television.changeSource(1)
    television.nextChannel()
    television.getScreenInfo()
    television.openApp(2)
    television.changeScreenMode(2)
    television.getScreenInfo()
    television.changeScreenMode(124)
    television.decreaseVolume()
    television.decreaseVolume()
    television.changeWifiCredentials("", "123")
    television.openApp(1)
    television.connectToWifi()
    television.changeWifiCredentials("321", "123")
    television.connectToWifi()
    television.openApp(1)
    television.getTVData()
    television.turnOff()