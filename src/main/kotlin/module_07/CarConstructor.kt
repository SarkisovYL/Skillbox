package module_07

import kotlin.random.Random

class CarConstructor(val brand: String, val model: String, val color: String = "White") {

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