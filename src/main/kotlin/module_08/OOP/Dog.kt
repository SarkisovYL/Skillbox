package module_08.OOP

import kotlin.random.Random

class Dog(energy: Int, weight: Int, maxAge: Int, name: String) : Animal(
    energy = energy,
    weight = weight,
    maxAge = maxAge,
    name = name
) {
    // Передвижение собаки
    override fun move(): Boolean {
        if (super.move()) println(" - бежит")
        return true
    }

    // Рождение щенка
    override fun giveBirth(): Dog {
        energy = Random.nextInt(from = 1, until = 10)
        weight = Random.nextInt(from = 1, until = 5)
        currentAge = 0
        println("Родился щенок.")
        NatureReserve.add(this)
        return this
    }
}