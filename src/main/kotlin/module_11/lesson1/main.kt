package module_11.lesson1

import module_07.Car

fun main() {
    val car1 = Car()
    val car2 = Car()
    val car3 = car1

    println(car1 === car3)
    println(car1 === car2)

    val a = Car()
    val b = Car()
    a == b
//    TODO ��� ������ ���������� ������
    a?.equals(b) ?: b === null
//    TODO � ������� � ���������� ������� equals � ������� ���������� ������ b.
//     ���� ������ a ����� null, �� �������� �������� ���������� "�����" ������� b �� ��������� null
//     � ������� ��������� �� ������
    println(
        Person(
            name = "Name",
            lastname = "LastName",
            passportSeries = 9999,
            passportNumber = 999999
        )
    )
//    TODO ��� ��������������� ������� toString() � ������ Person ��������� module_11.lesson1.Person@13fd10
//     �������� ������, ����� ������� � ��� ���-������� � 16-�� ������� ����.
}