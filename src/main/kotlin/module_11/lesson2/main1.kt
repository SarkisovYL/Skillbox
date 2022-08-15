package module_11.lesson2

import module_08.Developer
import module_08.Person

fun main() {
    val developer = Developer("Tony", 40)
    developer.writeCode()
    developer.getlevel()

    val person: Person = developer
//    person.writeCode()  // метод недоступен
//    person.getlevel()   // метод недоступен
}