package module_12.Generics_And_Utility_Classes_Throwable

import kotlin.random.Random

// Класс команды Team, которая состоит из воинов
class Team(
    val name: String = "Team",
    private val size: Int = 1
) {
    private val structure = mutableListOf<AbstractWarrior>()
    init {
        repeat(size) { structure.add(addWarrior()) }
    }

    //    В команду воины набираются по вероятности: чем выше вероятность, тем ниже ранг.
    //    Пример: с вероятностью 10% создаётся генерал, иначе с вероятностью 40% создаётся капитан,
    //    иначе создаётся солдат. Для вероятностного выбора используем Функция-расширение для типа Int.
    private fun addWarrior(): AbstractWarrior {
        return if (Int.Companion.random(10)) {
            General()
        } else if (Int.Companion.random(20)) {
            Sniper()
        } else if (Int.Companion.random(40)) {
            Captain()
        } else {
            Soldier()
        }
    }

    //  Получить случайного война из команды
    fun getWarriorRandom(): AbstractWarrior? {
        val liveWars = this.structure.filter {it.currentHealth > 0}     // Список живых войнов
        return if (liveWars.size > 0) {
            liveWars[Random.nextInt(0, liveWars.size)]
        } else {
            null
        }
    }

    fun info() {
        println("-".repeat(50))
        println("В команде ${this.name} из ${this.size} войнов в живых осталось ${this.structure.filter {it.currentHealth > 0}.size}")
        println("Остались в команде $name")
        this.structure.filter {it.currentHealth > 0}.forEachIndexed{i, item -> println(
            "\t№ ${i + 1} Должность: ${item.title} Здоровье: ${item.currentHealth} Оружие: ${item.weapon.name}")}
        println("Погибли в команде $name")
        this.structure.filter {it.currentHealth <= 0}.forEachIndexed{i, item -> println(
            "\t№ ${i + 1} Должность: ${item.title} Оружие: ${item.weapon.name}")}
    }
    fun info(begin: String) {
        println("=".repeat(20) + begin + "=".repeat(20))
        println("КОЛИЧЕСТВО ВОЙНОВ: ${this.size}")
        this.structure.forEachIndexed{i, item -> println(
            "\t№ ${i + 1} Должность: ${item.title} Здоровье: ${item.currentHealth} Оружие: ${item.weapon.name}")}
    }
}