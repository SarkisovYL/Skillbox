package module_11.lesson2

import java.time.format.DateTimeFormatter
import kotlin.random.Random

fun main() {
    val train = Train(maxWeight = 1000)
    println("capacity - ${train.capacity}")
    train.move()

    println("============ САМОЛЕТ ============")
    val boeing737 = Boeing737()
    fillAircraft(boeing737)
    println(boeing737.getInfo())
    boeing737.getSeatScheme()
    printPassengerInfo(aircraft = boeing737, seat = Seat(0, 'C'))
    printPassengerInfo(aircraft = boeing737, seat = Seat(3, 'A'))
    printPassengerInfo(aircraft = boeing737, seat = Seat(25, 'D'))
    printPassengerInfo(aircraft = boeing737, seat = Seat(10, 'E'))


    println("=========== ДИРЕЖАБЛЬ ===========")
    val zeppelin = Zeppelin()
    fillAircraft(zeppelin)
    println(zeppelin.getInfo())
    zeppelin.getSeatScheme()
    printPassengerInfo(aircraft = zeppelin, seat = Seat(0, 'C'))}

fun printPassengerInfo(aircraft: Aircraft, seat: Seat) {
    aircraft.getPassenger(Seat(0, 'C'))       // место 0С
        ?.getInfo()                                     // если пассажир найден то вызвать getInfo()
        ?.let { println(it) }                           // если функция была вызвана (т.е. не null) - распечатаем информацию в консоль
        ?: println("there is no passenger")             // иначе (если null)
}

fun fillAircraft(aircraft: Aircraft) {
    val zeppelinPassenger = Random.nextInt(1, aircraft.capacity)
    val formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
    for (i in 0 until zeppelinPassenger) {
        val seat = aircraft.getAvailableSeat() ?: return

        val passenger = Passenger(
            name = "Ivan",
            lastName = "Petrov",
            document = getDocument(aircraft),
            seat = seat
        )
        aircraft.addPassenger(passenger)
    }
    return
}

fun getDocument(aircraft: Aircraft) : Document =
    if (aircraft is Zeppelin)
        DeputyID(
            number = Random.nextInt(100000, 999999).toString(),
            issuedDate = "01.01.1970"
        )
    else
        ForeignPassport(
            series = Random.nextInt(1000, 100_000).toString(),
            number = Random.nextInt(100_000, 1_000_000).toString()
        )

//fun getRandomDocument(): Document =
//    when (Random.nextInt(0, 2)) {
//        0 -> ForeignPassport(
//            series = Random.nextInt(1000, 100_000).toString(),
//            number = Random.nextInt(100_000, 1_000_000).toString()
//        )
//        else -> DeputyID(
//            number = Random.nextInt(100000, 999999).toString(),
//            issuedDate = "01.01.1970"
//        )
//    }