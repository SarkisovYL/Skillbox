package module_11.Generics_And_Utility_Classes

//  Абстрактный класс AbstractWarrior, который реализует интерфейс Warrior
abstract class AbstractWarrior : Warrior{
    abstract val title : String            // Звание
    abstract var currentHealth : Int       // Текущий уровень здоровья
    abstract val maxHealth : Int           // Максимальный уровень здоровья
    abstract val weapon: AbstractWeapon    // Оружие
    abstract override val isKilled: Int    // Точность, вероятность попадания максимум 100
    abstract override val evasion: Int     // Уклонение — шанс избежать попадания максимум 100

    // Атаковать (метод интерфейса) — если патронов в оружии нет, перезарядить оружие и пропустить ход.
    // В противном случае получить патроны для выстрела. Для каждого из них проверить, соответствует ли патрон
    // точности война и уклонению противника. Для патронов, которые попадают в противника,
    // рассчитать суммарный урон. Нанести урон врагу.
    // На вход принимает противника (Warrior)
    override fun attack(enemy: Warrior) {
        println("Количество патронов у $title - ${weapon.ammoMagazine.count()}")
        weapon.getCartridge(weapon.fireType)
        // Сравнить шанс поражения с шансом избежать попадания и исходя из результата нанести урон или избежать урона.
        val chanceisKilled = (1..enemy.isKilled).random()
        val chanceEvasion = (1..enemy.evasion).random()
        if (chanceisKilled > chanceEvasion) enemy.setLoss(weapon.createAmmo().get())
    }

    // Понести урон - отнять от текущего уровня здоровья - урон. Если здоровье 0 - убит.
    // На вход принимает количество урона
    override fun setLoss(loss: Int) {
        currentHealth -= loss
        if (currentHealth < 0) currentHealth = 0
        println("Нанесен урон $loss. Текущее здоровье $title: $currentHealth")
    }
}