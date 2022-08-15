package module_09.OOP2

import java.math.RoundingMode

open class CreditCard(): BankCard() {
    private var creditLimit: Double = 0.0   // Кредитный лимит
    private var funds: Double = 0.0         // Все средства на кредитной карте
    private var creditSum: Double = 0.0     // Кредитные средства

    fun setCreditLimit(creditLimit :Double) {
        this.creditLimit = creditLimit
        creditSum = creditLimit
    }

    override fun putInCard(summa: Double): Boolean {
        return if (summa <= 0) {
            false
        } else {
            if (creditSum >= creditLimit) balance += summa
            else {
                if ((creditSum + summa) < creditLimit) {
                    creditSum += summa
                } else {
                    balance = creditSum + summa - creditLimit
                    creditSum = creditLimit
                }
            }
            funds = creditLimit + balance
            println("Кредитная карта пополнена на $summa рублей.")
            true
        }
    }

    override fun billPay(summa: Double): Boolean {
        if (summa <= 0) return false
        return if (summa > funds) {
            println("Средств на кредитной карте недостаточно для оплаты $summa рублей.")
            println("На карте ${funds.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} " +
                    "руб. Кредитный лимит $creditLimit руб. ")
            false
        } else {
            if (summa <= balance) {
                balance -= summa
            } else {
                creditSum -= summa - balance
                balance = 0.0
            }
            funds = creditSum + balance
            println("Оплачено с кредитной карты $summa рублей.")
            true
        }
    }

    override fun infoBalance() {
        funds = creditSum + balance
        println("Баланс кредитной карты ${funds.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} " +
                "рублей.")
    }

    override fun infoFunds() {
        println("Кредитные средства $creditSum рублей.")
        println("Собственные средства ${balance.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} " +
                "рублей.")
    }
}