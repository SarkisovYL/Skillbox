package module_11.Generics_And_Utility_Classes

import java.util.LinkedList // Можно использовать и ArrayDeque, отрабатывает быстрее, но не поддерживает null объекты.

//  Generic-класс Stack<T>, который хранит элементы согласно правилам коллекции Stack
class Stack<T>{
    private var stack = LinkedList<T>()
        get() = field
        set(value) {
            field = value
        }

//    Добавить объект в стек
    fun push(item: T) {
        stack.push(item)
    }

//    Извлечь последний объект из стека
    fun pop(): T? = if (stack.isNullOrEmpty()) null else stack.pop()

//    Проверить на наличие объектов в стеке
    fun isEmpty(): Boolean = stack.isNullOrEmpty()

//    Количество патронов в магазине
    fun count(): Int = stack.count()

}