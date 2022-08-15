package module_09.OOP2

import java.math.RoundingMode

open class DebitCard: BankCard() {

    override fun putInCard(summa: Double): Boolean {
        return if (summa > 0) {
            balance += summa
            println("��������� ����� ��������� �� $summa ������.")
            true
        } else false
    }

    override fun billPay(summa: Double): Boolean {
        if (summa <= 0) return false
        return if (summa > balance) {
            println("�� ��������� ����� ${balance.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} " +
                    "���. ������������ ��� ������ ����� $summa ���.")
            false
        } else {
            balance -= summa
            println("�������� � ��������� ����� $summa ������.")
            true
        }
    }

    override fun infoBalance() {
        println("������ ��������� ����� ${balance.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} ������.")
    }

    override fun infoFunds() {
        println("����� ������� �� ����� ${balance.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} ������.")
    }
}