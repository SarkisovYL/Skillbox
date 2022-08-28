package module_12.TyrePressures

fun main() {
    val wheel = Wheel()
    wheel.pumpUpWheel(-10.5)
    wheel.pumpUpWheel(0.5)
    wheel.pumpUpWheel(1.5)
    wheel.pumpUpWheel(3.5)
    wheel.pumpUpWheel(5.5)
    wheel.checkPressure()
}