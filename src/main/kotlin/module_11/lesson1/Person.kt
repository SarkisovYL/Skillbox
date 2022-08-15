package module_11.lesson1

class Person (
    val name: String,
    val lastname: String,
    val passportSeries: Int,
    val passportNumber: Int
) {
    //  Ниже результат генерации. Стать на Person + alt-insert -> equals() and  hashCode()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true                 // если объекты одинаковые - то вернуть true и выйти
        if (javaClass != other?.javaClass) return false // проверка, что объекты принадлежат одному классу

        other as Person                                 // операция приведения

        if (passportSeries != other.passportSeries) return false    // проверка значений полей
        if (passportNumber != other.passportNumber) return false    // проверка значений полей

        return true
    }

    override fun hashCode(): Int {
        var result = passportSeries
        result = 31 * result + passportNumber
        return result
    }

    //  Ниже результат генерации. Стать на Person + alt-insert -> toString()
    override fun toString(): String {
        return "Person(name='$name', lastname='$lastname', passportSeries=$passportSeries, passportNumber=$passportNumber)"
    }
}