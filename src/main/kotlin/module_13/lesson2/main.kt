package module_13.lesson2

import kotlin.concurrent.thread

fun main() {
    LoadHelper.load()
}

object LoadHelper {
    private var progress: Int = 0

    private fun startLoading() {
        thread {
            while (progress < 100) {
                progress++
                Thread.sleep(500)
            }
        }
    }

    private fun updateProgressBar() {
        thread {
            while (progress < 100) {
                println(getProgressString())
                Thread.sleep(500)
            }
        }
    }

    private fun getProgressString() : String {
        // TODO Так как строки это неизменяемый тип данных то чтобы не плодить новые экземпляры строк
        //  используется класс StringBuilder
        val str = StringBuilder()
        for (i in 0..100) {
            if(i < progress)
                str.append("#")
            else str.append(".")
        }
        str.append(" $progress %")
        return str.toString()
    }

    fun load() {
        startLoading()
        updateProgressBar()
    }
}