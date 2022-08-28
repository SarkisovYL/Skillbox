package module_12.Generics_And_Utility_Classes_Throwable

import java.util.LinkedList // Можно использовать и ArrayDeque, отрабатывает быстрее, но не поддерживает null объекты.

//  Generic-класс Stack<T>, который хранит элементы согласно правилам коллекции Stack
class Stack<T>{
    private var stack = LinkedList<T>()

    //    Добавить объект в стек
    fun push(item: T) {
        stack.push(item)
    }

//    Извлечь последний объект из стека
    fun pop(): T? = if (stack.isEmpty()) null else stack.pop()

//    Количество объектов в стеке
    fun count(): Int = stack.count()

}