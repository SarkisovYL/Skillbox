package module_13.lesson4
// TODO для подключения корутин нам необходимо подключить библиотеку.
//  Для это откроем файл build.grable.kts и в блоке dependencies разместим специальную ссылку на библиотеку корутин.
//  После добавления корутин в правом углу появится значок Load Grable Changes для синхронизации проекта,
//  т.е. импорта библиотеки в проект, иначе библиотека не подгрузится.
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    //  TODO функция launch создает и запускает корутину в теле и не дожидаясь ее завершения
    //   переходит к исполнению следующего кода. Каждый вызов launch возвращает объект job, который однозначно описывает
    //   запущенную корутину. Корутина может быть в разных состояниях (New (новая), Active(активная),Cancelling(отмена)
    //   -> Cancelled(отмененная), Completing(завершение) -> Completed(завершенная)) и с помощью job ими можно управлять
    //   через свойства (IsActive, isCancelled, isCompleted) и методы для переключения некоторых состояний (start,
    //   cancel, join и др)
    launch {
    delay(2000)     //  В отличии от sleep приостанавливает выполнение функции, а не всего потока.
        println(" world! ")
    }
    launch {
        for (i in 1..500) {
            delay(10)
            if (i % 30 == 0) println(".$i") else print(".$i")
        }
    }
    println("Hello")
}