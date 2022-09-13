package module_13.lesson5

import kotlinx.coroutines.*
import module_13.lesson3.Callback2
import module_13.lesson3.magicNumber2
import java.math.BigInteger
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

//  TODO Корутины при компиляции преобразуются в callback и state machine и в этом помогает интерфейс continuation,
//   он позволяет продолжить выполнение функции после приостановки.
fun main() {
    runBlocking {
        launch {
            try {
                println("Start runBlocking...")
                suspendMagicNumber1()
                println("Finish runBlocking...")
            } catch (t: Throwable) {}
        }
        println("Start working...")
    }
}

//  TODO для интеграции кода или библиотеки и корутин пригодится continuation. Авторами корутин предусмотрена специальная
//   функция suspendCoroutine, которая позволяет обернуть функцию написанную на call-back и превратить ее в suspend функцию.
suspend fun suspendMagicNumber1() {
    suspendCoroutine<BigInteger> { continuation ->
        magicNumber2(object : Callback2 {
            //  TODO Все, что нам нужно для возобновления работы приостановленной родительской функции - это вызвать у
            //   параметра continuation соответствующие функции resume и resumeWithException
            override fun onSuccess(value: BigInteger) {
                println("number $value")
                continuation.resume(value)  // вызван метод resume и передано в него полученное значение
            }

            override fun onFailure(error: Throwable) {
                println("error ${error.message}")
                continuation.resumeWithException(error)
            }
        })
    }
}