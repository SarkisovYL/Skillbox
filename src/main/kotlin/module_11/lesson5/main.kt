package module_11.lesson5

fun main() {
//    ���������� �������� �� �������� ������ ����� ����� ���������� �������������� ������ Int
    val number: Int = 6
    println(number.isEven())

//    ���������� ����� ����� ���������
    val a = Int.random()
    val b = Int.random()
    println("a - $a b - $b")

//    ���������� ����� �������� �������.
    println(7.isEvenProperty)
}

fun Int.isEven() : Boolean = (this % 2) == 0

fun Int.Companion.random() : Int {
    return (System.currentTimeMillis() % 43).toInt()
}

//  ��� ���������� ����� �������� ���������� GET().
val Int.isEvenProperty
    get() = this % 2 == 0