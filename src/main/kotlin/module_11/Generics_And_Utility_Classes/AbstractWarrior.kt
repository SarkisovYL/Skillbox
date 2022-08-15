package module_11.Generics_And_Utility_Classes

//  ����������� ����� AbstractWarrior, ������� ��������� ��������� Warrior
abstract class AbstractWarrior : Warrior{
    abstract val title : String            // ������
    abstract var currentHealth : Int       // ������� ������� ��������
    abstract val maxHealth : Int           // ������������ ������� ��������
    abstract val weapon: AbstractWeapon    // ������
    abstract override val isKilled: Int    // ��������, ����������� ��������� �������� 100
    abstract override val evasion: Int     // ��������� � ���� �������� ��������� �������� 100

    // ���������
    override fun attack(enemy: Warrior) {

    }
    // ������� ���� - ������ �� �������� ������ �������� - ����. ���� �������� 0 - ����.
    override fun setLoss(loss: Int) {
        this.currentHealth -= loss
        println("${this.title}: $currentHealth")
    }
}