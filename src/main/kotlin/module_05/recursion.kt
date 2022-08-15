package module_05

// ���������� �������� ��� ���� ������� �������� �������.
// ������ - ������� � ������� ����� �� N �� 1 � ����� -1

fun main() {
    var n = readLine()?.toIntOrNull() ?: return
    printNumbers(n)

    println("Summ numbers 0..$n - ${calculateSum(n)}")

    println("Summ numbers 0..$n - ${calculateSumTailrec(n)}")
}

fun printNumbers(number: Int): Int {
    return if (number > 0) {
        println(number)
        printNumbers(number-1)
    }
    else 0
}

// ������ - ����� ����� ����� �� 0 �� N
// �� ���� ������� ������� ����� (10000000) - �� ����� ������ ������ ������������ �����
// Exception in thread "main" java.lang.StackOverflowError

fun calculateSum(n: Int) : Int {
    if (n == 0) return 0
    return n + calculateSum(n-1)

}

// �� �� ������, �� � �������������� ������������ tailrec
// ��������� �������������� �������� currentSum, ������� ����� �������� �� ����� ����� �� ������ ��������
// �������� ������� ����� - ������.

tailrec fun calculateSumTailrec(n: Int, currentSum: Int = 0) : Int {
    if (n == 0) return currentSum
    return calculateSumTailrec(n-1, currentSum + n)
}