package module_11.Generics_And_Utility_Classes

// ��������� ������� ��������� ��������:
// �������� � �������� � ���� ����������� ���������� ��� ������ � �������.
// ��������: ��������� �������� ������� ��� ���������� ���������� ������.
// ������ ������ �������.
// ������ ������ �������.
// �����.
sealed class BattleState {
    object Progress: BattleState()
    object VictoryFirstTeam: BattleState()
    object VictorySecondTeam: BattleState()
    object Draw: BattleState()
}
