package module_10.lesson1

class MobilePhone: CallReceiver, WebBrowser {
    override val vendor = "Samsung"

    override fun call(number: String) {
        println("mobile phone calling $number")
    }

    override fun receiveCall(number: String) {
        super.receiveCall(number)
        println("LED on")
    }

    override fun playVideo(url: String) {
        println("mobile phone playing video from $url")
    }
}