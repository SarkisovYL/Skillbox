package module_11.Generics_And_Utility_Classes

//  ���������
interface Damage {
    val loss: Int               // ����
    val chance: Int             // ���� ������������ ����� (����������� 1 - 100 %)
    val coefficient: Int        // ����������� ������������ �����

    //  ��������� �������� ����� (������������ ������� ���� � ������������ � ������ ������������ �����
    //  � ������������� ������������ �����).
    fun get(): Int = if (Int.Companion.random(chance)) coefficient * loss else 0
}