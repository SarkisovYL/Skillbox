package module_11.lesson3

fun main() {
    val map = mutableMapOf(
        1 to "1",
        2 to "2",
        3 to "3"
    )

//    Вместо цикла forEach() используем деструктурирующее присваивание для Entry
//    представили entry двумя переменными key и value и работаем с ними по отдельности в println
    for ((key, value) in map) {
        println("$key - $value")
    }
}