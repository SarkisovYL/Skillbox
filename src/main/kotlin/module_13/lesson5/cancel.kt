package module_13.lesson5

import kotlinx.coroutines.*

suspend fun main() {
    // Корутина крутит бесконечный цикл
    val scope = CoroutineScope(Dispatchers.Default)      // созданный scope:CoroutineScope
    val job = scope.launch {
        var i = 0
        // 1. Для отмены используем свойства isActive для проверки состояния корутины
        //        while (isActive) {
        // 2. Использовать метод yield()
        while (true) {
            yield()
            println(i++)
            Thread.sleep(500)
        }
    }

    // Корутина пытается отменить первую через три сек.
    scope.launch {
        delay(3000)
        println("cancel job")
        job.cancel()
    }

    (scope.coroutineContext.job as? CompletableJob)?.let {
        it.complete()
        it.join()
    } ?: throw java.lang.IllegalStateException()
}