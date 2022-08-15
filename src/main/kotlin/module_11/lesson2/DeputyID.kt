package module_11.lesson2

class DeputyID(
    private val number: String,
    private val issuedDate: String
) : Document {
    override fun getStringIdentifier(): String = "$number  $issuedDate"

    override fun getType(): String = "Deputy ID"
}