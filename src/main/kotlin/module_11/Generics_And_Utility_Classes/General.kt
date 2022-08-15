package module_11.Generics_And_Utility_Classes

class General(
    override val title: String = "�������",
    override val maxHealth: Int = 20000,
    override val weapon: AbstractWeapon = Weapons.createPistol(),
    override var currentHealth: Int = 15000,
    override val isKilled: Int = 90,
    override val evasion: Int = 90
): AbstractWarrior() {

}