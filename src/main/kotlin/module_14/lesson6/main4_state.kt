package module_14.lesson6

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import module_14.lesson2.Generator

fun main() {
    val generator = StateGenerator()
    generator.square(10)
    // Будет обрабатываться одна из двух корутин
    generator.squareSuspend(30)
    generator.squareSuspend(20)

    // Подпишемся на изменение stateFlow
    runBlocking {
        launch {
            withTimeout(2000) {
                generator.stateFlow.collect {
//                generator.numbersFlow.collect {
                    println(it)
                }
            }
        }
    }
}

class StateGenerator {
    private val scope = CoroutineScope(Job() + Dispatchers.Default)
    private val _stateFlow = MutableStateFlow(0)
    val stateFlow = _stateFlow.asStateFlow()
//   Создадим в классе две функции возведения в квадрат
    // Для синхронного кода.
    fun square(value: Int) {
        _stateFlow.value = value * value
    }

    // Для корутины
    fun squareSuspend(value: Int) {
        scope.launch {
            delay(1000)
            _stateFlow.value = value * value
        }
    }

    val numbersFlow = Generator.flow.shareIn(scope = scope, SharingStarted.Eagerly, 0)
}