package module_14.lesson4

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
//    Создадим два потока flow с разными задержками, при этом воспользуемся разными флоубилдерами
    val nums = (1..3).asFlow().onEach { delay(1000) }
    val strs = flowOf("one", "two", "three").onEach { delay(2000) }
//    объединим эти потоки с помощью функции zip
    runBlocking {
        launch {

            nums
                //  передадим функцию трансформации с помощью лямбда и разные комбинации объединения (zip, combine...)
//                .zip(strs) {number, string -> "$number - $string"}
                .combine(strs) {number, string -> "$number - $string"}
                //  получим значение и выведим их в консоль
                .collect { println(it) }
        }
    }
}