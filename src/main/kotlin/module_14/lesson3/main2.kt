package module_14.lesson3

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        launch {
            distinctFlow
                .distinctUntilChanged()     //  Одинаковые подряд идущие значения убираются.
                .collect {
                println(it)
            }
        }
    }
}

//  Имитация работы датчика. Выводим true если условие выполняется и false если не выполняется
val distinctFlow = flow<Boolean> {
    repeat(10) {
        emit(Random.nextBoolean())
        delay(500)
    }
}
