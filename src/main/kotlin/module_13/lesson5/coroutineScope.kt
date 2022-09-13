package module_13.lesson5

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

//  TODO Способ связать код написанный на корутинах с классическим кодом написанным на на потоках и callback
fun main() {
    val scope = CoroutineScope(Dispatchers.Default)      // созданный scope:CoroutineScope
    scope.launch {                      // корутина, каторая запускается с помощю билдера launch
        println("Start runBlocking...")
        doSomeWork()
        println("Finish runBlocking...")
    }
}

//  suspend функция которая выполняет достаточно длинную операцию
suspend fun doSomeWork() {
    println("Start work...")
    delay(3000)
    println("Finish work...")
}
