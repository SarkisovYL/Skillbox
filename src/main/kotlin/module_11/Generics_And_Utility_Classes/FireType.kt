package module_11.Generics_And_Utility_Classes

//  Sealed-класс для вида стрельбы FireType
sealed class FireType {
//    Наследники класса:
//      одиночный выстрел (singleton object)
    object SingleShot: FireType() {

    }

//      стрельба очередями (data class), в конструкторе принимает параметр «размер очереди»
//    data class FiringBursts(val sizeQueue: Int) {
    data class FiringBursts(val sizeQueue: Int): FireType() {

    }
}