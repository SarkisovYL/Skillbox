package module_11.lesson3

fun main() {
    Color.WHITE
    println(Color.WHITE.hex)
    Color.WHITE.draw()
    Color.RED.draw()

//    ������� ��� ��������
    println(Color.values().joinToString(","))
//    ����� Hex �� �����
    println(Color.valueOf("RED").hex)
//    ������� ���������� ����� � ������������ � ��� �������
    Color.values().forEach { println("${it.name} - ${it.ordinal}") }
    println(switchColor(Color.RED))
}

//  ������� ��������� ���� � ���������� ������ ����
fun switchColor(color: Color): Color = when(color) {
    Color.WHITE -> Color.BLACK
    Color.BLACK -> Color.RED
    Color.RED -> Color.GREEN
    Color.GREEN -> Color.BLUE
    Color.BLUE -> Color.WHITE
}