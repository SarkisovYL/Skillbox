package module_04

fun main() {
    val juniorGrassSalary = 50_000
    val middleGrassSalary = 134_000
    val seniorGrassSalary = 167_000
    calculateSavings(salary = juniorGrassSalary, perion = 6)
    calculateSavings(salary = middleGrassSalary, rate = 0.5, perion = 3)
    calculateSavings(salary = seniorGrassSalary, rate = 0.8)

    val sum = calculateSavingsAmount(salary = middleGrassSalary, rate = 0.5, perion = 3) +
            calculateSavingsAmount(salary = seniorGrassSalary, rate = 0.5, perion = 3)
    println(sum)
}

fun calculateSavings(salary: Int, rate: Double = 0.3, perion: Int = 12) {
    val netSalary = salary * 0.87
    val bank = netSalary * rate * perion
    println("Salary: $salary, rate: ${rate * 100}%, period: $perion months, $bank in 1 year")
}

fun calculateSavingsAmount(salary: Int, rate: Double = 0.3, perion: Int = 12) : Double {
    val netSalary = salary * 0.87
    val bank = netSalary * rate * perion
    return bank
}
