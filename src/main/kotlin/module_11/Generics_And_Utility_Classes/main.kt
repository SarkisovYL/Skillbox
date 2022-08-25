package module_11.Generics_And_Utility_Classes

import kotlin.random.Random

fun main() {
    // ������ �����
    var i = 1
    val battle = Battle(Team("�����", 2), Team("�������", 2))
    battle.firstTeam.info(" ������ ������� 1 '${battle.firstTeam.name}' ")
    battle.secondTeam.info(" ������ ������� 2 '${battle.secondTeam.name}' ")
    do {
        println("=".repeat(18) + " �������� $i " + "=".repeat(18))
        battle.nextStepBattle()
        battle.firstTeam.info()
        battle.secondTeam.info()
        i += 1
    } while (!battle.endBattle)
}

//    �������-���������� ��� ���� Int. ���������� ����� ����� ���������
fun Int.Companion.random(chance: Int): Boolean {
    return Random.nextInt(100) <= chance    // ���������� ���� ?
}
