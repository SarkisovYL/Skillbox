package module_11.lesson4

import java.util.*

class GenericNumber<T : Number>(value: T) {
    var item: T? = value
    private set
    val initializedDate = Date()

    fun setItem(newItem: T?) {
        item = newItem
    }
}