package module_11.Generics_And_Utility_Classes

//  Sealed-����� ��� ���� �������� FireType
sealed class FireType {
//    ���������� ������:
//      ��������� ������� (singleton object)
    object SingleShot: FireType() {

    }

//      �������� ��������� (data class), � ������������ ��������� �������� ������� �������
//    data class FiringBursts(val sizeQueue: Int) {
    data class FiringBursts(val sizeQueue: Int): FireType() {

    }
}