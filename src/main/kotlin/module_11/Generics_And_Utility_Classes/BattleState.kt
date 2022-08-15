package module_11.Generics_And_Utility_Classes

// ��������� ������� ��������� ��������:
// �������� � �������� � ���� ����������� ���������� ��� ������ � �������.
// ��������: ��������� �������� ������� ��� ���������� ���������� ������.
// ������ ������ �������.
// ������ ������ �������.
// �����.
sealed class BattleState() {
    object Progress: BattleState()
    object VictoryFirstTeam: BattleState()
    object VictorySecondTeam: BattleState()
    object Draw: BattleState()

    fun getBattleState(op: BattleState) = when (op) {
        is Progress -> println("�������")
        is VictoryFirstTeam -> println("������ ������� 1")
        is VictorySecondTeam -> println("������ ������� 2")
        is Draw -> println("�����")
    }
}
