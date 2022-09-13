package module_13.lesson3

import java.math.BigInteger
import kotlin.concurrent.thread
import kotlin.random.Random
import kotlin.random.asJavaRandom

//  Выведем функцию в отдельный поток.
fun main() {
    println("Program start ${Thread.currentThread().name}")
    //  TODO Для вызова воспользуемся анонимными объектами.
    //   Таким образом мы передаем в функцию magicNumber1 объект Callback1 у которого будут вызваны соответствующие
    //   функции в зависимости от результата.
    magicNumber1(object: Callback1 {
        override fun onSuccess(value: BigInteger) {
            println("First number = $value")
        }

        override fun onFailure(error: Throwable) {
            println("Error occurred: ${error.message}")
        }
    })
    magicNumber1(object: Callback1 {
        override fun onSuccess(value: BigInteger) {
            println("Second number = $value")
        }

        override fun onFailure(error: Throwable) {
            println("Error occurred: ${error.message}")
        }
    })
}

//  TODO в потоке функция return не отрабатывает. Как получить результат работы кода ? Есть разные способы:
//   Callback, Future with promises и т.д. Рассмотрим callback.
//   CALLBACK - это функция которую нужно передать в нашу функцию (magicNumber) код внутри magicNumber должен
//   выполниться, а затем вызвать эту функцию, чтобы передать управление и данные в другую часть программы.
//   CALLBACK может иметь любой вид в зависимости от задачи, это может быть функция, интерфейс, лямбда-выражение...
//   Мы же, чтобы получить выражение из magicNumber опишем интерфейс и для простоты назовем его callback.

fun magicNumber1(callback: Callback1) {
    thread {
        println("Calculation start ${Thread.currentThread().name}")
        val number = BigInteger.probablePrime(4000, Random.asJavaRandom())
        //  После того как функция расчитает число нужно будет вызвать определенную функцию у нашего callback
        callback.onSuccess(number)    // этот callback нам нужно передать во время вызова функции magicNumber1()
    }
}

interface  Callback1 {
    fun onSuccess(value: BigInteger)
    fun onFailure(error: Throwable)
}