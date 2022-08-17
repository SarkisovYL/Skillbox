package module_05

// Вывести в консоль все числа от 0 до N и подсчитать их сумму. Т вводится с клавиатуры.

fun main() {
    println("Enter number:")
    val n = readLine()?.toIntOrNull() ?: return
    // Если значение выражения не Null - то используем введенное значение, иначе прерываем
    // Прерывание эквивалентно записи if (n == null) return

//    Решение задачи с помощью цикла while (цикл с предусловием,
//    т.е. когда в начале проверяется условие, а затем выполняется операция)
    var i = 0
    var sum = 0

    while (i <= n) {
        println(i)
        sum += i
        i++
    }
    println("Sum of first $n numbers - $sum")

//    Решение задачи с помощью цикла dowhile (цикл с gjcktle.obv eckjdbtv,
//    т.е. когда в начале выполняется операция, а затем проверяется условие).
//    В этом случае первая итерация выполняется всегда.


//    Решение задачи с помощью цикла for
    sum = 0
    for (a in 0..n) {
        if (a % 2 != 0) continue
        println(a)
        sum += a
    }
    println("Sum of sum of even $n numbers - $sum")

//    Решение задачи с помощью функции forEach и лямбда выражений с ключевым словом it
//    it: неявное имя единственного параметра
//    Очень часто лямбда-выражение имеет только один параметр.
//    Если компилятор способен самостоятельно определить сигнатуру, то объявление параметра можно опустить вместе
//    с ->. Параметр будет неявно объявлен под именем it

    val myArea = MutableList(n) { it }
    myArea.forEach{b -> println("Numbers from list - $b") }

//    Подсчитать сумму чисел начиная с N до тех пор, пока сумма не привысит число 100.
//    И параллельно мы хотим подсчитать количество чисел, необходимых чтобы сумма привысила 100

    doWhileFun(60)
}

fun doWhileFun(currentSum: Int) {
    var count = 0
    var sum = currentSum
    println("Enter a start number:")
    var n= readLine()?.toIntOrNull() ?: return
    do {
        println("correct number - $n")
        sum += n
        println("sum - $sum")
        n++
        count++
    } while (sum < 100)
    println("Number count - $count")
}
