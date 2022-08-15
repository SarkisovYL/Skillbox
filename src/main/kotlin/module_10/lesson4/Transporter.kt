package module_10.lesson4

abstract class Transporter(
    val maxWeight: Int              // Грузоподъемность
) {
    abstract val capacity: Int      // Вместительность
    abstract fun move()
}