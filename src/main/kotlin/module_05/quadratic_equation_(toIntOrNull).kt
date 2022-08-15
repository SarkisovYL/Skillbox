package module_05

fun main() {
//    ������� toIntOrNull ��������� ���� �� ����������� ������������� ������ � �����
//    ���� ��� ����������� �� ������������ Null
    println("Enter a")
    val a: Int = readLine()?.toIntOrNull() ?: return
    println("Enter b")
    val b: Int = readLine()?.toIntOrNull() ?: return
    println("Enter c")
    val c: Int = readLine()?.toIntOrNull() ?: return

    val x = solveEquation(a, b, c)
    if (x == null)
        println("��� �������")
    else
        println(x)
}

fun solveEquation(a: Int, b: Int, c: Int): Double? {
    if (a == 0) return null
    return (c - b) /a.toDouble()
}
