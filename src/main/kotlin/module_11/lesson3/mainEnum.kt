package module_11.lesson3

fun main() {
    Color.WHITE
    println(Color.WHITE.hex)
    Color.WHITE.draw()
    Color.RED.draw()

//    Вывести все значения
    println(Color.values().joinToString(","))
//    Найти Hex по цвету
    println(Color.valueOf("RED").hex)
//    Вывести порядковый номер в перечислении и имя объекта
    Color.values().forEach { println("${it.name} - ${it.ordinal}") }
    println(switchColor(Color.RED))
}

//  Функция принимает цвет и возвращает другой цвет
fun switchColor(color: Color): Color = when(color) {
    Color.WHITE -> Color.BLACK
    Color.BLACK -> Color.RED
    Color.RED -> Color.GREEN
    Color.GREEN -> Color.BLUE
    Color.BLUE -> Color.WHITE
}