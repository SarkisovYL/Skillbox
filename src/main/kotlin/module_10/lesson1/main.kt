package module_10.lesson1

fun main() {
    val devices = listOf(MobilePhone(), AppleWatch(), DiskPhone(), SmartFridge())
    devices.forEach{it.call("+7(999) 999-99-99") }

    val mobilePhone = MobilePhone()
    val radioPhone = RadioPhone()
    radioPhone.receiveCall("158-158")
    mobilePhone.call(number = "+7(999) 999-99-99")
    mobilePhone.playVideo(url = "www.example.com")

    val webBrowser = listOf<WebBrowser>(MobilePhone(), SmartTV())
    webBrowser.forEach { it.playVideo(url = "www.skill.ru") }
}