package module_11.Generics_And_Utility_Classes

import module_11.lesson5.random

// ������������ (enum) Ammo ��� ����� ��������. ���������� ���������� Damage.
// ���� �������� - 9 �� ��; 7,62 AKM; 5,45 ���; 7,62 ���������.

enum class Ammo(): Damage {
    PM9{
        override val loss = 25
        override val chance = 50
        override val coefficient = 1
         },
    AKM7_62{
        override val loss = 50
        override val chance = 70
        override val coefficient = 1
    },
    RPK5_45{
        override val loss = 75
        override val chance = 90
        override val coefficient = 1
    },
    SNIPER7_62{
        override val loss = 100
        override val chance = 100
        override val coefficient = 1
    };
}