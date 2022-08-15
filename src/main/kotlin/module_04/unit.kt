package module_04

fun main() {
/* TODO
    Такой тип описывает функцию которая принимает три аргумента типа Int, Double, Int
    и возвращает Double. Именно такую сигнатуру имеет наша функция calculateSavingsAmount
    из прошлого урока (functions.kt)
 */
    val type: (Int, Double, Int) -> Double

/* TODO
    Переменной ananimus присвоено анонимная функция которая выводит в консоль переданное число.
    Если на нее навести курсор, то видно, что она принимает Int, но не имеет возвращаемого значения.
 */
    val ananimus: (Int) -> Unit = fun(a: Int) { println(a) }
    ananimus(123)

/* TODO
    Лямбда-выражение — это анонимная функция, записанная в виде выражения.
    Имеет следующий синтаксис:
    1. Выражение всегда заключено в фигурные скобки
    2. До стрелки -> могут находятся параметры (message: String), которые передаются в функцию
    а справа после стрелки - находится тело самой функции (println(message))
    3. Синтаксис ламбда выражений не предусматривает указание возвращаемого типа.
    Но если навести курсор на переменную, то можно увидеть возвращаемый тип.
    4. В отличии от функций В ЛАМБДА ВЫРАЖЕНИЯХ НЕ ИСПОЛЬЗУЕТСЯ ОПЕРАТОР RETURN для возврата значений.
 */
    var lambda = { println("Hello world!") }
    var lambdaWithParams = { message: String -> println(message) }
    var lambdaWithParamsandReturnValue = {a: Int, b: Int -> a * b}

    print( "ЗАДАЧА 1.\nНайти сколько раз в строке встречается символ 'e'." +
        "\nРешим задачу с помощь ламбда выражений и функции count типа string.\n")
    val str: String = "This is a typical task for developer interview"
    println(str.count{it == 'e'})       // it - специальный аргуменет для передачи значения char

/*  TODO
     Когда у лямбды один аргумент - то его можно не передавать явно, а использовать ключевое слово it
     println(str.count{char -> checkSymbol(char)}) будет таким println(str.count{checkSymbol(it)})
     it - это аргумент который функция count будет передавать в нашу функцию checkSymbol
     можно напрямую передать наш аргумент println(str.count{it == 'e'})
 */

    print( "ЗАДАЧА 2.\nВырезать из строки все гласные буквы.\n" )
    val vowels = "aeoiu"
    println(str.filter { it !in vowels })   // !in - не входит в ...

    print( "ЗАДАЧА 3.\nСделать функцию calculateSavingsAmount из functions.kt, как функцию \n" +
            "как функцию высшего порядка, т.е. она может принимать в качесте аргумента другую функцию \n" +
            "или лямбда выражения.\n" )
    val first = calculateSavingsAmount(30000, 0.12, 8) { _, _, _, bank ->
        println("First member's bank: $bank")
    }
    val second = calculateSavingsAmount(50000, 0.2, 8) {_, _, _, bank ->
        println("Second member's bank: $bank")
    }
    println(first + second)

    val third = calculateSavingsAmount(50000, 0.3, 12) {salary, rate, period, bank ->
        println("Salary: $salary rate: ${rate *100}%, period: $period month, bank: $bank ")
    }
//  Замена всех символов строки на соседний символ, справа от текущего (сдвиг всех символов вправо на 1).
    val sourceString: String = "ABCDEFGHIJKLMNOP_123456789"
    val shiftedString = sourceString.map {char -> char + 1}.joinToString("")
    println(shiftedString)
}

fun calculateSavingsAmount(
    salary: Int,
    rate: Double = 0.3,
    perion: Int = 12,
    printInfo: ((salary: Int, rate: Double, perion: Int, bank: Double) -> Unit)? = null) : Double {
    val netSalary = salary * 0.87
    val bank = netSalary * rate * perion
    printInfo?.invoke(salary, rate, perion, bank)
    return bank
}