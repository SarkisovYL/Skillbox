package module_05

import kotlin.random.Random

// ������� � ������� ��� ����� �� 0 �� N � ���������� �� �����. � �������� � ����������.

fun main() {
    println("Enter number:")
    val n = readLine()?.toIntOrNull() ?: return
    // ���� �������� ��������� �� Null - �� ���������� ��������� ��������, ����� ���������
    // ���������� ������������ ������ if (n == null) return

//    ������� ������ � ������� ����� while (���� � ������������,
//    �.�. ����� � ������ ����������� �������, � ����� ����������� ��������)
    var i: Int = 0
    var sum: Int = 0

    while (i <= n) {
        println(i)
        sum += i
        i++
    }
    println("Sum of first $n numbers - $sum")

//    ������� ������ � ������� ����� dowhile (���� � gjcktle.obv eckjdbtv,
//    �.�. ����� � ������ ����������� ��������, � ����� ����������� �������).
//    � ���� ������ ������ �������� ����������� ������.


//    ������� ������ � ������� ����� for
    i = 0
    sum = 0
    for (i in 0..n) {
        if (i % 2 != 0) continue
        println(i)
        sum += i
    }
    println("Sum of sum of even $n numbers - $sum")

//    ������� ������ � ������� ������� forEach � ������ ��������� � �������� ������ it
//    it: ������� ��� ������������� ���������
//    ����� ����� ������-��������� ����� ������ ���� ��������.
//    ���� ���������� �������� �������������� ���������� ���������, �� ���������� ��������� ����� �������� ������
//    � ->. �������� ����� ������ �������� ��� ������ it

    var myArea = MutableList(n) { it }
    myArea.forEach{i -> println("Numbers from list - $i") }

//    ���������� ����� ����� ������� � N �� ��� ���, ���� ����� �� �������� ����� 100.
//    � ����������� �� ����� ���������� ���������� �����, ����������� ����� ����� ��������� 100

    doWhileFun(60)
}

fun doWhileFun(currentSum: Int) {
    var count = 0
    var sum = currentSum
    println("Enter a start number:")
    var n= readLine()?.toIntOrNull() ?: return
    do {
        println("correct number - $n")
        sum += n
        println("sum - $sum")
        n++
        count++
    } while (sum < 100)
    println("Number count - $count")
}
