package module_09.OOP2

import java.math.RoundingMode

open class DebitCard: BankCard() {

    override fun putInCard(summa: Double): Boolean {
        return if (summa > 0) {
            balance += summa
            println("Дебетовая карта пополнена на $summa рублей.")
            true
        } else false
    }

    override fun billPay(summa: Double): Boolean {
        if (summa <= 0) return false
        return if (summa > balance) {
            println("На дебетовой карте ${balance.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} " +
                    "руб. Недостаточно для оплаты суммы $summa руб.")
            false
        } else {
            balance -= summa
            println("Оплачено с дебетовой карты $summa рублей.")
            true
        }
    }

    override fun infoBalance() {
        println("Баланс дебетовой карты ${balance.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} рублей.")
    }

    override fun infoFunds() {
        println("Всего средств на счете ${balance.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} рублей.")
    }
}