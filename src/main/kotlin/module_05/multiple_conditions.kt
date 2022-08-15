package module_05

// Создать программу которая определяет уровень программиста, основываясь на его опыта.
// Если опыта нет - то intern если от 1 до 3 лет то junier и т.д.
// Функция getDeveloperPosition имеет не оптимальный код. Если навести мышь на подчеркнутые выражения
// и нажать alt-enter, то среда предложит оптимизировать запись:
// Функция getDeveloperPositionOptimal - написана с использованием современных правил Kotlin

fun main() {
    println("Enter experience")
    val experience: Int = readLine()?.toIntOrNull() ?: return
    println("Your a status ${getDeveloperPosition(experience)}")
    println("Your a status ${getDeveloperPositionOptimal(experience)}")
    println(getUserAccess(false, "Admin"))
}

fun getDeveloperPosition(experience: Int): String {
    if (experience == 0) return "intern"
    else if (experience >= 1 && experience < 3) return "junier"
    else if (experience >= 3 && experience < 5) return "middle"
    else if (experience >= 4 && experience < 6) return "senior"
    else return "leading"
}

fun getDeveloperPositionOptimal(experience: Int): String {
    // Используется оператор when с субъектом. Т.е. мы проверяем субъект experience на соответствие условиям.
    when (experience) {
        0 -> return "intern"    // 0 - условтие, return "intern" - блок кода который нужно выполнить
        in 1..2 -> return "junier"
        in 3..4 -> return "middle"
        in 4..5 -> return "senior"
        else -> return "leading"
    }
}

fun getUserAccess(isAuthorized: Boolean, role: String): String {
    return when {
        !isAuthorized -> "Restricted"
        role == "Admin" -> "Full"
        role == "Moderator" -> "Limited"
        else -> "Common"
    }
}
