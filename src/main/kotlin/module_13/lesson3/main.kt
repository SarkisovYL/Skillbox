package module_13.lesson3

import java.math.BigInteger
import kotlin.random.Random
import kotlin.random.asJavaRandom

//  Напишем функцию, которая рассчитывает большое число и выводит на экран
fun main() {
    println(magicNumber())
    println(magicNumber())
}

fun magicNumber(): BigInteger {
    val number = BigInteger.probablePrime(4000, Random.asJavaRandom())
    return number
}
