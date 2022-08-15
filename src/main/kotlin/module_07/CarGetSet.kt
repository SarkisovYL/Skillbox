package module_07

//  ������ ������ ���������� (accelerate) � ����������� (decelerate) � ������ ������� �������:

class CarGetSet(val brand: String, val model: String, val color: String = "White") {

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
}