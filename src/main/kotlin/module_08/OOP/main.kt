package module_08.OOP

import kotlin.random.Random

fun main() {

    val LIFE_CYCLE = 15     // Жизненый цикл

//    Инициализируем заповедник (5 птиц, 3 рыбы, 2 собаки, 2 волка, 1 медведь)

    val wolf1 = Animal(energy = 50, weight = 30, maxAge = 20, name = "Akela")
    NatureReserve.add(wolf1)

    val wolf2 = Animal(energy = 60, weight = 20, maxAge = 20, name = "Raksha")
    NatureReserve.add(wolf2)

    val bear = Animal(energy = 100, weight = 100, maxAge = 20, name = "Ballu")
    NatureReserve.add(bear)

    val bird1 = Bird(
        energy = Random.nextInt(1, 10),
        weight = Random.nextInt(1, 5),
        maxAge = 6,
        name = "Luna"
    )
    NatureReserve.add(bird1)

    val bird2 = Bird(
        energy = Random.nextInt(1, 10),
        weight = Random.nextInt(1, 5),
        maxAge = 6,
        name = "Kesha"
    )
    NatureReserve.add(bird2)

    val bird3 = Bird(
        energy = Random.nextInt(1, 10),
        weight = Random.nextInt(1, 5),
        maxAge = 6,
        name = "Rikki"
    )
    NatureReserve.add(bird3)

    val bird4 = Bird(
        energy = Random.nextInt(1, 10),
        weight = Random.nextInt(1, 5),
        maxAge = 6,
        name = "Tikki"
    )
    NatureReserve.add(bird4)

    val bird5 = Bird(
        energy = Random.nextInt(1, 10),
        weight = Random.nextInt(1, 5),
        maxAge = 6,
        name = "Tavi"
    )
    NatureReserve.add(bird5)

    val fish1 = Fish(
        energy = Random.nextInt(1, 10),
        weight = Random.nextInt(1, 5),
        maxAge = 7,
        name = "Freddy"
    )
    NatureReserve.add(fish1)

    val fish2 = Fish(
        energy = Random.nextInt(1, 10),
        weight = Random.nextInt(1, 5),
        maxAge = 10,
        name = "Nemo"
    )
    NatureReserve.add(fish2)

    val fish3 = Fish(
        energy = Random.nextInt(1, 10),
        weight = Random.nextInt(1, 5),
        maxAge = 7,
        name = "Coral"
    )
    NatureReserve.add(fish3)

    val dog1 = Dog(
        energy = Random.nextInt(1, 10),
        weight = Random.nextInt(1, 5),
        maxAge = 15,
        name = "Cerberus"
    )
    NatureReserve.add(dog1)

    val dog2 = Dog(
        energy = Random.nextInt(1, 10),
        weight = Random.nextInt(1, 5),
        maxAge = 15,
        name = "Fluffy"
    )
    NatureReserve.add(dog2)

    // Летописец
    fun chronicler(i: Int): String {
        val units = i % 10
        val dozens = i % 100
        return if ((dozens < 11) || (dozens > 20)) {
            when (units) {
                1 -> "год"
                in 2..4 -> "года"
                else -> "лет"
            }
        } else "лет"
    }

//  Жизненый цикл заповедника

    var i = 1          // Число итераций
    while ((i <= LIFE_CYCLE) && (NatureReserve.getReserveList().size != 0)) {
        println("\n########## $i-й год ##########")
        NatureReserve.getReserveList().forEach() {
            when (Random.nextInt(0,4)) {
                0 -> it.eat()
                1 -> it.sleep()
                2 -> it.move()
                3 -> it.giveBirth()
            }
            it.info()
            if (it.currentAge >= it.maxAge) {
                NatureReserve.remove(it)
            }
        }
        i += 1
        NatureReserve.info()
    }

    // Итог
    if (NatureReserve.getReserveList().size != 0) {
        println("За жизненный цикл в $LIFE_CYCLE ${chronicler(LIFE_CYCLE)} в заповеднике:\n" +
                "Рождено - ${NatureReserve.getBirthList().size} животных.\n" +
                "Погибло - ${NatureReserve.getDeadList().size} животных.\n" +
                "Живут - ${NatureReserve.getReserveList().size} животных.")
    }
}