package module_14.lesson6

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect

fun main() {
    val numbers = Numbers()
    runBlocking {
        launch {
            // Подпишемся спустя 2 сек. т.е. как только подпишемся, то начнем получать данные.
            // Поэтому вывод чисел начнется не с 1, а с 4.
            // При MutableSharedFlow<Int>(replay = 2) получаем 2 параметра из буфера.
            delay(2000)
            withTimeout(8000) {
                numbers.sharedFlow.collect {
                    println(it)
                }
            }
        }
        //  Добавим еще один коллектор с задержкой в 4 сек.
        launch {
            // Подпишемся спустя 2 сек. т.е. как только подпишемся, то начнем получать данные.
            // Поэтому вывод чисел начнется не с 1, а с 4.
            // При MutableSharedFlow<Int>(replay = 2) получаем 2 параметра из буфера.
            delay(4000)
            withTimeout(10000) {
                numbers.sharedFlow.collect {
                    println("Second $it")
                }
            }
        }
    }
}

class Numbers {
    private val scope = CoroutineScope(Job() + Dispatchers.Default)
    private val _sharedFlow = MutableSharedFlow<Int>()
//    private val _sharedFlow = MutableSharedFlow<Int>(replay = 2)
    val sharedFlow = _sharedFlow.asSharedFlow()
    init {
        scope.launch {
            for (i in 0..10) {
                _sharedFlow.emit(i)
                delay(500)
            }
        }
    }
}