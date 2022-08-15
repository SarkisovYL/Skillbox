package module_05

fun main() {
//    ‘ункци€ toIntOrNull провер€ет есть ли возможность преобразовать строку в число
//    если нет возможности то возвращаетс€ Null
    println("Enter a")
    val a: Int = readLine()?.toIntOrNull() ?: return
    println("Enter b")
    val b: Int = readLine()?.toIntOrNull() ?: return
    println("Enter c")
    val c: Int = readLine()?.toIntOrNull() ?: return

    val x = solveEquation(a, b, c)
    if (x == null)
        println("Ќет решени€")
    else
        println(x)
}

fun solveEquation(a: Int, b: Int, c: Int): Double? {
    if (a == 0) return null
    return (c - b) /a.toDouble()
}
