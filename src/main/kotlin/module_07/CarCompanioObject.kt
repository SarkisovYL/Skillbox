package module_07

class CarCompanioObject(val brand: String, val model: String, val color: String = "White") {

    //    Дополнительный конструктов вызывает основной консоруктов через слово this с передачей аргументов
    constructor(discriptor: Pair<String, String>, color: String): this (
        brand = discriptor.first,
        model = discriptor.second,
        color = color
    )
//    Тело дополнительных конструкторов описывается в фигурных скобках так же как и тело основног конструктора
    {
        println("Body secondary constructor")
    }
    // Конструкторы - это функции, но объявить в конструкторе тело можно используя блоки init.
// В них размещают код, который должен выполниться в конструкторе при создании инстанса.
// Выполнение блоков идет по порядку в коде и до кода в теле конструктора.
    init {
        println("Car init 1")
    }

    //    Модификатор доступа privet означает доступность только внутри класса.
//    Для чтения и записи в переменную используются геттеры и сеттеры, после переменной.
//    Получение и запись значений проходит с использованием специального слова field
    var fuelCount = 0.0f
        get() {
            println("fuelCount getter")
            return field
        }
        set(value) {
            println("\"fuelCount setter")
            field = value
        }
    //  Сделаем геттер privet а сеттер private
//  т.к. дополнительные действия в сеттере нам не нужны - то тело функции можно удалить
//    ГЕТТЕРЫ И СЕТТЕРЫ БЕЗ ТЕЛА ПРОСТО УСТАНАВЛЯВАЮТ ИЛИ ВОЗВРАЩАЮТ ЗНАЧЕНИЯ
    var currentSpeed = 0.0f
        get     // В среде разработки их можно и не указывать, о чем нам говорит подчеркивание get
        // (геттер избытачен и его можно удалить)
        private set

    init {
        println("Car init 2")
    }

//    ПОЛЕ currentSpeed У НАС PUBLIC, НО У ПОЛЯ ЕСТЬ ПРИВАТНЫЙ СЕТТЕР, Т.Е. СЧИТАТЬ ЗНАЧЕНИЕ ИЗ КОДА МОЖНО,
//    А ЗАПИСАТЬ ЗНАЧЕНИЕ НЕТ (ТОЛЬКО В КЛАССЕ)
//    ЕСЛИ ПОЛЕ PUBLIC - ТО СЕТТЕРЫ + ГЕТТЕР НЕ МОГУТ БЫТЬ PRIVATE

//    УКАЗЫВАТЬ ЯВНО СЕТТЕРЫ И ГЕТТЕРЫ ДЛЯ ПОЛЯ НЕ НУЖНО,
//    КРОМЕ СЛУЧАЕВ КОГДА НЕОБХОДИМО ДОБАВИТЬ КАКИЕ-ЛИБО ДОПОЛНИТЕЛЬНЫЕ ДЕЙСТВИЯ

    fun accelerate(speed: Float){
        val needFuel = speed * 0.12f
        if (this.fuelCount > needFuel) {
            this.currentSpeed += speed
            useFuel(needFuel)
        }
        else
            println("Car is not enough fuel")
    }

    fun decelerate(speed: Float) {
////        Можно описать так:
//        var finalspeed = currentSpeed - speed
//        currentSpeed = if (finalspeed < 0) 0.0f
//        else finalspeed
//        но лучше воспользоваться функцией maxOf , которая возвращает наибольшее из двух чисел
        currentSpeed = maxOf(0.0f, currentSpeed - speed)
    }

    private fun useFuel(fuelCount: Float) {
        this.fuelCount -= fuelCount
    }

//  COMPANION OBJECT
//    Обращаться к членам COMPANION OBJECT можно только через класс, а не через экземпляр класса

    companion object {
        const val wheelsCount = 4
        fun getCarClass(length: Float): String = when {
            length < 3.6 -> "A"
            length < 3.9 -> "B"
            length < 4.3 -> "C"
            length < 4.6 -> "D"
            length < 5 -> "E"
            else -> "F"
        }
    }
}