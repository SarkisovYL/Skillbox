package module_11.Generics_And_Utility_Classes

// Описывает текущее состояние сражения:
// Прогресс — содержит в себе необходимую информацию для вывода в консоль.
// Например: суммарное здоровье команды или количество оставшихся воинов.
// Победа первой команды.
// Победа второй команды.
// Ничья.
sealed class BattleState() {
    object Progress: BattleState()
    object VictoryFirstTeam: BattleState()
    object VictorySecondTeam: BattleState()
    object Draw: BattleState()

    fun getBattleState(op: BattleState) = when (op) {
        is Progress -> println("Процесс")
        is VictoryFirstTeam -> println("Победа команды 1")
        is VictorySecondTeam -> println("Победа команды 2")
        is Draw -> println("Ничья")
    }
}
