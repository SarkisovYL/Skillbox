package module_11.Generics_And_Utility_Classes

//  Абстрактный класс AbstractWarrior, который реализует интерфейс Warrior
abstract class AbstractWarrior : Warrior{
    abstract val title : String            // Звание
    abstract var currentHealth : Int       // Текущий уровень здоровья
    abstract val maxHealth : Int           // Максимальный уровень здоровья
    abstract val weapon: AbstractWeapon    // Оружие
    abstract override val isKilled: Int    // Точность, вероятность попадания максимум 100
    abstract override val evasion: Int     // Уклонение — шанс избежать попадания максимум 100

    // Атаковать
    override fun attack(enemy: Warrior) {

    }
    // Понести урон - отнять от текущего уровня здоровья - урон. Если здоровье 0 - убит.
    override fun setLoss(loss: Int) {
        this.currentHealth -= loss
        println("${this.title}: $currentHealth")
    }
}