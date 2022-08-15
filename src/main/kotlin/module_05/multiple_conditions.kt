package module_05

// ������� ��������� ������� ���������� ������� ������������, ����������� �� ��� �����.
// ���� ����� ��� - �� intern ���� �� 1 �� 3 ��� �� junier � �.�.
// ������� getDeveloperPosition ����� �� ����������� ���. ���� ������� ���� �� ������������ ���������
// � ������ alt-enter, �� ����� ��������� �������������� ������:
// ������� getDeveloperPositionOptimal - �������� � �������������� ����������� ������ Kotlin

fun main() {
    println("Enter experience")
    val experience: Int = readLine()?.toIntOrNull() ?: return
    println("Your a status ${getDeveloperPosition(experience)}")
    println("Your a status ${getDeveloperPositionOptimal(experience)}")
    println(getUserAccess(false, "Admin"))
}

fun getDeveloperPosition(experience: Int): String {
    if (experience == 0) return "intern"
    else if (experience >= 1 && experience < 3) return "junier"
    else if (experience >= 3 && experience < 5) return "middle"
    else if (experience >= 4 && experience < 6) return "senior"
    else return "leading"
}

fun getDeveloperPositionOptimal(experience: Int): String {
    // ������������ �������� when � ���������. �.�. �� ��������� ������� experience �� ������������ ��������.
    when (experience) {
        0 -> return "intern"    // 0 - ��������, return "intern" - ���� ���� ������� ����� ���������
        in 1..2 -> return "junier"
        in 3..4 -> return "middle"
        in 4..5 -> return "senior"
        else -> return "leading"
    }
}

fun getUserAccess(isAuthorized: Boolean, role: String): String {
    return when {
        !isAuthorized -> "Restricted"
        role == "Admin" -> "Full"
        role == "Moderator" -> "Limited"
        else -> "Common"
    }
}
