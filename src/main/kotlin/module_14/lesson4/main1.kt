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
                .zip(strs) {number, string -> Result(number, string)}
//                .combine(strs) {number, string -> Result(number, string)}
                //  получим значение и выведим их в консоль
                .collect { println("${it.num} - ${it.str}") }
        }
    }
}

//  Создадим свой собственный элемент. Тогда после объединения мы будем работать уже с эти типом экземпляра
class Result(val num: Int, val str: String)