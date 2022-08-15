package module_09.OOP2

import java.math.RoundingMode

open class CreditCard(): BankCard() {
    private var creditLimit: Double = 0.0   // ��������� �����
    private var funds: Double = 0.0         // ��� �������� �� ��������� �����
    private var creditSum: Double = 0.0     // ��������� ��������

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
            println("��������� ����� ��������� �� $summa ������.")
            true
        }
    }

    override fun billPay(summa: Double): Boolean {
        if (summa <= 0) return false
        return if (summa > funds) {
            println("������� �� ��������� ����� ������������ ��� ������ $summa ������.")
            println("�� ����� ${funds.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} " +
                    "���. ��������� ����� $creditLimit ���. ")
            false
        } else {
            if (summa <= balance) {
                balance -= summa
            } else {
                creditSum -= summa - balance
                balance = 0.0
            }
            funds = creditSum + balance
            println("�������� � ��������� ����� $summa ������.")
            true
        }
    }

    override fun infoBalance() {
        funds = creditSum + balance
        println("������ ��������� ����� ${funds.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} " +
                "������.")
    }

    override fun infoFunds() {
        println("��������� �������� $creditSum ������.")
        println("����������� �������� ${balance.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} " +
                "������.")
    }
}