package module_05

// Оптическая рекурсия это одно зеркало напротив другого.
// Задача - вывести в консоль числа от N до 1 с шагом -1

fun main() {
    var n = readLine()?.toIntOrNull() ?: return
    printNumbers(n)

    println("Summ numbers 0..$n - ${calculateSum(n)}")

    println("Summ numbers 0..$n - ${calculateSumTailrec(n)}")
}

fun printNumbers(number: Int): Int {
    return if (number > 0) {
        println(number)
        printNumbers(number-1)
    }
    else 0
}

// Задача - найти сумму чисел от 0 до N
// НО ЕСЛИ ВВЕДЕНО БОЛЬШОЕ ЧИСЛО (10000000) - ТО БУДЕТ ВЫДАНА ОШИБКА ПЕРЕПОЛНЕНИЯ СТЕКА
// Exception in thread "main" java.lang.StackOverflowError

fun calculateSum(n: Int) : Int {
    if (n == 0) return 0
    return n + calculateSum(n-1)

}

// Та же задача, но с использованием модификатора tailrec
// Определим дополнительный параметр currentSum, который будет отвечать за сумму чисел на каждой итерации
// Проблема больших чисел - решена.

tailrec fun calculateSumTailrec(n: Int, currentSum: Int = 0) : Int {
    if (n == 0) return currentSum
    return calculateSumTailrec(n-1, currentSum + n)
}