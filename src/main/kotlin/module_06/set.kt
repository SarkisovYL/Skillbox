package module_06

import java.util.TreeSet

fun main() {
//    TODO ��������� (������ � ����������� ����������)
    val set = setOf(1, 2, 2, 3, 1, 2)                       // ���������� ������������ ���������
    val mset = mutableSetOf(1, 2, 3, 3, 2, 10)

//    ��� ��������� ���� ���������� ���������� ���������
    val hashSet = hashSetOf(1, 2, 3, 3, 2, 1)
    val soredSet = sortedSetOf(1, 2, 3, 3, 2, 1).toSet()    // ������� toSet ���������� ��������� � ������������
    val mSet = mutableSetOf(1, 2, 3, 4, 3, 2, 1)
    val likedSet = linkedSetOf(1, 2, 3, 3, 2, 1)
    mSet.add(7)

    val hashSet2 = HashSet<String>()
    val soredSet2 = TreeSet<String>()
    val likedSet2 = LinkedHashSet<String>()
//    �������� � �����������
    val firstSet = setOf(1, 2, 3, 4)
    val secondSet = setOf(3, 4, 5, 6)
    println("firstSet - $firstSet")
    println("secondSet - $secondSet")
//    �������� ��������
    val unionSet = firstSet.union(secondSet)
    println("unionSet - $unionSet")
//    ��������� ��������
    val substractSet12 = firstSet.subtract(secondSet)
    println("substractSet (1-2) - $substractSet12")
    val substractSet21 = secondSet.subtract(firstSet)
    println("substractSet (2-1) - $substractSet21")
//    ����������� ��������
    val intersetSet = firstSet.intersect(secondSet)
    println("intersetSet - $intersetSet")
}
