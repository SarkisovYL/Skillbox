package module_11.Generics_And_Utility_Classes

import kotlin.random.Random

fun main() {
    // Начало битвы
    var i = 1
    val battle = Battle(Team("Белые", 20), Team("Красные", 25))
    do {
        println("============== Итерация $i ======================")
        battle.nextStepBattle()
        battle.firstTeam.info()
        battle.secondTeam.info()
        i += 1
    } while (!battle.endBattle)
}

//    Функция-расширение для типа Int. Реализация через класс компаньон
fun Int.Companion.random(chance: Int): Boolean {
    return Random.nextInt(100) <= chance    // Реализован шанс ?
}
