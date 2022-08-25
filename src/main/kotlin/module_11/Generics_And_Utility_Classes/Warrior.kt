package module_11.Generics_And_Utility_Classes

//  интерфейс воин (Warrior)
interface Warrior {
    val isKilled: Int           // Точность, вероятность попадания максимально 100
    val evasion: Int            // Уклонение, шанс избежать попадания максимально 100
    fun attack(enemy: Warrior)  // Атаковать — на вход принимает противника (Warrior)
    fun setLoss(loss: Int)      // Получить урон — на вход принимает количество урона
}