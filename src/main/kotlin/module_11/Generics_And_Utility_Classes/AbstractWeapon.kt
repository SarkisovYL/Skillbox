package module_11.Generics_And_Utility_Classes

//  Абстрактный класс оружия
abstract class AbstractWeapon {
    abstract val maxRounds : Int                // Максимальное количество патронов в магазине
    abstract val fireType: FireType             // Вид стрельбы (FireType)
    abstract val ammoMagazine: Stack<Ammo>      // Магазин патронов. При создании оружия магазин пуст
    abstract var roundsInMagazine : Boolean     // Факт наличия патронов в магазине

    abstract fun createAmmo(): Ammo             // Создание патрона необходимого типа

    // Перезарядка — создаётся новый магазин и заполняется патронами с помощью функции создания патрона
    open fun reloading(): Stack<Ammo> {
        repeat(maxRounds) {ammoMagazine.push(this.createAmmo())}
        roundsInMagazine = true
        return ammoMagazine
    }

    // Получение патронов для выстрела одиночным или очередью. Перегрузка метода,
    open fun getAmmo() {
        ammoMagazine.pop()
        roundsInMagazine = !ammoMagazine.isEmpty()
    }
    open fun getAmmo(count: Int) {
        repeat(count) {
            ammoMagazine.pop()
            roundsInMagazine = !ammoMagazine.isEmpty()
        }
    }
}