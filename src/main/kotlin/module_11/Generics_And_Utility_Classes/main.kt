package module_11.Generics_And_Utility_Classes

import kotlin.random.Random

fun main() {
    // ������ �����
    var i = 1
    val battle = Battle(Team("�����", 20), Team("�������", 25))
    do {
        println("============== �������� $i ======================")
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
