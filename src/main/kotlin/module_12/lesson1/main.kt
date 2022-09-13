package module_12.lesson1

//  Проверяем, достаточно ли у пользователя прав на удаление базы данных с сервера (абстрактная демонстрация)

fun main() {
    val admin = Account(id=1, AccountType.ADMIN)
    Server.dropDatabase(admin)
    val user = Account(id=2, AccountType.USER)
    Server.dropDatabase(user)
}

//  Создадим свой класс исключения, наследник от Throwable, и выведем сообщение в консоль
class AccessRestrictedException : Throwable(message = "You have no rights to perform this operation")

//  Создадим объект сервера
object Server {
    //    Функция принимает пользователя, инициирующего операцию
    fun dropDatabase(user: Account) {
        when (user.type) {
            AccountType.ADMIN -> println("Are you sure you want to drop database ?")
            else -> throw AccessRestrictedException()
        }
    }

}

class Account(
    val id: Int,
    val type: AccountType
)

//  Создадим класс Enum с перечислением типов пользователей
enum class  AccountType {
    ADMIN,
    USER,
}