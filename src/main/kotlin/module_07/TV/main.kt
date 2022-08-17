package module_07.TV

fun main() {
    val ue50 = TV(model = "UE50AU7500UXRU", size = 50)
    val ue43 = TV(model = "UE43T5300AU", size = 43)
    ue50.info()
    ue43.info()
    ue43.turnOnOff()
    ue50.turnOnOff()
    ue43.turnOnOff()
    ue43.selectChannels(5)
    ue43.valumeUp(30)
    ue50.valumeDown(20)
    for (i in 1..10) {
        ue43.channelUp()
    }
    for (i in 1..10) {
        ue50.channelDown()
    }
    ue50.turnOnOff()
    ue50.selectChannels(3)
    ue50.info()
    ue43.info()
}