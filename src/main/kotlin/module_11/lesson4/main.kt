package module_11.lesson4

import module_07.Car
import module_08.Developer
import module_08.Person

fun main() {
    val list: List<String> = List(5) { "" }
    val intlist = listOf(1, 2, 3, 4)

//    println(genericFun(5))
//    println(genericFun("hello"))
//    println(genericFun(Car()))
//    println(genericFun(null))

//    Реализация функции обобщенного типа через конструктор класса
    val object1 = Generic(5)
    val object2 = Generic("Generic String")
    val object3 = Generic(Car())

    val person = Generic<Person>(Person("Tony", 35))
    person.setItem(Developer("Developer", 35))

    val a = GenericNumber<Number>(4)
    val b = GenericNumber<Number>(3)
    println(sum(a, b))  // Ошибка. Используй ковариантность

    val aCov = GenericCovariant<Double>(5.2)
    val bCov = GenericCovariant<Int>(5)
    println(sumCovariant(aCov, bCov))  // Ковариантный класс

//    Контрвариантность
    val developer = Developer("Tony", 35)
    printDeveloper(Printer<Person>(), developer)
}

fun <T> genericFun(input: T): String {
    return input?.toString() ?: "object is null"
}

//  Ограничения обобщенного типа уровнем верхней границы Number (теперь инстансы могут быть Int, Double, Byte ..)
fun sum(a: GenericNumber<Number>, b: GenericNumber<Number>): Int? {
    val first = a.item?.toInt() ?: return null
    val second = b.item?.toInt() ?: return null
    return first + second
}

//  Ковариантный класс
fun sumCovariant(a: GenericCovariant<Number>, b: GenericCovariant<Number>): Int? {
    val first = a.getItem()?.toInt() ?: return null
    val second = b.getItem()?.toInt() ?: return null
    return first + second
}

//  Контрвариантность
fun printDeveloper(printer: Printer<Developer>, developer: Developer) {
    printer.print(developer)
}