package module_12.TyrePressures

class TooHighPressure(pressure: Double) : Throwable(message = "При накачке $pressure атмосфер процедура удалась. " +
        "Эксплуатация невозможна — давление превышает нормальное.")
