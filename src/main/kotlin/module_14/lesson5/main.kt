package module_14.lesson5

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    val flow = flow {
        try {
            repeat(5) {
                delay(1000)
                val number = Random.nextInt(1, 101)
//                if (Random.nextBoolean()) error("Error occurred for $number")
                emit(number)
            }
        }
        catch (t: Throwable) {
            println(t.message)
        }
    }
    runBlocking {
        flow
            .onEach { println(it) }
            .map { if (it > 50) error("too much $it") }
            .launchIn(this)
    }
}