package module_06

fun main() {
    println("Введите кол-во тлф. номеров: ")
    var n: Int? = readLine()?.toIntOrNull()
    while (true) {
        if (isPositiveNumber(n)) break else println("Ошибка ввода!")
        println("Введите кол-во тлф. номеров: ")
        n = readLine()?.toIntOrNull()
    }

    println("Введите номера телефонов в международном формате:")
    var phoneList = addPhoneNumberList(n!!)         // !! – утверждение "это не null"
//    Два восклицательных знака, стоящих после nullable-значения, преобразуют его к типу без поддержки null.

    println("Фильтр номеров по условию +7")
    println(phoneList.filter {it.subSequence(0, 2) == "+7"})

    println("Вывод уникальных номеров:")
    var phoneSet: Set<String> = phoneList.toSet()
    println(phoneSet)
    println("Размер множества: ${phoneSet.size}")
    println("Сумма длин всех номеров телефонов: ${phoneList.sumOf { it.length }}")

    val phoneMap = mutableMapOf<String, String>()
    phoneSet.forEach{
        print("Введите имя человека с номером телефона $it: ")
        phoneMap[it] = readLine().toString()
    }
    println("********** Телефонный справочник: **********")
    phoneMap.forEach{println("Абонент: ${it.value}. Номер телефона: ${it.key}")}
    println("*** Телефонный справочник сортировка по номеру телефона: ***")
    phoneMap.toList().sortedBy { it.first }.toMap().
        forEach{println("Абонент: ${it.value}. Номер телефона: ${it.key}")}
    println("*** Телефонный справочник сортировка по имени: ***")
//    println(phoneMap.toList().sortedBy { it.second }.toMap())
    phoneMap.toList().sortedBy { it.second }.toMap().
        forEach{println("Абонент: ${it.value}. Номер телефона: ${it.key}")}
}

fun isPositiveNumber(n: Int?): Boolean {
    if (n != null)
        if (n > 0) return true
    return false
}

fun addPhoneNumberList(quantity: Int): List<String>{
    val phoneList: MutableList<String> = mutableListOf()
    for (i in 1..quantity) {
        print("$i. ")
        phoneList.add(readLine().toString())
    }
    return phoneList
}