package module_10.OOP3

//  ��� �������� ������ �������� �������� Data-class
object Converters {
    // ������� ����������� �� �� �����
    private val converters = mapOf("USD" to UsdConverter(), "EUR" to EurConverter(), "CNY" to CnyConverter())

    // ��������� ������, ���������� ���������� CurrencyConverter
    private val noConverter = object : CurrencyConverter {
        override val currencyCode: String = ""
        override fun convertToRub(rub: Double) {
            println("����������� ������")
        }
    }
    fun get(currencyCode: String): CurrencyConverter {
        return converters.getOrElse(currencyCode.uppercase()) { noConverter }
    }
}