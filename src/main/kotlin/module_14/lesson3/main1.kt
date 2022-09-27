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

val intermediateFlowMySquare = (0..10)
    .asFlow()                   // первоначально flow состоит из чисел от 0 до 10
    .square()                   // собственный оператор расширения
    .filter { it % 2 == 0 }     // фильтруем поток квадратов по четности
    .take(3)              // берем первые три элемента из результирующего потока

//  Создадим свой собственный оператор возведения в степень как расширение функции
fun  Flow<Int>.square(): Flow<Int> = transform {
    value ->  return@transform emit(value * value)
}