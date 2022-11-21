import java.util.*

private val letters = ('A'..'Z').toList()
private val digits = ('0'..'9').toList()
private val uniqNames = mutableSetOf<String>()
private fun List<*>.random(n: Int) = (0 until n).map { this[Random().nextInt(this.size)] }

class Robot {
    var name: String

    init {
        name = generateName()
    }

    fun reset() {
        name = generateName()
    }

    private fun generateName(): String {
        val newName = letters.random(2).plus(digits.random(3)).joinToString("")
        return when {
            uniqNames.add(newName) -> newName
            else -> generateName()
        }
    }
}
