package module_09.OOP2

import java.math.RoundingMode

class Supreme(
    private val cashback: Double = 1.0,         // ������������� ������ 1% �� ������� ��� ������� ���� ������ 1 000 ���.
    private val accumulation: Double = 0.001    // ���������� � ������� 0.003% �� ����� ����������
) : DebitCard() {

    override fun putInCard(summa: Double): Boolean {
        return if (super.putInCard(summa)) {
            var accumulationSum = 0.0
            if (summa * accumulation / 100 >= 0.01) accumulationSum = (summa * accumulation) / 100
            balance += accumulationSum
            println("����� ���������� ${accumulationSum.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()} " +
                    "������")
            true
        } else false
    }

    override fun billPay(summa: Double): Boolean {
        return if (super.billPay(summa)) {
            val bonusSum = (summa * cashback) / 100
            balance += bonusSum
            println("��������� ������� ${bonusSum.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()}")
            true
        } else false
    }
}