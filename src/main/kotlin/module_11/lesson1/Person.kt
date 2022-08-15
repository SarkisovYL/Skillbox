package module_11.lesson1

class Person (
    val name: String,
    val lastname: String,
    val passportSeries: Int,
    val passportNumber: Int
) {
    //  ���� ��������� ���������. ����� �� Person + alt-insert -> equals() and  hashCode()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true                 // ���� ������� ���������� - �� ������� true � �����
        if (javaClass != other?.javaClass) return false // ��������, ��� ������� ����������� ������ ������

        other as Person                                 // �������� ����������

        if (passportSeries != other.passportSeries) return false    // �������� �������� �����
        if (passportNumber != other.passportNumber) return false    // �������� �������� �����

        return true
    }

    override fun hashCode(): Int {
        var result = passportSeries
        result = 31 * result + passportNumber
        return result
    }

    //  ���� ��������� ���������. ����� �� Person + alt-insert -> toString()
    override fun toString(): String {
        return "Person(name='$name', lastname='$lastname', passportSeries=$passportSeries, passportNumber=$passportNumber)"
    }
}