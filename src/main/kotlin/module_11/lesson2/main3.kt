package module_11.lesson2

import module_08.Developer
import module_08.Person

fun main() {
    val person: Person = Person("Tony", 40)
    val developer: Developer? = person as? Developer
    developer?.writeCode()
    println(developer?.getlevel())
}