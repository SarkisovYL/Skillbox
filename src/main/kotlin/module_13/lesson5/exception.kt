package module_13.lesson5

import kotlinx.coroutines.*

val scope3 = CoroutineScope(Dispatchers.Default)

suspend fun main() {
    cancelledCoroutines()
    (scope3.coroutineContext.job as? CompletableJob)?.let {
        it.complete()
        it.join()
    } ?: throw java.lang.IllegalStateException()
}

fun cancelledCoroutines() {
    // Корутина каждые 3 сек. выбрасывает исключение error
    scope3.launch {
        delay(3000)
        error("test exception")
    }
    // Корутина каждые 0,2 сек. выводит число
    scope3.launch {
        var i = 0
        while (true) {
            delay(200)
            println(i++)
        }
    }
}