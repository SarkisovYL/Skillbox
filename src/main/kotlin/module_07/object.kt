package module_07

// ������ ������ �������� �����. �������� object-����.
fun main() {
    println("Height - ${EiffelTower.height}")
    EiffelTower.turnOnBacklights()
    EiffelTower.turnOffBacklights()

//  COMPANION OBJECT
//    ���������� � ������ COMPANION OBJECT ����� ������ ����� �����, � �� ����� ��������� ������

    println("Weels count - ${CarCompanioObject.wheelsCount}")
    val classType = CarCompanioObject.getCarClass(3.8f)
    println(classType)

    val auto5 = CarCompanioObject("VAZ" to "Niva", "Brawn")
//    auto5.getCarClass - �� ��������
//    auto5.wheelsCount - �� ��������
}