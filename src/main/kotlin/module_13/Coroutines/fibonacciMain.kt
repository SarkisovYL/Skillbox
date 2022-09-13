package module_13.Coroutines

import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.launch

fun main() {
//  Для создания и запуска корутины используем CoroutineBuilder - launch в функции runBlocking
    runBlocking {
        val a = -300000
        val b = 150000
        val c = 1

        launch {
            try {
                println("Start block A:")
                println(Fibonacci.take(a))
                println("Finish block A.")
            } catch (t: Throwable){
                println("error number: ${t.message}")
            }
        }
        launch {
            try {
                println("Start block B:")
                println(Fibonacci.take(b))
                println("Finish block B.")
            } catch (t: Throwable){
                println("error number: ${t.message}")
            }
        }
        launch {
            try {
                println("Start block C:")
                println(Fibonacci.take(c))
                println("Finish block C.")
            }
            catch (t: Throwable){
                println("error number: ${t.message}")
            }
        }
    }
}
