package module_04

fun main() {
    val sourceString = "F2p)v\"y233{0->c}ttelciFc!"      // Ёкранирование символа двойных кавычек
    println("The source string: $sourceString")
    val halfIndex = (sourceString.count() / 2)
    val firstHalfSourceString = sourceString.substring(startIndex = 0, endIndex = halfIndex)
    val twoHalfSourceString = sourceString.substring(startIndex = halfIndex)
    val resultFirstHalf = decoderFirst(sourceString = firstHalfSourceString)
    val resultTwoHalf = decoderTwo(sourceString = twoHalfSourceString)
    val resultString = resultFirstHalf + resultTwoHalf
    println("The resulting string: $resultString")
}

//  Decoding function of the first half of the string
fun decoderFirst(sourceString: String): String {
    var resultString = shift(sourceString=sourceString, shift = 1)
    resultString = resultString.replace(oldChar = '5', newChar = 's')
    resultString = resultString.replace(oldChar = '4', newChar = 'u')
    resultString = shift(sourceString=resultString, shift = -3)
    resultString = resultString.replace(oldChar = '0', newChar = 'o')
    return resultString
}

//  Decoding function of the second half of the string
fun decoderTwo(sourceString: String): String {
    var resultString = sourceString.reversed()
    resultString = shift(sourceString=resultString, shift = -4)
    resultString = resultString.replace(oldChar = '_', newChar = ' ')
    return resultString
}

//  Shift function with signature (String, Int) : String
//  Replaces all characters of the sourceString string with a character
//  to the right or left of the current one with a shift "shift".
fun shift(sourceString: String, shift: Int) : String = sourceString.map {it + shift}.joinToString("")

