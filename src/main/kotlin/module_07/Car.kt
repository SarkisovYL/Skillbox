package module_07

import kotlin.random.Random

class Car {
//    Свойства класса:
    val brand = "Audi"
    val model ="A3"
    val color = "Red"
//    Методы класса
    //    Расстояние на которое переместился автомобиль
    fun move() {
        val distance = Random.nextInt(1, 10)
        println("Car passed $distance km")
    }

    fun start() {
        println("Car started")
    }

    fun stop() {
        println("Car stopped")
    }
}
