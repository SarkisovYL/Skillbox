package module_13.lesson5

import kotlinx.coroutines.*

val exceptionHandler6 = CoroutineExceptionHandler { _, throwable ->
    println("error from handler - ${throwable.message}")
}
val scope6 = CoroutineScope(Job() + Dispatchers.Default + exceptionHandler6)

suspend fun main() {
    cancelledCoroutines6()
    scope6.coroutineContext.job.join()
}

fun cancelledCoroutines6() {
    // Корутина каждые 3 сек. выбрасывает исключение error
    scope6.launch {
        delay(3000)
        error("test eception")
    }
    // Корутина каждые 0,2 сек. выводит число
    scope6.launch {
        var i = 0
        while (true) {
            delay(200)
            println(i++)
        }
    }
}