package module_11.lesson4

import java.util.*

class GenericCovariant<out T: Number>(value: T) {
    private var item: T? = value
    val initializedDate = Date()

    fun getItem() = item
}