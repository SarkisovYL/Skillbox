package module_08.OOP

object NatureReserve {
    private var reserveList = mutableListOf <Animal>()  // Текущий список животных
    private var birthList = mutableListOf <Animal>()    // Список рожденных животных
    private var deadList = mutableListOf <Animal>()     // Список погибших животных

    // Добавить животное в лист рожденных
    fun add(animal: Animal) {
        birthList.add(animal)
    }

    // Добавить животное в лист погибших
    fun remove(animal: Animal) {
        deadList.add(animal)
    }

    // Получить текущий список животных
    fun getReserveList(): MutableList<Animal> {
        reserveList = birthList.filter { it !in deadList } as MutableList<Animal>
        return reserveList
    }

    // Получить список рожденных животных
    fun getBirthList(): MutableList<Animal> {
        return birthList
    }

    // Получить список умерших животных
    fun getDeadList(): MutableList<Animal> {
        return deadList
    }

    // Информация о животных заповедника
    fun info() {
        this.getReserveList()
        if (reserveList.size > 0) {
            println("В заповеднике находятся:")
            reserveList.forEachIndexed { index, item ->  println("${index + 1}: ${item::class.simpleName}. " +
                    "Имя: ${item.name}. Вес: ${item.weight}. Энергия: ${item.energy}. " +
                    "Возраст: ${item.currentAge}, Максимальный возраст: ${item.maxAge}.")}
        }
        else
        {
            println("В зоопарке животных нет.")
        }
    }
}