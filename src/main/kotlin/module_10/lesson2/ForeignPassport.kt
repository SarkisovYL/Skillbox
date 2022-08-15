package module_10.lesson2

class ForeignPassport(
    private val series: String,
    private val number: String
) : Document {
    override fun getStringIdentifier(): String= "$series $number"

    override fun getType(): String = "Foreign passport"
}