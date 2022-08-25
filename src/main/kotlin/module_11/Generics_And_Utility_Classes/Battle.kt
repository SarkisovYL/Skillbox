package module_11.Generics_And_Utility_Classes

class Battle(
    val firstTeam: Team,            // ������� 1
    val secondTeam: Team,           // ������� 2
    var endBattle: Boolean  = false // ����� ���������
) {
    //  �������� ��������� ��������.
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

    //  ��������� �������� �����.
    //  ����� ���� ������ ��������������. ����� �� ������ ������� ������� ���� ����� ���� �� �������, ���� ��� ����.
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

    //  �������� ������ �����.
    fun getBattleState(op: BattleState) = when (op) {
        is BattleState.Progress -> println("����� ������������. ��������� ���.")
        is BattleState.VictoryFirstTeam -> {
            println("*".repeat(30) + " ����� ��������. �������� ������� 1 '${firstTeam.name}'. " + "*".repeat(30))
            endBattle = true
        }
        is BattleState.VictorySecondTeam -> {
            println("*".repeat(30) + " ����� ��������. �������� ������� 2 '${secondTeam.name}'. " + "*".repeat(30))
            endBattle = true
        }
        is BattleState.Draw -> {
            println("*".repeat(30) + " ����� ��������. �����. " + "*".repeat(30))
            endBattle = true
        }
    }
}