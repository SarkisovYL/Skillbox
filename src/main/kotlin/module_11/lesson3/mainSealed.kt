package module_11.lesson3

fun main() {
    println(switchColor(SealedColor.Red))
    println(switchColor(SealedColor.Blue))
}

//  Функция принимает цвет и возвращает другой цвет
fun switchColor(color: SealedColor): SealedColor = when(color) {
    SealedColor.While -> SealedColor.Black
    SealedColor.Black -> SealedColor.Red
    SealedColor.Red -> SealedColor.Green
    SealedColor.Green -> SealedColor.Blue
//    TODO Для поверки объектов описанных классами а не объектами-наследниками, мы должны использовать оператор "is"
    is SealedColor.CustomColor -> SealedColor.CustomColor("#345")
//    TODO но лучше все описывать с использованием оператора "is", т.к. в классе sealed всегда можно
//     поменять объект на класс и без оператора будет ошибка.
    is SealedColor.Blue -> SealedColor.While
}
