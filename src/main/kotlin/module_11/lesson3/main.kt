package module_11.lesson3

fun main() {
    val person = Person("name", "lastname")

//    ����������������� ������������.
    val (name, lastname) = person   // ��������� �������� ���������� name � lastname
    println(name)
    println(lastname)
//    ������ ������������������ ������������ ������������ ����� ������������ � ��������� ����
//    component1() ������������ ������������� ��� ����� �������������� � ������������ ������ �� �� �������.
    val name1 = person.component1()
    val lastname1 = person.component2()
    println(name1)
    println(lastname1)
}