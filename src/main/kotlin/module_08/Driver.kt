package module_08

class Driver(
    nameArg: String,
    ageArg: Int,
    var experience: Int
) : Person(nameArg, ageArg) {
    fun drive() = println("driving")
}