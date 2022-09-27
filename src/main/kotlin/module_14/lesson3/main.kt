package module_14.lesson3

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        launch {
            intermediateFlow.collect {
                println(it)
            }
        }
    }
}

val intermediateFlow = (0..10)
    .asFlow()                   // первоначально flow состоит из чисел от 0 до 10
    .map { it * it }            // оператор map принимает в качестве abstream этот поток и возводит числа в квадрат
    .filter { it % 2 == 0 }     // фильтруем поток квадратов по четности
    .take(3)              // берем первые три элемента из результирующего потока