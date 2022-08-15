package module_09

import kotlin.random.Random

fun main() {
//    val transropter = Transporter(maxWeight = 1000)
    val train = Train(maxWeight = 1000)
    println("capacity - ${train.capacity}")
    train.move()

    println("============ САМОЛЕТ ============")
    val boeing737 = createAndFillBoeing()
    println(boeing737.getInfo())
    boeing737.getSeatScheme()

    println("=========== ДИРЕЖАБЛЬ ===========")
    val zeppelin = createAndFillZeppelin()
    println(zeppelin.getInfo())
    zeppelin.getSeatScheme()
}

fun createAndFillBoeing() : Boeing737 {
    val boeing737 = Boeing737()
    val passengersCount = Random.nextInt(1, boeing737.capacity)
    for (i in 0 until passengersCount) {
        val seat = boeing737.getAvailableSeat() ?: return boeing737

        val passenger = Passenger(
            name = "Ivan",
            lastName = "Petrov",
            passport = "${Random.nextInt(1000, 9999)} ${Random.nextInt(100000, 999999)}",
            seat = seat
        )
        boeing737.addPassenger(passenger)
    }
    return boeing737
}

fun createAndFillZeppelin() : Zeppelin {
    val zeppelin = Zeppelin()
    val zeppelinPassenger = Random.nextInt(1, zeppelin.capacity)
    for (i in 0 until zeppelinPassenger) {
        val seat = zeppelin.getAvailableSeat() ?: return zeppelin

        val passenger = Passenger(
            name = "Ivan",
            lastName = "Petrov",
            passport = "${Random.nextInt(1000, 9999)} ${Random.nextInt(100000, 999999)}",
            seat = seat
        )
        zeppelin.addPassenger(passenger)
    }
    return zeppelin
}