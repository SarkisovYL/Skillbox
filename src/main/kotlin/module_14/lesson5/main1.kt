package module_14.lesson5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    val flow = flow {
        repeat(5) {
            delay(1000)
            val number = Random.nextInt(1, 101)
            if (Random.nextBoolean()) error("Error occurred for $number")
            emit(number)
        }
    }
    runBlocking {
        flow
            .catch { println("emit error $it") }
            .onEach { println(it) }
            .map { if (it > 50) error("too much $it") }
            .catch { println("mapping error $it") }
            .launchIn(this)
    }
}