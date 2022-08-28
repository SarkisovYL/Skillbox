package module_12.Generics_And_Utility_Classes_Throwable

// Перечисление (enum) Ammo для видов патронов. Реализация интерфейса Damage.
// Типы патронов - 9 мм ПМ; 7,62 AKM; 5,45 РПК; 7,62 Снайперка.

enum class Ammo(): Damage {
    PM9{
        override val loss = 25
        override val chance = 50
        override val coefficient = 2
         },
    AKM7_62{
        override val loss = 50
        override val chance = 70
        override val coefficient = 2
    },
    RPK5_45{
        override val loss = 75
        override val chance = 90
        override val coefficient = 2
    },
    SNIPER7_62{
        override val loss = 100
        override val chance = 100
        override val coefficient = 2
    },
}