package module_13.Coroutines

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

val parentJob = Job()
val scope = CoroutineScope(parentJob + Dispatchers.Default)

suspend fun main() {
    val a = 300000
    val b = -10
    val c = 100000

    scope.launch {
            try {
                println("Start block A:")
                println(Fibonacci.take(a))
                println("Finish block A.")
            } catch (t: Throwable){
                println("error number: ${t.message}")
            }
    }
    scope.launch {
            try {
                println("Start block B:")
                println(Fibonacci.take(b))
                println("Finish block B.")
            } catch (t: Throwable){
                println("error number: ${t.message}")
            }
    }
    scope.launch {
            try {
                println("Start block C:")
                println(Fibonacci.take(c))
                println("Finish block C.")
            }
            catch (t: Throwable){
                println("error number: ${t.message}")
            }
    }
    println("Start working...")
    parentJob.complete()
    parentJob.join()
}
