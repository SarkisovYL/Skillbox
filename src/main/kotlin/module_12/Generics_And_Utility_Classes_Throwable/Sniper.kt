package module_12.Generics_And_Utility_Classes_Throwable

//  Классы для воинов, наследуемых от AbstractWarrior
class Sniper (
    override val title: String = "Снайпер",
    override val maxHealth: Int = 10000,
    override val weapon: AbstractWeapon = Weapons.createSniper(),
    override var currentHealth: Int = 5000,
    override val isKilled: Int = 100,
    override val evasion: Int = 60
): AbstractWarrior()