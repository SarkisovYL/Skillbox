package module_13.lesson5

import kotlinx.coroutines.*
import module_13.lesson3.Callback2
import module_13.lesson3.magicNumber2
import java.math.BigInteger
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

val exceptionHandler4 = CoroutineExceptionHandler { _, throwable ->
    println("error from handler - ${throwable.message}")
}
val scope4 = CoroutineScope(Dispatchers.Default + exceptionHandler4)

suspend fun main() {
    scope4.launch {
            println("Start runBlocking...")
            suspendMagicNumber2()
            println("Finish runBlocking...")
    }
    println("Start working...")
    (scope4.coroutineContext.job as? CompletableJob)?.let {
        it.complete()
        it.join()
    } ?: throw java.lang.IllegalStateException()
}

suspend fun suspendMagicNumber2() {
    suspendCoroutine<BigInteger> { continuation ->
        magicNumber2(object : Callback2{
            override fun onSuccess(value: BigInteger) {
                println("number $value")
                continuation.resume(value)
            }

            override fun onFailure(error: Throwable) {
                println("error ${error.message}")
                continuation.resumeWithException(error)
            }
        })
    }
}