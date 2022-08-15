package module_07

import kotlin.random.Random

class Car_dop_constructor(val brand: String, val model: String, val color: String = "White") {

//    �������������� ����������� �������� �������� ����������� ����� ����� this � ��������� ����������
    constructor(discriptor: Pair<String, String>, color: String): this (
        brand = discriptor.first,
        model = discriptor.second,
        color = color
    )
//    ���� �������������� ������������� ����������� � �������� ������� ��� �� ��� � ���� �������� ������������
    {
        println("Body secondary constructor")
    }
// ������������ - ��� �������, �� �������� � ������������ ���� ����� ��������� ����� init.
// � ��� ��������� ���, ������� ������ ����������� � ������������ ��� �������� ��������.
// ���������� ������ ���� �� ������� � ���� � �� ���� � ���� ������������.
    init {
        println("Car init 1")
    }

    init {
        println("Car init 2")
    }
}
