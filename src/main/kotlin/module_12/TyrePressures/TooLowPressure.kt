package module_12.TyrePressures

class TooLowPressure(pressure: Double) : Throwable(message = "При накачке $pressure атмосферы процедура удалась. " +
        "Эксплуатация невозможна - давление слишком низкое.") {
}