package module_13.lesson3

import java.math.BigInteger
import kotlin.random.Random
import kotlin.random.asJavaRandom
import kotlin.concurrent.thread
import kotlin.system.measureTimeMillis

fun main() {
    println("Program start ${Thread.currentThread().name}")
//    Воспользуемся анонимными объектами
    magicNumber2(object: Callback2 {
        override fun onSuccess(value: BigInteger) {
            println("First number = $value")
        }

        override fun onFailure(error: Throwable) {
            println("Error occurred: ${error.message}")
        }
    })
    magicNumber2(object: Callback2 {
        override fun onSuccess(value: BigInteger) {
            println("Second number = $value")
        }

        override fun onFailure(error: Throwable) {
            println("Error occurred: ${error.message}")
        }
    })
}

fun magicNumber2(callback: Callback2) {
    thread {
        println("Calculation start ${Thread.currentThread().name}")
        val number: BigInteger
        //  С помощью функции measureTimeMillis рассчитаем время необходимое для расчета числа.
        val time = measureTimeMillis {
            number = BigInteger.probablePrime(2000, Random.asJavaRandom())
        }
        //  Если расчет занимает больше 2 сек. то будем выдавать ошибку, иначе вернуть рассчитанное число.
        if (time > 2000) {
            callback.onFailure(Throwable("Calculation was too long"))
        }
        else callback.onSuccess(number)
    }
}

interface  Callback2 {
    fun onSuccess(value: BigInteger)
    fun onFailure(error: Throwable)
}