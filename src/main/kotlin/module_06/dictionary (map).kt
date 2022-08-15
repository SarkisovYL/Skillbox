package module_06

fun main() {
//    TODO СЛОВАРИ (ПРЕДСТАВЛЕНИЯ). MAP, как и LIST - это интерфейс и у него есть три реализации:
//     hashMapOf - коллекция основанная на хеш таблице и самая используемая из коллекций map.
//     элементы таблицы - это значения в виде ключ-значение в хеш коде.
//     linkedHashMap и treeMap (сортировка по значению ключа) смотри в презентации.
//    Представляются как пары "ключ" to "значение" неизменяемые значения
//    mapOf возвращает неизменяемый словарь
    val map = mapOf<Int, String>(1 to "1")
//    или через Pair
    val map_ = mapOf<Int, String>(Pair(1, "1"))
//    Представляются как пары "ключ" to "значение" изменяемые значения
//    ниже функции возвращают изменяемые словари
    val mutableMap = mutableMapOf<Int, String>(Pair(1, "1"), Pair(2, "2"))
    val hashMap = hashMapOf(3 to "three", 1 to "one", 2 to "two")
    val treeMap = sortedMapOf(3 to "three", 1 to "one", 2 to "two")
    println(treeMap)
    val linkedHashMap = linkedMapOf<Int, Int>()

//    map[2] = "1234"
//    map_[2] = "1234"
    mutableMap[2] = "1234"
    hashMap[2] = "1234"
    treeMap[2] = "1234"
    linkedHashMap[2] = 1234

//    ЗАДАЧА
//    Сделаем таблицу стоимости товаров для магазина
//    ключ - название товара типа String, а значение - его цена.
    val priceList = mutableMapOf(
        "Milk" to 80,
        "Yogurt" to 50,
        "Apples" to 150,
        "Bananas" to 70,
        "Coca-cola" to 100,
        "Orange juice" to 150
    )
    println(priceList)
//    сделаем тоже самое с использованием  hashMapOf
    val priceListHash = hashMapOf(
        "Milk" to 80,
        "Yogurt" to 50,
        "Apples" to 150,
        "Bananas" to 70,
        "Coca-cola" to 100,
        "Orange juice" to 150
    )
    val priceListtree = sortedMapOf(
        "Milk" to 80,
        "Yogurt" to 50,
        "Apples" to 150,
        "Bananas" to 70,
        "Coca-cola" to 100,
        "Orange juice" to 150
    )
    println("Для hashMapOf ключи расположены в порядке соответствия хеш-функции ")
    println(priceListHash)
    println("Для sortedMapOf ключи расположены в порядке алфавиту ")
    println(priceListtree)

//    Операции со словарем
    priceList["Ice cream"] = 90             // Добавить элемент в словарь
    priceList["Milk"] = 90                  // Изменить значение по ключу
    priceList.remove("Yogurt")          // Удаление элемента по ключу
    println(priceList.keys)                 // Вывод всех ключей словаря
    println(priceList.values.maxOrNull())   // Вывод наибольшего значения
//    Поиск по значению. Найти товары с самой большой стоимостью.
    var maxValue = priceList.values.maxOrNull()
    println(priceList.filterValues { it == maxValue })

// TODO Элементы в map представлены в виде пар ключ-значение.
//  сами эти пары представлены типом Map.Entry у которого есть два поля key и value
// Проход циклом по всем элементам словаря

    for (entry in priceList.entries) {
        println("${entry.key} - ${entry.value}")
    }
//  Аналогично циклом forEach
    priceList.forEach{ entry -> println("forEach_1: ${entry.key} - ${entry.value}") }
//    для цикла forEach допускается сокращенная запись, где в лямбда выражении указаны ключ и значение
    priceList.forEach{ (key, value) -> println("forEach_2: $key - $value")}

//  Сортировка наименованию (по ключу)
    val sortedMapKey = priceList.toSortedMap()
    println("Сортировка по ключу:")
    println(sortedMapKey)

//  Сортировка по длине ключа.
    val sortedMapKeyLength = priceList.toSortedMap(compareBy{it.length})
    println("Сортировка по длине ключа (если длина одинаковая выводится последний найденный):")
    println(sortedMapKeyLength)

//  При таком решении количество отсортированных записей будет меньше чем всего значений в списке,
//  т.к. встречая одинаковые по размеру ключи сортировка выводит последний.
//  Чтобы этого избежать укажем еще один ключ
    val sortedMapKeyLengthAll = priceList.toSortedMap(compareBy<String> {it.length}.thenBy { it })
    println("Сортировка по длине ключа (вывод всех элементов):")
    println(sortedMapKeyLengthAll)

//  Сортировка по значению. см https://www.codevscolor.com/kotlin-sort-map-by-value
    val sortedMapKeyValue = priceList.entries.sortedBy { it.value }
    println("Сортировка по значению:")
    println(sortedMapKeyValue)
}