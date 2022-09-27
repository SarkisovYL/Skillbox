package module_14.lesson6

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect


fun main() {
    runBlocking {
        val job = launch {
            GeneratorShared.sharedFlow.collect {
                println(it)
            }
        }
        // Завершить работу после 10 секунд
        delay(10000)
        job.cancel()
    }
}
