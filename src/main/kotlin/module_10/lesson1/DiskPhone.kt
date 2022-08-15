package module_10.lesson1

class DiskPhone: CallReceiver {
    override val vendor = "Tesla"

    override fun call(number: String) {
        println("disk phone calling $number")
    }
}