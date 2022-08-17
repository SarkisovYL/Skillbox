package module_07.TV

import kotlin.random.Random

class TV (val model: String, val size: Int) {
    val brand: String = "Samsung"
    var turnOnOff: Boolean = false
        private set
    private var currentValume: Int = 50
    private var listChannels: List<String> = Channel.getRandomChannels(countChannels = Random.nextInt(1, 44))
    private var currentChannel: String = listChannels[0]

    //  Включение/Выключение
    fun turnOnOff() {
    if (!turnOnOff) {
        turnOnOff = true
        println("Телевизор ${model} ${size}\" включили!")
    }
    else {
        turnOnOff = false
        println("Телевизор ${model} ${size}\" выключили!")
        }
    }

    //  Увеличить громкость
    fun valumeUp(level : Int) {
        currentValume = if (currentValume + level > maxValume) maxValume else currentValume + level
        println("Телевизор ${model} ${size}\" громкость увеличена. " +
                "Текущая громкость: $currentValume")
    }

    //  Уменьшить громкость
    fun valumeDown(level : Int) {
        currentValume = if (currentValume - level < 0) 0 else currentValume - level
        println("Телевизор ${model} ${size}\" громкость уменьшена. " +
                "Текущая громкость: $currentValume")
    }

    //  Переключение по номеру канала
    fun selectChannels(number: Int) {
        if (!turnOnOff) turnOnOff()
        currentChannel = if (number > 0)
            if (number > listChannels.size) currentChannel else listChannels[number]
        else currentChannel
        println("Телевизор ${model} ${size}\": " +
                "Выбран канал № ${listChannels.indexOf(currentChannel)} - $currentChannel")
    }

    //  Переключение каналов в порядке возрастания
    fun channelUp() {
        if (!turnOnOff) turnOnOff()
        var numberChannel: Int = listChannels.indexOf(currentChannel)
        if (numberChannel < listChannels.size - 1) numberChannel += 1 else numberChannel = 0
        currentChannel = listChannels[numberChannel]
        println("Телевизор ${model} ${size}\": Выбран канал № ${listChannels.indexOf(currentChannel)} - $currentChannel")
    }

    //  Переключение каналов в порядке убывания
    fun channelDown() {
        if (!turnOnOff) turnOnOff()
        var numberChannel: Int = listChannels.indexOf(currentChannel)
        if (numberChannel > 0) numberChannel -= 1 else numberChannel = listChannels.size - 1
        currentChannel = listChannels[numberChannel]
        println("Телевизор ${model} ${size}\": Выбран канал № ${listChannels.indexOf(currentChannel)} - $currentChannel")
    }

    //  Информация по телевизору
    fun info() {
        println("Телевизор: $brand, модель: $model, размер $size\"")
        println("Загружено каналов: ${listChannels.size}")
        println("Список каналов: $listChannels")
        println("Текущий канал: № ${listChannels.indexOf(currentChannel)} - $currentChannel")
        println("Информационный блок. ${Channel.getDescription(currentChannel)}")
        println("Текущая громкость: $currentValume")
    }

    companion object {
        const val maxValume = 100
    }
}