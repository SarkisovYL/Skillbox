package module_11.Generics_And_Utility_Classes

//  Sealed-класс для вида стрельбы FireType
sealed class FireType {
//    Наследники класса:
//      Одиночный выстрел (singleton object)
    object SingleShot: FireType()

//      Стрельба очередями (data class). Data class в конструкторе принимает параметр «размер очереди»
    data class FiringBursts(val sizeQueue: Int): FireType()
}