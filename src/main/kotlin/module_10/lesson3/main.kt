package module_10.lesson3

import module_10.lesson1.Callable

fun main() {
    val anonymous = object : Callable {
        val name = "anonymous"
        val lastName = "object"
        fun method() = println("$name $lastName")
        override val vendor = "anonymous vendor"

        override fun call(number: String) {
            println("anonymous object calling")
        }
    }
    anonymous.name
    anonymous.lastName
    anonymous.method()

    val evenChecker = object : IntPredicate {
        override fun accept(i: Int): Boolean {
            return i % 2 == 0
        }
    }

    println("8 is even - ${evenChecker.accept(8)}")
    println("9 is even - ${evenChecker.accept(9)}")
}

// Функциональный интерфейс. Реализация
fun interface IntPredicate {
    fun accept(i: Int): Boolean
}

class AnonymousTest {
    private val anonymous = object : Callable {
        val name = "anonymous"
        val lastName = "object"
        fun method() = println("$name $lastName")
        override val vendor = "anonymous vendor"

        override fun call(number: String) {
            println("anonymous object calling")
        }
    }

    fun testMethod() {
        anonymous.name
        anonymous.lastName
        anonymous.method()
        anonymous.vendor
        anonymous.call("+7 (999) 999-99-99")
    }
}