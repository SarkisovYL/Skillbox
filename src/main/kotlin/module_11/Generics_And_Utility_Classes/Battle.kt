package module_11.Generics_And_Utility_Classes

class Battle(
    val firstTeam: Team,      // Команда 1
    val secondTeam: Team,      // Команда 2
    val endBattle: Boolean  // битва завершена
) {
    //  Получить состояние сражения.
    fun getStatusBattle(): BattleState {
        if ((firstTeam.size > 0) && (secondTeam.size > 0))
            return BattleState.Progress
        if ((firstTeam.size > 0) && (secondTeam.size <= 0))
            return BattleState.VictoryFirstTeam
        if ((firstTeam.size <= 0) && (secondTeam.size > 0))
            return BattleState.VictorySecondTeam
        else return BattleState.Draw
    }

    //  Совершить итерацию битвы.
    fun nextStepBattle() {

    }
}