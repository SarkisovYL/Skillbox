package module_08

class KotlinDeveloper: Developer {
    constructor(name: String, age: Int) : super(name, age)
    constructor(name: String, age: Int, experience: Int) : super(name, age, experience)

    override fun writeCode() {
        println("kt developer writing kt code")
        super.getCoffeeBreak()
    }

    override fun getCoffeeBreak() = true
}
