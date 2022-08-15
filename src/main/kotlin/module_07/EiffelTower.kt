package module_07

object EiffelTower {
    private var backlightsOn = false    // Подсветка (on/off)
    val height = 324                    // Высота

    fun turnOnBacklights() {
        println("backlights on")
        backlightsOn = true
    }

    fun turnOffBacklights() {
        println("backlights off")
        backlightsOn = false
    }
}