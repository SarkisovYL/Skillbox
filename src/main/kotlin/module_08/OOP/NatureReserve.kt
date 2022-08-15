package module_08.OOP

object NatureReserve {
    private var reserveList = mutableListOf <Animal>()  // ������� ������ ��������
    private var birthList = mutableListOf <Animal>()    // ������ ��������� ��������
    private var deadList = mutableListOf <Animal>()     // ������ �������� ��������

    // �������� �������� � ���� ���������
    fun add(animal: Animal) {
        birthList.add(animal)
    }

    // �������� �������� � ���� ��������
    fun remove(animal: Animal) {
        deadList.add(animal)
    }

    // �������� ������� ������ ��������
    fun getReserveList(): MutableList<Animal> {
        reserveList = birthList.filter { it !in deadList } as MutableList<Animal>
        return reserveList
    }

    // �������� ������ ��������� ��������
    fun getBirthList(): MutableList<Animal> {
        return birthList
    }

    // �������� ������ ������� ��������
    fun getDeadList(): MutableList<Animal> {
        return deadList
    }

    // ���������� � �������� �����������
    fun info() {
        this.getReserveList()
        if (reserveList.size > 0) {
            println("� ����������� ���������:")
            reserveList.forEachIndexed { index, item ->  println("${index + 1}: ${item::class.simpleName}. " +
                    "���: ${item.name}. ���: ${item.weight}. �������: ${item.energy}. " +
                    "�������: ${item.currentAge}, ������������ �������: ${item.maxAge}.")}
        }
        else
        {
            println("� �������� �������� ���.")
        }
    }
}