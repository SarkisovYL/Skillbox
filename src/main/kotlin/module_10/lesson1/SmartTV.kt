package module_10.lesson1

class SmartTV: Callable, WebBrowser {
    override val vendor = "Xiaomi"

    override fun call(number: String) {
        println("Smart TV callin $number")
    }

    override fun playVideo(url: String) {
        println("Smart TV playing video from $url")
    }

}