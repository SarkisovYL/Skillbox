package module_11.Generics_And_Utility_Classes

import kotlin.random.Random

fun main() {
    // Начало битвы
    var i = 1
    val battle = Battle(Team("Белые", 6), Team("Красные", 6))
    battle.firstTeam.info(" СОСТАВ КОМАНДЫ 1 '${battle.firstTeam.name}' ")
    battle.secondTeam.info(" СОСТАВ КОМАНДЫ 2 '${battle.secondTeam.name}' ")
    do {
        println("=".repeat(18) + " Итерация $i " + "=".repeat(18))
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
