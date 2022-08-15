package module_11.lesson3

fun main() {
    println(switchColor(SealedColor.Red))
    println(switchColor(SealedColor.Blue))
}

//  ������� ��������� ���� � ���������� ������ ����
fun switchColor(color: SealedColor): SealedColor = when(color) {
    SealedColor.While -> SealedColor.Black
    SealedColor.Black -> SealedColor.Red
    SealedColor.Red -> SealedColor.Green
    SealedColor.Green -> SealedColor.Blue
//    TODO ��� ������� �������� ��������� �������� � �� ���������-������������, �� ������ ������������ �������� "is"
    is SealedColor.CustomColor -> SealedColor.CustomColor("#345")
//    TODO �� ����� ��� ��������� � �������������� ��������� "is", �.�. � ������ sealed ������ �����
//     �������� ������ �� ����� � ��� ��������� ����� ������.
    is SealedColor.Blue -> SealedColor.While
}
