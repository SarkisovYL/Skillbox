package module_11.Generics_And_Utility_Classes

import kotlin.random.Random

class Team(
    val name: String = "Team",
    val size: Int = 1
) {
    private val structure = mutableListOf<AbstractWarrior>()
    init {
        repeat(size) { structure.add(addWarrior()) }
    }

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

    fun getWarriorRandom(): AbstractWarrior {
        return this.structure[Random.nextInt(0, this.size)]
    }

    fun info() {
        println("������ � ���������� ������� $name")
        this.structure.forEachIndexed{i, item -> println(
            "� ${i + 1} ���������: ${item.title} ��������: ${item.currentHealth} ������: ${item.weapon}")}
    }
}