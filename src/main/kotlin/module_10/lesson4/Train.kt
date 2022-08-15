package module_10.lesson4

class Train(maxWeight: Int): Transporter(maxWeight) {
    override val capacity: Int = 0

    override fun move() {
        println("Train moving on rails")
    }
}