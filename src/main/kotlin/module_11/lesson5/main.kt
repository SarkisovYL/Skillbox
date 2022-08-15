package module_11.lesson5

fun main() {
//    Реализация проверки на четность целого числа путем расширения ненаследуемого класса Int
    val number: Int = 6
    println(number.isEven())

//    Реализация через класс компаньон
    val a = Int.random()
    val b = Int.random()
    println("a - $a b - $b")

//    Реализация через свойства объекта.
    println(7.isEvenProperty)
}

fun Int.isEven() : Boolean = (this % 2) == 0

fun Int.Companion.random() : Int {
    return (System.currentTimeMillis() % 43).toInt()
}

//  Для расширения через свойства ОБЯЗАТЕЛЕН GET().
val Int.isEvenProperty
    get() = this % 2 == 0