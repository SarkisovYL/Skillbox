package module_07

class Car_dop_constructor(val brand: String, val model: String, val color: String = "White") {

//    ƒополнительный конструктов вызывает основной консоруктов через слово this с передачей аргументов
    constructor(discriptor: Pair<String, String>, color: String): this (
        brand = discriptor.first,
        model = discriptor.second,
        color = color
    )
//    “ело дополнительных конструкторов описываетс€ в фигурных скобках так же как и тело основног конструктора
    {
        println("Body secondary constructor")
    }
//  онструкторы - это функции, но объ€вить в конструкторе тело можно использу€ блоки init.
// ¬ них размещают код, который должен выполнитьс€ в конструкторе при создании инстанса.
// ¬ыполнение блоков идет по пор€дку в коде и до кода в теле конструктора.
    init {
        println("Car init 1")
    }

    init {
        println("Car init 2")
    }
}
