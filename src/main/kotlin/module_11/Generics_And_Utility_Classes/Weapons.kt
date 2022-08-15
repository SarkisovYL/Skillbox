package module_11.Generics_And_Utility_Classes

//    ������� ��������� ������� AbstractWeapon
object Weapons {
    //    ������� �������� ���������� ������� pistol. ������ ��������.
    fun createPistol(): AbstractWeapon {
        return object : AbstractWeapon() {
            override val maxRounds: Int = 9
            override val fireType: FireType = FireType.SingleShot
            override val ammoMagazine: Stack<Ammo> = Stack()
            override var roundsInMagazine: Boolean = false

            // �������� ������� ������������ ����
            override fun createAmmo(): Ammo = Ammo.PM9
        }
    }

    //  ������� �������� ���������� ������� rifle. ������ �������.
    fun createRifle(): AbstractWeapon {
        return object : AbstractWeapon() {
            override val maxRounds: Int = 30
            override val fireType: FireType = FireType.FiringBursts(sizeQueue = 3)
            override val ammoMagazine: Stack<Ammo> = Stack()
            override var roundsInMagazine: Boolean = false

            // �������� ������� ������������ ����
            override fun createAmmo(): Ammo = Ammo.AKM7_62
        }
    }

    //  ������� �������� ���������� ������� machineGun. ������ �������.
    fun createMachineGun(): AbstractWeapon {
        return object : AbstractWeapon() {
            override val maxRounds: Int = 75
            override val fireType: FireType = FireType.FiringBursts(5)
            override val ammoMagazine: Stack<Ammo> = Stack()
            override var roundsInMagazine: Boolean = false

            // �������� ������� ������������ ����
            override fun createAmmo(): Ammo = Ammo.RPK5_45
        }
    }

    //  ������� �������� ���������� ������� sniper. ������ ����������� ��������.
    fun createSniper(): AbstractWeapon {
        return object : AbstractWeapon() {
            override val maxRounds: Int = 10
            override val fireType: FireType = FireType.SingleShot
            override val ammoMagazine: Stack<Ammo> = Stack()
            override var roundsInMagazine: Boolean = false

            // �������� ������� ������������ ����
            override fun createAmmo(): Ammo = Ammo.SNIPER7_62
        }
    }
}