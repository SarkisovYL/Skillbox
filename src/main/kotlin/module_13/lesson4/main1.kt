package module_13.lesson4
// TODO для подключения корутин нам необходимо подключить библиотеку.
//  Для это откроем файл build.grable.kts и в блоке dependencies разместим специальную ссылку на библиотеку корутин.
//  После добавления корутин в правом углу появится значок Load Grable Changes для синхронизации проекта,
//  т.е. импорта библиотеки в проект, иначе библиотека не подгрузится.
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //  функция launch создает и запускает корутину в теле и не дожидаясь ее завершения
    //  переходит к исполнению следующего кода.
    launch {
        printWorld()
    }
    launch {
        printDots()
    }
    println("Hello")
}

suspend fun printWorld() {
    delay(2000)
    println(" world! ")
}

suspend fun printDots() {
    for (i in 1..500) {
        delay(10)
        if (i % 30 == 0) println(".$i") else print(".$i")
    }
}