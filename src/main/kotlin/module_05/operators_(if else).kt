package module_05

// Ќайти максимальное число из двух заданных

fun main() {
    val a: Int = readLine()?.toIntOrNull() ?: return
    val b: Int = readLine()?.toIntOrNull() ?: return
    val c: Int = readLine()?.toIntOrNull() ?: return

    val x = sEquation(a, b, c)
    if (x == null)
        println("No solutions")
    else
        println(x)
}

fun sEquation(a: Int, b: Int, c: Int): Double? {
    if (a == 0) return null
    return (c - b) / a.toDouble()
}

fun max(a: Int, b: Int): Int = if (a > b) a else b

fun printIfPositive(n: Int) {
    if (n > 0)
        println(n)

    println(n + 1000)
}