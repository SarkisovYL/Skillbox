package module_11.Generics_And_Utility_Classes

class Battle(
    val firstTeam: Team,            // Команда 1
    val secondTeam: Team,           // Команда 2
    var endBattle: Boolean  = false // Битва завершена
) {
    //  Получить состояние сражения.
    private fun getConditionBattle(): BattleState {
        if ((firstTeam.getWarriorRandom() != null) && (secondTeam.getWarriorRandom() != null))
            return BattleState.Progress
        if ((firstTeam.getWarriorRandom() != null) && (secondTeam.getWarriorRandom() == null)) {
            endBattle = true
            return BattleState.VictoryFirstTeam
        }
        if ((firstTeam.getWarriorRandom() == null) && (secondTeam.getWarriorRandom() != null)) {
            endBattle = true
            return BattleState.VictorySecondTeam
        }
        endBattle = true
        return BattleState.Draw
    }

    //  Совершить итерацию битвы.
    //  Воины двух команд перемешиваются. Воины из каждой команды наносят друг другу урон по очереди, если они живы.
    fun nextStepBattle() {
        val warriorFirstTeam = firstTeam.getWarriorRandom()
        val warriorSecondTeam = secondTeam.getWarriorRandom()
        if (warriorFirstTeam == null || warriorSecondTeam == null) {
            getBattleState(getConditionBattle())
        }
        else {
            warriorFirstTeam.attack(warriorSecondTeam)
            warriorSecondTeam.attack(warriorFirstTeam)
            getBattleState(getConditionBattle())
        }
    }

    //  Получить статус битвы.
    fun getBattleState(op: BattleState) = when (op) {
        is BattleState.Progress -> println("Битва продолжается. Следующий шаг.")
        is BattleState.VictoryFirstTeam -> {
            println("*".repeat(30) + " БИТВА ОКОНЧЕНА. ПОБЕДИЛА КОМАНДА 1 '${firstTeam.name}'. " + "*".repeat(30))
            endBattle = true
        }
        is BattleState.VictorySecondTeam -> {
            println("*".repeat(30) + " БИТВА ОКОНЧЕНА. ПОБЕДИЛА КОМАНДА 2 '${secondTeam.name}'. " + "*".repeat(30))
            endBattle = true
        }
        is BattleState.Draw -> {
            println("*".repeat(30) + " БИТВА ОКОНЧЕНА. НИЧЬЯ. " + "*".repeat(30))
            endBattle = true
        }
    }
}