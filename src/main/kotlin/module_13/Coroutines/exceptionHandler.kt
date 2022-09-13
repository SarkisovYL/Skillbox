package module_13.Coroutines

import kotlinx.coroutines.*

val exceptionHandler = CoroutineExceptionHandler{ _, throwable ->
    println("Number \"${throwable.message}\" is incorrect. An exception was raised")
}

//val scope1 = CoroutineScope(Job() + Dispatchers.Default + exceptionHandler)             // для прерывание выполнения процесса при ошибке в корутине
val scope1 = CoroutineScope(SupervisorJob() + Dispatchers.Default + exceptionHandler)   // для продолжения выполнения процесса при ошибке в корутине

suspend fun main() {
    val a = 300000
    val b = -40000
    val c = 100000

    scope1.launch {
        println("Start block A:")
        println(Fibonacci.take(a))
        println("Finish block A.")
    }
    scope1.launch {
        println("Start block B:")
        println(Fibonacci.take(b))
        println("Finish block B.")
    }
    scope1.launch {
        println("Start block C:")
        println(Fibonacci.take(c))
        println("Finish block C.")
    }

    println("Start working...")
    (scope1.coroutineContext.job as? CompletableJob)?.let {
        it.complete()
        it.join()
    } ?: throw IllegalStateException()
}
