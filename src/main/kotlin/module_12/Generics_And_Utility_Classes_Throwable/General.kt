package module_12.Generics_And_Utility_Classes_Throwable

//  Классы для воинов, наследуемых от AbstractWarrior
class General(
    override val title: String = "Генерал",
    override val maxHealth: Int = 20000,
    override val weapon: AbstractWeapon = Weapons.createPistol(),
    override var currentHealth: Int = 15000,
    override val isKilled: Int = 90,
    override val evasion: Int = 90
): AbstractWarrior()