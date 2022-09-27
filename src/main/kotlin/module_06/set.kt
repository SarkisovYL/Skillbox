package module_06

import java.util.TreeSet

fun main() {
//    TODO МНОЖЕСТВА (список с уникальными значениями)
    val set = setOf(1, 2, 2, 3, 1, 2)                       // Возвращает неизменяемое множество
    val mset = mutableSetOf(1, 2, 3, 3, 2, 10)

//    Все остальные ниже возвращают изменяемое множество
    val hashSet = hashSetOf(1, 2, 3, 3, 2, 1)
    val soredSet = sortedSetOf(1, 2, 3, 3, 2, 1).toSet()    // Функция toSet изменяемое множество в неизменяемое
    val mSet = mutableSetOf(1, 2, 3, 4, 3, 2, 1)
    val likedSet = linkedSetOf(1, 2, 3, 3, 2, 1)
    mSet.add(7)

    val hashSet2 = HashSet<String>()
    val soredSet2 = TreeSet<String>()
    val likedSet2 = LinkedHashSet<String>()
//    Действия с множествами
    val firstSet = setOf(1, 2, 3, 4)
    val secondSet = setOf(3, 4, 5, 6)
    println("firstSet - $firstSet")
    println("secondSet - $secondSet")
//    Сложение множеств
    val unionSet = firstSet.union(secondSet)
    println("unionSet - $unionSet")
//    Вычитание множеств
    val substractSet12 = firstSet.subtract(secondSet)
    println("substractSet (1-2) - $substractSet12")
    val substractSet21 = secondSet.subtract(firstSet)
    println("substractSet (2-1) - $substractSet21")
//    Пересечение множеств
    val intersetSet = firstSet.intersect(secondSet)
    println("intersetSet - $intersetSet")
}
