package module_11.Generics_And_Utility_Classes

//  ������ ��� ������, ����������� �� AbstractWarrior
class Sniper (
    override val title: String = "�������",
    override val maxHealth: Int = 10000,
    override val weapon: AbstractWeapon = Weapons.createSniper(),
    override var currentHealth: Int = 5000,
    override val isKilled: Int = 100,
    override val evasion: Int = 60
): AbstractWarrior() {

}