package module_10.lesson1

class RadioPhone: CallReceiver {
    override val vendor = "Panasonic"

    override fun call(number: String) {
        println("radio phone calling $number")
    }
}