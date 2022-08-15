package module_10.OOP3

interface CurrencyConverter {
    val currencyCode: String
    fun convertToRub(rub: Double)
}