package module_14.lesson2

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect

fun main() {
    runBlocking {
        launch {
            println("Start callecting...")
            var counter = 0
            Generator1.flow().collect {
                println("Collected value - $it")
                delay(100)
                counter ++
                // Сработает функция cancel у job этого launch
                if (counter > 30) cancel()
            }
        }
        println("Start working...")
    }
}

object Generator1 {
    // Использование функции для получения потока случайных целых чисел
    fun flow(): Flow<Int> {
        return (0..100).asFlow()
    }
}