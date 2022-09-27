package module_14.lesson6

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect


fun main() {
    runBlocking {
        launch {
            var counter = 0
            GeneratorShared.sharedFlow.collect {
                println(it)
                counter++
                // Отменить сам коллектор для остановки программы после 5-го числа
                if (counter >= 5) cancel()
            }
        }
    }
}
