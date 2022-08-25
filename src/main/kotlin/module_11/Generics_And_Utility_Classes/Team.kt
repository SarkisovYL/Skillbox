package module_11.Generics_And_Utility_Classes

import kotlin.random.Random

// ����� ������� Team, ������� ������� �� ������
class Team(
    val name: String = "Team",
    private val size: Int = 1
) {
    private val structure = mutableListOf<AbstractWarrior>()
    init {
        repeat(size) { structure.add(addWarrior()) }
    }

    //    � ������� ����� ���������� �� �����������: ��� ���� �����������, ��� ���� ����.
    //    ������: � ������������ 10% �������� �������, ����� � ������������ 40% �������� �������,
    //    ����� �������� ������. ��� �������������� ������ ���������� �������-���������� ��� ���� Int.
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

    //  �������� ���������� ����� �� �������
    fun getWarriorRandom(): AbstractWarrior? {
        val liveWars = this.structure.filter {it.currentHealth > 0}     // ������ ����� ������
        return if (liveWars.size > 0) {
            liveWars[Random.nextInt(0, liveWars.size)]
        } else {
            null
        }
    }

    fun info() {
        println("-".repeat(50))
        println("� ������� ${this.name} �� ${this.size} ������ � ����� �������� ${this.structure.filter {it.currentHealth > 0}.size}")
        println("�������� � ������� $name")
        this.structure.filter {it.currentHealth > 0}.forEachIndexed{i, item -> println(
            "\t� ${i + 1} ���������: ${item.title} ��������: ${item.currentHealth} ������: ${item.weapon.name}")}
        println("������� � ������� $name")
        this.structure.filter {it.currentHealth <= 0}.forEachIndexed{i, item -> println(
            "\t� ${i + 1} ���������: ${item.title} ������: ${item.weapon.name}")}
    }
    fun info(begin: String) {
        println("=".repeat(20) + begin + "=".repeat(20))
        println("���������� ������: ${this.size}")
        this.structure.forEachIndexed{i, item -> println(
            "\t� ${i + 1} ���������: ${item.title} ��������: ${item.currentHealth} ������: ${item.weapon.name}")}
    }
}