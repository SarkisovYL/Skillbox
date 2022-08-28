package module_12.Generics_And_Utility_Classes_Throwable

// Описывает текущее состояние сражения:
// Прогресс — содержит в себе необходимую информацию для вывода в консоль.
// Например: суммарное здоровье команды или количество оставшихся воинов.
// Победа первой команды.
// Победа второй команды.
// Ничья.
sealed class BattleState {
    object Progress: BattleState()
    object VictoryFirstTeam: BattleState()
    object VictorySecondTeam: BattleState()
    object Draw: BattleState()
}
