package module_10.OOP3

class EurConverter: CurrencyConverter {
    private val curs = 0.0185
    override val currencyCode: String = "EUR"

    override fun convertToRub(rub: Double) {
        val value = curs * rub
        println("$rub рублей =  ${String.format("%.2f", value)} Евро")
    }
}