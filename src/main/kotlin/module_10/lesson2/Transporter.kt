package module_10.lesson2

abstract class Transporter(
    val maxWeight: Int              // Грузоподъемность
) {
    abstract val capacity: Int      // Вместительность
    abstract fun move()
}