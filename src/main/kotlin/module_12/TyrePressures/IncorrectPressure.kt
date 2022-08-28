package module_12.TyrePressures

class IncorrectPressure(pressure: Double) : Throwable(message = "При накачке $pressure атмосфер процедура не удалась.") {
}