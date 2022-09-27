package module_14.lesson6

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.takeWhile


fun main() {
    runBlocking {
        launch {
//            GeneratorShared.sharedFlow.take(5).collect() {
            GeneratorShared.sharedFlow.takeWhile { it <= 98 }.collect() {
                println(it)
            }
        }
    }
}
