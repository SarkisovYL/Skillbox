package module_07

class CarCompanioObject(val brand: String, val model: String, val color: String = "White") {

    //    �������������� ����������� �������� �������� ����������� ����� ����� this � ��������� ����������
    constructor(discriptor: Pair<String, String>, color: String): this (
        brand = discriptor.first,
        model = discriptor.second,
        color = color
    )
//    ���� �������������� ������������� ����������� � �������� ������� ��� �� ��� � ���� �������� ������������
    {
        println("Body secondary constructor")
    }
    // ������������ - ��� �������, �� �������� � ������������ ���� ����� ��������� ����� init.
// � ��� ��������� ���, ������� ������ ����������� � ������������ ��� �������� ��������.
// ���������� ������ ���� �� ������� � ���� � �� ���� � ���� ������������.
    init {
        println("Car init 1")
    }

    //    ����������� ������� privet �������� ����������� ������ ������ ������.
//    ��� ������ � ������ � ���������� ������������ ������� � �������, ����� ����������.
//    ��������� � ������ �������� �������� � �������������� ������������ ����� field
    var fuelCount = 0.0f
        get() {
            println("fuelCount getter")
            return field
        }
        set(value) {
            println("\"fuelCount setter")
            field = value
        }
    //  ������� ������ privet � ������ private
//  �.�. �������������� �������� � ������� ��� �� ����� - �� ���� ������� ����� �������
//    ������� � ������� ��� ���� ������ ������������� ��� ���������� ��������
    var currentSpeed = 0.0f
        get     // � ����� ���������� �� ����� � �� ���������, � ��� ��� ������� ������������� get
        // (������ ��������� � ��� ����� �������)
        private set

    init {
        println("Car init 2")
    }

//    ���� currentSpeed � ��� PUBLIC, �� � ���� ���� ��������� ������, �.�. ������� �������� �� ���� �����,
//    � �������� �������� ��� (������ � ������)
//    ���� ���� PUBLIC - �� ������� + ������ �� ����� ���� PRIVATE

//    ��������� ���� ������� � ������� ��� ���� �� �����,
//    ����� ������� ����� ���������� �������� �����-���� �������������� ��������

    fun accelerate(speed: Float){
        val needFuel = speed * 0.12f
        if (this.fuelCount > needFuel) {
            this.currentSpeed += speed
            useFuel(needFuel)
        }
        else
            println("Car is not enough fuel")
    }

    fun decelerate(speed: Float) {
////        ����� ������� ���:
//        var finalspeed = currentSpeed - speed
//        currentSpeed = if (finalspeed < 0) 0.0f
//        else finalspeed
//        �� ����� ��������������� �������� maxOf , ������� ���������� ���������� �� ���� �����
        currentSpeed = maxOf(0.0f, currentSpeed - speed)
    }

    private fun useFuel(fuelCount: Float) {
        this.fuelCount -= fuelCount
    }

//  COMPANION OBJECT
//    ���������� � ������ COMPANION OBJECT ����� ������ ����� �����, � �� ����� ��������� ������

    companion object {
        const val wheelsCount = 4
        fun getCarClass(length: Float): String = when {
            length < 3.6 -> "A"
            length < 3.9 -> "B"
            length < 4.3 -> "C"
            length < 4.6 -> "D"
            length < 5 -> "E"
            else -> "F"
        }
    }
}