package module_13.Coroutines

import kotlinx.coroutines.*

//val scope2 = CoroutineScope(Job() + Dispatchers.Default + exceptionHandler)             // для прерывание выполнения процесса при ошибке в корутине
val scope2 = CoroutineScope(SupervisorJob() + Dispatchers.Default + exceptionHandler)   // для продолжения выполнения процесса при ошибке в корутине

suspend fun main() {
    val a = 300000
    val b = -40000
    val c = 100000

    val job1 = scope2.launch {
            println("Start block A:")
            println(FibonacciCancel.take(a))
            println("Finish block A.")
    }
    val job2 = scope2.launch {
        println("Start block B:")
        println(FibonacciCancel.take(b))
        println("Finish block B.")
    }
    val job3 = scope2.launch {
        println("Start block C:")
        println(FibonacciCancel.take(c))
        println("Finish block C.")
    }

    // Корутина пытается отменить первую через три сек.
    scope.launch {
        delay(300)
//        println("cancel job")
        job1.cancel("CANCELLED")
    }

    println("Start working...")
    (scope2.coroutineContext.job as? CompletableJob)?.let {
        it.complete()
        it.join()
    } ?: throw IllegalStateException()
}
