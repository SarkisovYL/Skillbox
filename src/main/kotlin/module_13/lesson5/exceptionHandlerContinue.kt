package module_13.lesson5

import kotlinx.coroutines.*

val exceptionHandler5 = CoroutineExceptionHandler { _, throwable ->
    println("error from handler - ${throwable.message}")
}
val scope5 = CoroutineScope(SupervisorJob() + Dispatchers.Default + exceptionHandler5)

suspend fun main() {
    cancelledCoroutines5()
    (scope5.coroutineContext.job as? CompletableJob)?.let {
        it.complete()
        it.join()
    } ?: throw java.lang.IllegalStateException()
}

fun cancelledCoroutines5() {
    // Корутина каждые 3 сек. выбрасывает исключение error
    scope5.launch {
        delay(3000)
        error("test eception")
    }
    // Корутина каждые 0,2 сек. выводит число
    scope5.launch {
        var i = 0
        while (true) {
            delay(200)
            println(i++)
        }
    }
}