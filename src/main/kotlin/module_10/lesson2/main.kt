package module_10.lesson2

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random

fun main() {
    val train = Train(maxWeight = 1000)
    println("capacity - ${train.capacity}")
    train.move()

    println("============ САМОЛЕТ ============")
    val boeing737 = createAndFillBoeing()
    println(boeing737.getInfo())
    boeing737.getSeatScheme()
/*  Группировка цепочки вызовов
    При группировке цепочки вызовов, расположите символ . или оператор ?. на следующей строке с обычным отступом. */
    boeing737.getPassenger(Seat(0, 'C'))     // место 0С
        ?.getInfo()                                     // если пассажир найден то вызвать getInfo()
        ?.let { println(it) }                           // если функция была вызвана (т.е. не null) - распечатаем информацию в консоль
        ?: println("there is no passenger")             // иначе (если null)

    println("=========== ДИРЕЖАБЛЬ ===========")
    val zeppelin = createAndFillZeppelin()
    println(zeppelin.getInfo())
    zeppelin.getSeatScheme()
    zeppelin.getPassenger(Seat(0, 'C'))     // место 0С
        ?.getInfo()                                     // если пассажир найден то вызвать getInfo()
        ?.let { println(it) }                           // если функция была вызвана (т.е. не null) - распечатаем информацию в консоль
        ?: println("there is no passenger")             // иначе (если null)
}

fun createAndFillBoeing() : Boeing737 {
    val boeing737 = Boeing737()
    val passengersCount = Random.nextInt(1, boeing737.capacity)
    for (i in 0 until passengersCount) {
        val seat = boeing737.getAvailableSeat() ?: return boeing737

        val passenger = Passenger(
            name = "Ivan",
            lastName = "Petrov",
            document = ForeignPassport(
                series = Random.nextInt(1000, 9000).toString(),
                number = Random.nextInt(100000, 999999).toString()
            ),
            seat = seat
        )
        boeing737.addPassenger(passenger)
    }
    return boeing737
}

fun createAndFillZeppelin() : Zeppelin {
    val zeppelin = Zeppelin()
    val zeppelinPassenger = Random.nextInt(1, zeppelin.capacity)
    val formatter = DateTimeFormatter.ofPattern("dd-MMMM-yyyy")
    for (i in 0 until zeppelinPassenger) {
        val seat = zeppelin.getAvailableSeat() ?: return zeppelin

        val passenger = Passenger(
            name = "Ivan",
            lastName = "Petrov",
            document = DeputyID(
                number = Random.nextInt(100000, 999999).toString(),
                issuedDate = LocalDateTime.now().format(formatter).toString()
            ),
            seat = seat
        )
        zeppelin.addPassenger(passenger)
    }
    return zeppelin
}