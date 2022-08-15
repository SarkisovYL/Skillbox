package module_10.OOP3

class CnyConverter: CurrencyConverter {
    private val curs = 0.1185
    override val currencyCode: String = "CNY"

    override fun convertToRub(rub: Double) {
        val value = curs * rub
        println("$rub рублей =  ${String.format("%.2f", value)} китайских ёаней")
    }
}