package module_11.Generics_And_Utility_Classes

//  ����������� ����� ������
abstract class AbstractWeapon {
    abstract val maxRounds : Int                // ������������ ���������� �������� � ��������
    abstract val fireType: FireType             // ��� �������� (FireType)
    abstract val ammoMagazine: Stack<Ammo>      // ������� ��������. ��� �������� ������ ������� ����
    abstract var roundsInMagazine : Boolean     // ���� ������� �������� � ��������

    abstract fun createAmmo(): Ammo             // �������� ������� ������������ ����

    // ����������� � �������� ����� ������� � ����������� ��������� � ������� ������� �������� �������
    open fun reloading(): Stack<Ammo> {
        repeat(maxRounds) {ammoMagazine.push(this.createAmmo())}
        roundsInMagazine = true
        return ammoMagazine
    }

    // ��������� �������� ��� �������� ��������� ��� ��������. ���������� ������,
    open fun getAmmo() {
        ammoMagazine.pop()
        roundsInMagazine = !ammoMagazine.isEmpty()
    }
    open fun getAmmo(count: Int) {
        repeat(count) {
            ammoMagazine.pop()
            roundsInMagazine = !ammoMagazine.isEmpty()
        }
    }
}