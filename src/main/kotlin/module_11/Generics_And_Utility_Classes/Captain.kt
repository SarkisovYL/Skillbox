package module_11.Generics_And_Utility_Classes

class Captain (
    override val title: String = "�������",
    override val maxHealth: Int = 15000,
    override val weapon: AbstractWeapon = Weapons.createRifle(),
    override var currentHealth: Int = 10000,
    override val isKilled: Int = 60,
    override val evasion: Int = 60
): AbstractWarrior() {

}