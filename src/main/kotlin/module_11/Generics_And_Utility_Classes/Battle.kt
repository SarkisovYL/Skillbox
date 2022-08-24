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
            println("����� ��������. �������� ������� 1 '${firstTeam.name}'")
            endBattle = true
        }
        is BattleState.VictorySecondTeam -> {
            println("����� ��������. �������� ������� 2 '${secondTeam.name}'")
            endBattle = true
        }
        is BattleState.Draw -> {
            println("����� ��������. �����")
            endBattle = true
        }
    }
}