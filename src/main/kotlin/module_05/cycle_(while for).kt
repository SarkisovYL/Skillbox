package module_05

// ������� � ������� ��� ����� �� 0 �� N � ���������� �� �����. � �������� � ����������.

fun main() {
    println("Enter number:")
    val n = readLine()?.toIntOrNull() ?: return
    // ���� �������� ��������� �� Null - �� ���������� ��������� ��������, ����� ���������
    // ���������� ������������ ������ if (n == null) return

//    ������� ������ � ������� ����� while (���� � ������������,
//    �.�. ����� � ������ ����������� �������, � ����� ����������� ��������)
    var i = 0
    var sum = 0

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
    sum = 0
    for (a in 0..n) {
        if (a % 2 != 0) continue
        println(a)
        sum += a
    }
    println("Sum of sum of even $n numbers - $sum")

//    ������� ������ � ������� ������� forEach � ������ ��������� � �������� ������ it
//    it: ������� ��� ������������� ���������
//    ����� ����� ������-��������� ����� ������ ���� ��������.
//    ���� ���������� �������� �������������� ���������� ���������, �� ���������� ��������� ����� �������� ������
//    � ->. �������� ����� ������ �������� ��� ������ it

    val myArea = MutableList(n) { it }
    myArea.forEach{b -> println("Numbers from list - $b") }

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
