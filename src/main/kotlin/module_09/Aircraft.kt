package module_09

abstract class Aircraft(maxWeightArg: Int): Transporter(maxWeightArg) {
    abstract val brand: String              // марка
    abstract val model: String              // модель
    abstract val engineCount: Int           // кол-во двигателей
    abstract val altitude: Int              // высота полета
    abstract val rows: Int                  // кол-во рядов
    abstract val numberOnSeatsInARow: Int   // число кресел в ряду

//  TODO С помощью функции lazy, мы откладываем инициализацию поля,
//   значение будет присвоено в момент первого обращения к этому полю.
//   Как только к нему обращаемся в первый раз происходит выполнение кода в теле {}
    protected val seatScheme by lazy{
        List(rows) {
            MutableList<Passenger?>(numberOnSeatsInARow) {
                null
            }
        }
    }

    // Добавить пассажира
    fun addPassenger(passenger: Passenger) {
        val row = passenger.seat.row
        // Вычитаем, чтобы получить номер символа в массиве от 0 (A) и делее.
        val number = passenger.seat.letter - 'A'
        //  Поместим нашего пассажира в двумерную матрицу
        seatScheme[row][number] = passenger
    }

    //  Получить пассажира
    fun getPassenger(seat: Seat) : Passenger? {
        val row = seat.row
        val number = seat.letter - 'A'
        return seatScheme[row][number]
    }

    //  Вывести в консоль схему рассадки пассажиров
    abstract fun getSeatScheme()

    //  Вывести информацию
    //  TODO Чтобы сохранить отступ в многострочных строках, используйте trimIndent, когда результирующая строка
    //   не требует внутреннего отступа, и trimMargin, когда требуется внутренний отступ.
    fun getInfo() =
        """Aircraft: $brand $model
            |Max Weight: $maxWeight
            |Capacity: $capacity
            |Number of rows: $rows
            |Number of seat in a row: $numberOnSeatsInARow
        """.trimMargin()

    //  Функция перелета
    override fun move() {
        println("Aircraft flying")
    }

    // Проверка свободных мест и возврат результата
    fun getAvailableSeat(): Seat? {
        val availableSeat = mutableListOf<Seat>()
        seatScheme.forEachIndexed { rowIndex, row ->
            row.forEachIndexed { seatIndex, passenger ->
                if (passenger == null)
                    availableSeat.add(Seat(rowIndex, 'A' + seatIndex))
            }
        }
        availableSeat.forEach() {
            println("Ряд ${it.row} Место ${it.letter}")
        }
    // Вернуть свободное случайное место
    return availableSeat.randomOrNull()
    }
}