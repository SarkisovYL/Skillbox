package module_08

fun main() {
    val person = Person("Alex", 25)
    val driver = Driver("Ivan", 46, 2)

    person.age
    person.eat()
    person.sleep()
    person.walk()

    driver.age
    driver.eat()
    driver.sleep()
    driver.walk()
    driver.experience = 0
    driver.drive()

    val ktDev = KotlinDeveloper(name = "Alex", age = 25)
    val javaDev = JavaDeveloper(name = "Ivan", age = 40, experience = 20)
    val cppDev = CppDeveloper(name = "Anna", age = 30, experience = 7)
    val developer = Developer(name = "MegaMozg", age = 100, experience = 100)
    val scaleDev = ScalaDeveloper(name = "ScalaDeveloper", age = 30, experience = 5)

            ktDev.writeCode()
    println("${ktDev.name} level - ${ktDev.getlevel()}")
//    println("${ktDev.name} experience - ${ktDev.experience}")

    javaDev.writeCode()
    println("${javaDev.name} level - ${javaDev.getlevel()}")
//    println("${javaDev.name} experience - ${javaDev.experience}")

    cppDev.writeCode()
    println("${cppDev.name} level - ${cppDev.getlevel()}")
//    println("${cppDev.name} experience - ${cppDev.experience}")

    developer.writeCode()
    println("${developer.name} level - ${developer.getlevel()}")
//    println("${developer.name} experience - ${developer.experience}")

    println("${javaDev.name} paradigm - ${javaDev.paradigm}")
    println("${scaleDev.name} paradigm - ${scaleDev.paradigm}")

}