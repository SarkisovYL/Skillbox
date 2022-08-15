package module_07

// ќпишем объект Ёйфелева башн€. —оздадим object-файл.
fun main() {
    println("Height - ${EiffelTower.height}")
    EiffelTower.turnOnBacklights()
    EiffelTower.turnOffBacklights()

//  COMPANION OBJECT
//    ќбращатьс€ к членам COMPANION OBJECT можно только через класс, а не через экземпл€р класса

    println("Weels count - ${CarCompanioObject.wheelsCount}")
    val classType = CarCompanioObject.getCarClass(3.8f)
    println(classType)

    val auto5 = CarCompanioObject("VAZ" to "Niva", "Brawn")
//    auto5.getCarClass - не доступен
//    auto5.wheelsCount - не доступен
}