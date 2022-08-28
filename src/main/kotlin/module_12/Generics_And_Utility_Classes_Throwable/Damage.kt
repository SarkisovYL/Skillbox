package module_12.Generics_And_Utility_Classes_Throwable

//  Интерфейс
interface Damage {
    val loss: Int               // Урон
    val chance: Int             // Шанс критического урона (вероятность 1 - 100 %)
    val coefficient: Int        // Коэффициент критического урона

    //  Получение текущего урона (рассчитывает текущий урон в соответствии с шансом критического урона
    //  и коэффициентом критического урона).
    fun get(): Int = if (Int.Companion.random(chance)) coefficient * loss else 0
}