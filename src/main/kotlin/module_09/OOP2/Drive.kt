package module_09.OOP2

import java.math.RoundingMode

class Drive(
    private val cashback: Double = 0.5         // Потенциальный кэшбэк 0,5% от покупок при условии трат больше 1 000 тыс.
): CreditCard() {

    override fun billPay(summa: Double): Boolean {
        return if (super.billPay(summa)) {
            val bonusSum = (summa * cashback) / 100
            balance += bonusSum
            println("Начислено бонусов ${bonusSum.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()}")
            true
        } else false
    }
}