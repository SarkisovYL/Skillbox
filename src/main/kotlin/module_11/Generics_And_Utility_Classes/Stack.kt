package module_11.Generics_And_Utility_Classes

import java.util.LinkedList // ����� ������������ � ArrayDeque, ������������ �������, �� �� ������������ null �������.

//  Generic-����� Stack<T>, ������� ������ �������� �������� �������� ��������� Stack
class Stack<T>{
    private var stack = LinkedList<T>()
        get() = field
        set(value) {
            field = value
        }

//    �������� ������ � ����
    fun push(item: T) {
        stack.push(item)
    }

//    ������� ��������� ������ �� �����
    fun pop(): T? = if (stack.isNullOrEmpty()) null else stack.pop()

//    ��������� �� ������� �������� � �����
    fun isEmpty(): Boolean = stack.isNullOrEmpty()

//    ���������� �������� � ��������
    fun count(): Int = stack.count()

}