
@file:Suppress("DEPRECATION")

package module_06

import kotlin.random.Random

fun  main() {
//  TODO НЕИЗМЕНЯЕМЫЕ СПИСКИ (по значению и длине, аналог кортежа в Phython)
    val list = listOf(1, 2, 3, 4)
    val carlist = listOf("Mersedes", "BMW", "Ferrari")
    println(carlist[0])
//    list[1] = 20    // Изменение невозможно

//  Создание пустых списков. Для них нужно обязательно указать тип данных.
    val emptyList = listOf<String>()
    val secondEmptyList = emptyList<String>()
    println(secondEmptyList.size)

    println("Индекс пустого списка равен ${emptyList.lastIndex}")

//  Создание списков через конструктор класса.
//  Для этого нужно указать явно размер списка
//  и предоставить лямбда функцию для инициализации каждого элемента списка

    val secondList = List<Int>(5) { it * 10 }
    println(secondList)
    val secondCarList = List<String>(3) { index -> "Car#${index}" }
    println(secondCarList)

//  TODO ИЗМЕНЯЕМЫЕ СПИСКИ (по значению и длине, аналог списка list в Phython) - MutableList
    val mutibleList = mutableListOf<Int>(1, 2, 3, 4)
    val mutibleCarList = mutableListOf<String>("Mersedes", "BMW", "Ferrari")
    println(mutibleCarList[0])

    val mutibleSecondList = List(5) { 0 }
    println(mutibleSecondList.size)
    val mutibleSecondCarList = List<String>(3) { index -> "Car#${index}" }
    println(mutibleSecondCarList.size)

    mutibleList[1] = 20
    mutibleList.add(5)

    println("MutibleL: ${mutibleList.joinToString("; ")}")

//  TODO МАССИВЫ (изменяемые по значению но не по длине)
    val array = arrayOf(1, 2, 3, 4, 5)
    val carArray = arrayOf("Mersedes", "BMW", "Ferrari")
    array[1] = 20
    println("Array: ${array.joinToString("; ")}")

//  Создание пустых массивов. Для них нужно обязательно указать тип данных.
    val emptyArray = arrayOf<String>()
    println(emptyArray.size)
    val secondEmptyArray = emptyArray<String>()
    println(secondEmptyArray.size)

//  Циклы в списках с помощью for
    for (i in array.indices) {
        println("for (i in array.indices): ${array[i] * i}")
    }
//  То же самое, но с использованием функций высшего порядка  forEach и forEachIndexed
    array.forEach { item -> println(".forEach - $item") }
    array.forEach { println("it - $it") }
    array.forEachIndexed { index, item -> println(".forEachIndexed: ${item * index}") }

//    Подсчет суммы исходя из лямбда выражения. Расчет суммы всех элементов умноженных на 5.
    println("Sum elem * 5 = ${array.sumBy { it * 5 }}")

//    Подсчитать количество символов в массиве машин
    println("All symbols in carArray = ${carArray.sumBy { it.length }}")

//    ЗАДАЧА
//    Удалить из списка элементы, которые удовлетворяют какому-либо правилу
//    Создадим список случайных чисел от -10 до 10
    val numbers = MutableList(10) { Random.nextInt(-10, 10) }
    println("Удалим из списка элементы, которые < 0")
    println(numbers)
//    При такой реализации будет ошибка Exception in thread "main" java.util.ConcurrentModificationException
//    т.к. мы пытаемся изменить размер списка в цикле.
//
//    numbers.forEach {
//        if (it < 0) numbers.remove(it)
//    }
//    println("Итог: $numbers")
//
//    1 способ решения - Промежуточный список.
//    Недостаток - промежуточный список, а значит затраты по памяти.
    val candidatesToRemove = mutableListOf<Int>()
    numbers.forEach {
        if (it < 0) candidatesToRemove.add(it)
    }
    numbers.removeAll(candidatesToRemove)
    println("Итог: $numbers")
//
//    2 способ - Использование итератора, т.е. элемента позволяющего обходить экземпляры списка.
//    Итератор не привязан к индексам, поэтому ошибок связанных с индексом не возникает.
    val numbers_iter = MutableList(10) { Random.nextInt(-10, 10) }
    println("Удалим из списка элементы, которые < 0")
    println(numbers_iter)
    val iterator = numbers_iter.iterator()
    while (iterator.hasNext()) {
//      с помощи функции hasNext() проверяем есть ли еще элементы в списке
        val iter = iterator.next()  // функцией .next() берем элемент на который указывает итератор
        if (iter < 0)
            iterator.remove()       // Если элемент отрицательный, то с помощью итератора удаляем элемент из коллекции
    }
    println(numbers_iter)
//
//    3 Способ предоставляет сам Kotlin с помощью функции высшего порядка removeAll
//    которая принимает в качестве параметров лямбда выражения
    val numbers_removeAll = MutableList(10) { Random.nextInt(-10, 10) }
    println("Удалим из списка элементы, которые < 0")
    println(numbers_removeAll)
    numbers_removeAll.removeAll { it < 0 }
    println(numbers_removeAll)
//
//
//    ******* ИНТЕРЕСНЫЕ ФУНКЦИИ ********
//
//
//    Функция преобразования списка одного типа в список другого
//    MAP. Принимает лямбда выражение, содержащую функцию преобразования для каждого элемента

    val stringList = list.map {
        "This was a number $it "
    }
    stringList.forEach{println(it)}
    stringList.forEachIndexed{index, item -> println("Item - $item Index - $index")}

    val fruits = listOf("банан", "авокадо", "яблоко", "киви", "айва")
    fruits
        .filter { it.startsWith("а") }
        .sortedBy { it }
        .map { it.uppercase() }
        .forEach { println(it) }
}