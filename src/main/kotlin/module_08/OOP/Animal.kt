package module_08.OOP

import kotlin.random.Random

open class Animal(var energy: Int, var weight: Int, var maxAge: Int, var name: String) {
    internal var currentAge: Int = 5    // текущий возраст
        set(value) {
            field = if (value > 0) value else 0
        }

    private val isTooOld: Boolean = currentAge >= maxAge    // true, если текущий возраст равен или больше максимального

    // Рождение животного
    open fun giveBirth(): Animal {
        energy = Random.nextInt(from = 1, until = 10)
        weight = Random.nextInt(from = 1, until = 5)
        currentAge = 0
        println("Рождено животное.")
        NatureReserve.add(this)
        return this
    }

    // Информация о животном
    fun info() {
        println("Имя: $name, Вес: $weight, Энергия: $energy, " +
                "Возраст: $currentAge, Максимальный возраст: $maxAge")
    }

    // Животное спит
    fun sleep() {
        energy += 5
        currentAge += 1
        println("$name спит")
    }

    // Животное ест
    fun eat() {
        energy += 3
        weight += 1
        println("$name ест")
    }

    // Животное передвигается
    open fun move(): Boolean {
        return if (!isTooOld || weight < 2 || energy < 6) {
            if (energy > 5) energy -= 5
            if (weight > 1) weight -= 1
            if (tryIncrementAge()) currentAge += 1
            println("$name передвигается")
            true
        } else
            false
    }

    // Случайное увеличение возраста
    private fun tryIncrementAge(): Boolean {
        return Random.nextBoolean()
    }
}