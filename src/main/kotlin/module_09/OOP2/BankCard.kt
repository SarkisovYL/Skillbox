package module_09.OOP2

abstract class BankCard {
    protected var balance: Double = 0.0             // Баланс

    abstract fun putInCard(summa: Double): Boolean  // Пополняет карту на переданную сумму
    abstract fun billPay(summa: Double): Boolean    // Списывает с карты переданную сумму и возвращает результат типа Boolean
    abstract fun infoBalance()                      // Получить информацию о балансе
    abstract fun infoFunds()                        // Получить информацию о доступных средствах
}