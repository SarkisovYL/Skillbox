package module_11.Generics_And_Utility_Classes

//  ����������� ����� ������
abstract class AbstractWeapon {
    abstract val maxRounds : Int                // ������������ ���������� �������� � ��������
    abstract val fireType: FireType             // ��� �������� (FireType)
    abstract val ammoMagazine: Stack<Ammo>      // ������� ��������. ��� �������� ������ ������� ����
    abstract var roundsInMagazine : Boolean     // ���� ������� �������� � ��������
    abstract var name : String                  // ������������ ������

    abstract fun createAmmo(): Ammo             // �������� ������� ������������ ����

    // ����������� � �������� ����� ������� � ����������� ��������� � ������� ������� �������� �������
    open fun reloading(): Stack<Ammo> {
        println("�����������")
        repeat(maxRounds) {ammoMagazine.push(createAmmo())}
        roundsInMagazine = true
        println("�������� � �������� ${ammoMagazine.count()}")
        return ammoMagazine
    }
    // ��������� �������� ��� �������� ��������� ��� ��������.
    fun getCartridge(ft: FireType) = when (ft) {
//      ���� ������� �����������, ������������ � ���������� ��������.
        is FireType.SingleShot -> ammoMagazine.pop() ?: reloading()
        is FireType.FiringBursts -> repeat(ft.sizeQueue) { ammoMagazine.pop() ?: reloading()}
    }
}