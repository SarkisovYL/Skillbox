package module_10.OOP3

class UsdConverter: CurrencyConverter {
    private val curs = 0.0177
    override val currencyCode: String = "USD"

    override fun convertToRub(rub: Double) {
        val value = curs * rub
        println("$rub ������ =  ${String.format("%.2f", value)} �������� ���")
    }
}