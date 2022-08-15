package module_08.OOP

import kotlin.random.Random

class Bird(energy: Int, weight: Int, maxAge: Int, name: String) : Animal(
    energy = energy,
    weight = weight,
    maxAge = maxAge,
    name = name
) {
    // Передвижение птицы
    override fun move(): Boolean {
        if (super.move()) println(" - летит")
        return true
    }

    // Рождение птенца
    override fun giveBirth(): Bird {
        energy = Random.nextInt(from = 1, until = 10)
        weight = Random.nextInt(from = 1, until = 5)
        currentAge = 0
        println("Вылупился птенец.")
        NatureReserve.add(this)
        return this
    }
}