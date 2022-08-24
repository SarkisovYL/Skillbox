package module_11.Generics_And_Utility_Classes

//  ��������� ���� (Warrior)
interface Warrior {
    val isKilled: Int           // ��������, ����������� ��������� ����������� 100
    val evasion: Int            // ���������, ���� �������� ��������� ����������� 100
    fun attack(enemy: Warrior)  // ��������� � �� ���� ��������� ���������� (Warrior)
    fun setLoss(loss: Int)      // �������� ���� � �� ���� ��������� ���������� �����
}