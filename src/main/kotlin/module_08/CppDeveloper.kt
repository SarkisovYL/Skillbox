package module_08

class CppDeveloper : Developer {
    constructor(name: String, age: Int) : super(name, age)
    constructor(name: String, age: Int, experience: Int) : super(name, age, experience)

    override fun writeCode() {
        super.writeCode()
        println("c++ code")
    }

    override fun getlevel(): String = when(experience) {
        0 -> "intern"
        in 1..3 -> "junior"
        in 4..6 -> "middle"
        in 6..8 -> "senior"
        else -> "leading"
    }
}