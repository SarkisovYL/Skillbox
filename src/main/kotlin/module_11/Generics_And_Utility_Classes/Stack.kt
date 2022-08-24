package module_11.Generics_And_Utility_Classes

import java.util.LinkedList // ����� ������������ � ArrayDeque, ������������ �������, �� �� ������������ null �������.

//  Generic-����� Stack<T>, ������� ������ �������� �������� �������� ��������� Stack
class Stack<T>{
    private var stack = LinkedList<T>()

    //    �������� ������ � ����
    fun push(item: T) {
        stack.push(item)
    }

//    ������� ��������� ������ �� �����
    fun pop(): T? = if (stack.isEmpty()) null else stack.pop()

//    ���������� �������� � �����
    fun count(): Int = stack.count()

}