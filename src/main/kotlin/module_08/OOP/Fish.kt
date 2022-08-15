package module_08.OOP

import kotlin.random.Random

class Fish(energy: Int, weight: Int, maxAge: Int, name: String) : Animal(
    energy = energy,
    weight = weight,
    maxAge = maxAge,
    name = name
) {
    // Передвижение рыбки
    override fun move(): Boolean {
        if (super.move()) println(" - плывет")
        return true
    }

    // Рождение рыбки
    override fun giveBirth(): Fish {
        energy = Random.nextInt(from = 1, until = 10)
        weight = Random.nextInt(from = 1, until = 5)
        currentAge = 0
        println("Родилась рыбка.")
        NatureReserve.add(this)
        return this
    }
}