package module_07

fun main() {
    val auto = Car()
    val auto2 = CarConstructor(model = "Beetle", brand = "VW")
    val auto3 = Car_dop_constructor("Renault" to "Logan", "Blue")
    val auto4 = CarGetSet("VAZ" to "Niva", "Brawn")

    println("Auto info")
    println("Brand - ${auto.brand}, Model - ${auto.model}, Color - ${auto.color}")
    println("Brand - ${auto2.brand}, Model - ${auto2.model}, Color - ${auto2.color}")
    println("Brand - ${auto3.brand}, Model - ${auto3.model}, Color - ${auto3.color}")
    println("Brand - ${auto4.brand}, Model - ${auto4.model}, Color - ${auto4.color}")

    auto.start()
    auto.move()
    auto.move()
    auto.move()
    auto.stop()

    auto2.start()
    auto2.move()
    auto2.move()
    auto2.move()
    auto2.stop()

    println("Current speed ${auto4.model} - ${auto4.currentSpeed}")
    println("Current fuel ${auto4.model} - ${auto4.fuelCount}")

    auto4.accelerate(100.0f)
    println("Current speed ${auto4.model} - ${auto4.currentSpeed}")
    println("Current fuel ${auto4.model} - ${auto4.fuelCount}")

    auto4.decelerate(50.0f)
    println("Current speed ${auto4.model} - ${auto4.currentSpeed}")
    println("Current fuel ${auto4.model} - ${auto4.fuelCount}")

//    auto4.currentSpeed = 50.0f      // Ошибка, т.к сеттер имеет модификатор privet и недоступен из модуля
}