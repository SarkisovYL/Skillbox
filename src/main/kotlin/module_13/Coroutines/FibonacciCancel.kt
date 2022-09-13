package module_13.Coroutines

import java.math.BigInteger
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

object FibonacciCancel {
    suspend fun take(index: Int): BigInteger {
        return suspendCoroutine {
            if (index == 0) {
                it.resume(BigInteger.ZERO)
            }
            if (index < 0) {
                throw IndexOutOfBoundsException(index.toString())
            }
            var n0 = BigInteger.ZERO
            var n1 = BigInteger.ONE
            var i = BigInteger.TWO
            while (i <= index.toBigInteger()) {
                val n2 = n0 + n1
                n0 = n1
                n1 = n2
                i++
            }
            it.resume(n1)
        }
    }
}
