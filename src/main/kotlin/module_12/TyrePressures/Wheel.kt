package module_12.TyrePressures

class Wheel() {
     private var currentPressure: Double = 0.0

     fun pumpUpWheel(pressure: Double) {
        when (pressure) {
            in 0.0..10.0 -> currentPressure += pressure
            else -> throw IncorrectPressure(pressure)
        }
    }
    //  Текущее давление
    fun checkPressure() {
        when (currentPressure) {
            in 0.0..1.6 -> throw TooLowPressure(currentPressure)
            in 2.5..10.0 -> throw TooHighPressure(currentPressure)
            in 1.6..2.5 -> println("При накачке $currentPressure атмосферы процедура удалась. Эксплуатация возможна.")
            else -> throw IncorrectPressure(currentPressure)
        }
    }
}