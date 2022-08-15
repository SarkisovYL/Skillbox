package module_11.Generics_And_Utility_Classes

import kotlin.random.Random

fun main() {
//    val st = Stack<Int?>()
//    st.push(1)
//    println(st.isEmpty())
//    st.pop()
//    println(st.isEmpty())
//    st.pop()
//    println(st.isEmpty())
//    st.push(null)
//    println(st.isEmpty())

//    val pm9 = Ammo.PM9
//    val akm = Ammo.AKM7_62
//    val rpk = Ammo.RPK5_45
//    val snpr = Ammo.SNIPER7_62
//    println("Текущий урон ПМ 9 - ${pm9.get()}")
//    println("Текущий урон АКМ 7,62 - ${akm.get()}")
//    println("Текущий урон РПК 5,45 - ${rpk.get()}")
//    println("Текущий урон Снайпер - ${snpr.get()}")

//    val play1_pistol: AbstractWeapon = Weapons.createPistol()
//    val play2_pistol: AbstractWeapon = Weapons.createPistol()
//    println("IsEmpty игрок 1 - ${play1_pistol.ammoMagazine.isEmpty()}")
//    println("Патроны в магазине игрок 1 - ${play1_pistol.roundsInMagazine}")
//    play1_pistol.reloading()
//    play2_pistol.reloading()
//    println("IsEmpty игрок 1 - ${play1_pistol.ammoMagazine.isEmpty()}")
//    println("Патроны в магазине игрок 1 - ${play1_pistol.roundsInMagazine}")
//    repeat(5) {play1_pistol.getAmmo()}
//    repeat(3) {play2_pistol.getAmmo(3)}
//    println("IsEmpty игрок 1 - ${play1_pistol.ammoMagazine.isEmpty()}")
//    println("Патроны в магазине игрок 1 - ${play1_pistol.roundsInMagazine}")
//    println("IsEmpty игрок 2 - ${play2_pistol.ammoMagazine.isEmpty()}")
//    println("Патроны в магазине игрок 2 - ${play2_pistol.roundsInMagazine}")

    // Начало битвы
    val battle = Battle(Team("Белые", 9), Team("Красные", 12),false)
    battle.firstTeam.info()
    battle.secondTeam.info()
    battle.firstTeam.getWarriorRandom().setLoss(100000)
    battle.firstTeam.info()
}

//    Функция-расширение для типа Int. Реализация через класс компаньон
fun Int.Companion.random(chance: Int): Boolean {
    return Random.nextInt(100) <= chance    // Реализован шанс ?
}
