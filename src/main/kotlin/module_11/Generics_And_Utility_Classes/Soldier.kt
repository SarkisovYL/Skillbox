package module_11.Generics_And_Utility_Classes

class Soldier(
    override val title: String = "������",
    override val maxHealth: Int = 10000,
    override val weapon: AbstractWeapon = Weapons.createMachineGun(),
    override var currentHealth: Int = 5000,
    override val isKilled: Int = 30,
    override val evasion: Int = 30
): AbstractWarrior() {

}