package module_10.OOP3

//  Для хранения данных возможно подойдет Data-class
object Converters {
    // Словарь конвертеров по их кодам
    private val converters = mapOf("USD" to UsdConverter(), "EUR" to EurConverter(), "CNY" to CnyConverter())

    // Анонимный объект, реализация интерфейса CurrencyConverter
    private val noConverter = object : CurrencyConverter {
        override val currencyCode: String = ""
        override fun convertToRub(rub: Double) {
            println("Неизвестная валюта")
        }
    }
    fun get(currencyCode: String): CurrencyConverter {
        return converters.getOrElse(currencyCode.uppercase()) { noConverter }
    }
}