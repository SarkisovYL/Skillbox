package module_12.Generics_And_Utility_Classes_Throwable

//  Синглтон-объект Weapons, который создаёт разные виды оружия.
//  Объект Weapons должен создавать анонимные объекты AbstractWeapon.
//  Создадим четыре метода для разных видов оружия (пистолет, автомат, пулемет, снайперская винтовка).
//  анонимные объекты AbstractWeapon
object Weapons {
    //    Функция создания анонимного объекта pistol. Оружие пистолет.
    fun createPistol(): AbstractWeapon {
        return object : AbstractWeapon() {
            override val maxRounds: Int = 9
            override val fireType: FireType = FireType.SingleShot
            override val ammoMagazine: Stack<Ammo> = Stack()
            override var roundsInMagazine: Boolean = false
            override var name: String = "Пистолет"

            // Создание патрона необходимого типа
            override fun createAmmo(): Ammo = Ammo.PM9
        }
    }

    //  Функция создания анонимного объекта rifle. Оружие автомат.
    fun createRifle(): AbstractWeapon {
        return object : AbstractWeapon() {
            override val maxRounds: Int = 30
            override val fireType: FireType = FireType.FiringBursts(sizeQueue = 3)
            override val ammoMagazine: Stack<Ammo> = Stack()
            override var roundsInMagazine: Boolean = false
            override var name: String = "Автомат"
            // Создание патрона необходимого типа
            override fun createAmmo(): Ammo = Ammo.AKM7_62
        }
    }

    //  Функция создания анонимного объекта machineGun. Оружие пулемет.
    fun createMachineGun(): AbstractWeapon {
        return object : AbstractWeapon() {
            override val maxRounds: Int = 75
            override val fireType: FireType = FireType.FiringBursts(5)
            override val ammoMagazine: Stack<Ammo> = Stack()
            override var roundsInMagazine: Boolean = false
            override var name: String = "Пулемет"
            // Создание патрона необходимого типа
            override fun createAmmo(): Ammo = Ammo.RPK5_45
        }
    }

    //  Функция создания анонимного объекта sniper. Оружие снайперская винтовка.
    fun createSniper(): AbstractWeapon {
        return object : AbstractWeapon() {
            override val maxRounds: Int = 10
            override val fireType: FireType = FireType.SingleShot
            override val ammoMagazine: Stack<Ammo> = Stack()
            override var roundsInMagazine: Boolean = false
            override var name: String = "Снайперская винтовка"
            // Создание патрона необходимого типа
            override fun createAmmo(): Ammo = Ammo.SNIPER7_62
        }
    }
}