package module_11.lesson3

fun main() {
    val person = Person("name", "lastname")

//    Деструктурирующее присваивание.
    val (name, lastname) = person   // объявлены отдельно переменные name и lastname
    println(name)
    println(lastname)
//    Запись деструктурирующего присваивания компилятором будем представлена в следующем виде
//    component1() генерируется автоматически для полей представленных в конструкторе класса по их порядку.
    val name1 = person.component1()
    val lastname1 = person.component2()
    println(name1)
    println(lastname1)
}