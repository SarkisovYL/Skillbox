package module_05

import java.math.BigInteger

fun main() {
    do {
        println("Введите целое положительное число: ")
        val n = readLine()?.toIntOrNull()
        if (n != null) {
            if (n > 0) {
                var n0: BigInteger
                var n1 = 0.toBigInteger()
                var n2 = 1.toBigInteger()

                repeat(n-1) {
                    n0 = n1
                    n1 = n2
                    n2 = n0 + n1
                }
                println("$n член последовательности = $n1. \nДлина числа = ${n1.toString().length}")
                break
            }
        }
        println("Ошибка ввода!")
    } while (true)
}
