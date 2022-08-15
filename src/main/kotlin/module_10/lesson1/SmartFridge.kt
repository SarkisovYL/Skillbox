package module_10.lesson1

class SmartFridge: Callable {
    override val vendor = "LG"

    override fun call(number: String) {
        println("Hey, my smart fridge calling $number")
    }
}