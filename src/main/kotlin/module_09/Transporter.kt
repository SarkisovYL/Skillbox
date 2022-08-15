package module_09

abstract class Transporter(
    val maxWeight: Int              // Грузоподъемность
) {
    abstract val capacity: Int      // Вместительность
    abstract fun move()
}