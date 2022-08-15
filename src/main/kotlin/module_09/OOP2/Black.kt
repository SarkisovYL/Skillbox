package module_09.OOP2

import java.math.RoundingMode
import kotlin.math.roundToInt

class Black(
    private val bonus: Double = 1.0,            // �������� ����� � ������� 1% �� �������
    private val accumulation: Double = 0.003    // ���������� � ������� 0.003% �� ����� ����������
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
            val bonusSum = (summa * bonus) / 100
            balance += bonusSum
            println("��������� ������� ${bonusSum.toBigDecimal().setScale(2, RoundingMode.HALF_UP).toDouble()}")
            true
        } else false
    }
}