package module_14.lesson6

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.collect
import kotlin.random.Random

fun main() {
    // с помощью функции collect подпишемся на sharedFlow и обработаем каждый из элементов
    runBlocking {
        launch {
            GeneratorShared.sharedFlow.collect {
                println(it)
            }
        }
    }
    // ПРОГРАММА НЕ ЗАВЕРШАЕТ РАБОТУ ПОСЛЕ ВЫВОДА ЧИСЕЛ. ДЛЯ ЗАВЕРШЕНИЧ ЕСТЬ НЕСКОЛЬКО СПОСОБОВ.
    // 1. Отменить сам коллектор - main1
    // 2. С помощью job - main2
    // 3. Использую специальные терминальные операторы take и takeWhile - main3
}

object GeneratorShared {
    private val _sharedFlow = MutableSharedFlow<Int>()
    val sharedFlow = _sharedFlow.asSharedFlow()         // Превращаем из mutableFlow в обычный, чтобы из вне нельзя было эмитить значени
    // Для обращения к корутин мы ранее использовали suspend блоки
    // Но для sharedFlow такой подход не реализован, поэтому воспользуемся corutinescope
    // Создадим собственный scope
    private val scope = CoroutineScope(Job() + Dispatchers.Default)
    // В блоке init объявим цикл, который будет генерировать числа
    init {
        scope.launch {
            repeat(10) {
                _sharedFlow.emit(Random.nextInt(90, 101))
                delay(500)
            }
        }
    }
}

