package module_11.Generics_And_Utility_Classes

//  ����������� ����� AbstractWarrior, ������� ��������� ��������� Warrior
abstract class AbstractWarrior : Warrior{
    abstract val title : String            // ������
    abstract var currentHealth : Int       // ������� ������� ��������
    abstract val maxHealth : Int           // ������������ ������� ��������
    abstract val weapon: AbstractWeapon    // ������
    abstract override val isKilled: Int    // ��������, ����������� ��������� �������� 100
    abstract override val evasion: Int     // ��������� � ���� �������� ��������� �������� 100

    // ��������� (����� ����������) � ���� �������� � ������ ���, ������������ ������ � ���������� ���.
    // � ��������� ������ �������� ������� ��� ��������. ��� ������� �� ��� ���������, ������������� �� ������
    // �������� ����� � ��������� ����������. ��� ��������, ������� �������� � ����������,
    // ���������� ��������� ����. ������� ���� �����.
    // �� ���� ��������� ���������� (Warrior)
    override fun attack(enemy: Warrior) {
        println("���������� �������� � $title - ${weapon.ammoMagazine.count()}")
        weapon.getCartridge(weapon.fireType)
        // �������� ���� ��������� � ������ �������� ��������� � ������ �� ���������� ������� ���� ��� �������� �����.
        val chanceisKilled = (1..enemy.isKilled).random()
        val chanceEvasion = (1..enemy.evasion).random()
        if (chanceisKilled > chanceEvasion) enemy.setLoss(weapon.createAmmo().get())
    }

    // ������� ���� - ������ �� �������� ������ �������� - ����. ���� �������� 0 - ����.
    // �� ���� ��������� ���������� �����
    override fun setLoss(loss: Int) {
        currentHealth -= loss
        println("������� ���� $loss. ������� �������� $title: $currentHealth")
    }
}