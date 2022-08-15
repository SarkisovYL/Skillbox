package module_11.lesson4

import module_08.Person

class Printer<in T: Person> {
    fun print(person : T) {
        println("Person ${person.name}")
    }
}