package module_11.lesson1

import module_07.Car

fun main() {
    val car1 = Car()
    val car2 = Car()
    val car3 = car1

    println(car1 === car3)
    println(car1 === car2)

    val a = Car()
    val b = Car()
    a == b
//    TODO эта запись идеентична нижней
    a?.equals(b) ?: b === null
//    TODO у объекта а вызывается функция equals в которую передается объект b.
//     Если объект a равен null, то проходит проверка оператором "элвис" объекта b на равенство null
//     с помощью сравнения по ссылке
    println(
        Person(
            name = "Name",
            lastname = "LastName",
            passportSeries = 9999,
            passportNumber = 999999
        )
    )
//    TODO при закоментаренной функции toString() в классе Person выводится module_11.lesson1.Person@13fd10
//     название модуля, класс объекта и его хуш-функция в 16-ти значном виде.
}