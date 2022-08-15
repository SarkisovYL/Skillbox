package module_10.OOP3

fun main() {
    val codeArray = arrayOf("EuR", "rub", "Usd", "CNY", "GBP")
    codeArray.forEachIndexed { index, item ->
        println("$index. Код $item:")
        Converters.get(item).convertToRub(100.0)}
}