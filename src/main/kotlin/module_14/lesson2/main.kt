package module_14.lesson2

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlin.random.Random

fun main() {
    runBlocking {
        launch {
            println("Start callecting...")
            Generator.flow.collect {
                println("Collected value - $it")
            }
        }
        println("Start working...")
    }
}

object Generator {
    val flow = flow {
        while (currentCoroutineContext().isActive) {
            emit(Random.nextInt())
            delay(1000)
        }
    }
    // Использование функции для получения потока случайных целых чисел
    fun flow(): Flow<Int> {
        return flow {
            while (currentCoroutineContext().isActive) {
                emit(Random.nextInt())
                delay(1000)
            }
        }
    }
}