import kotlin.math.pow

object Wordy {

    fun answer(input: String): Int {
        val normalized = input.replace("(What is )|\\?".toRegex(), "")
            .replace("plus", "+")
            .replace("minus", "-")
            .replace("multiplied by", "*")
            .replace("divided by", "/")
            .replace("raised to the", "^")
            .replace("th power", "")

        require(normalized.matches("(\\s*(-?\\d+)\\s*([+\\-*/^]\\s*(-?\\d+)\\s*)*)".toRegex()))

        return calc(normalized.split("\\s+".toRegex()))
    }

    private fun calc(sequence: List<String>): Int {
        if (sequence.size == 1) {
            return sequence[0].toInt()
        }
        val result = eval(sequence[0].toInt(), sequence[2].toInt(), sequence[1])
        if (sequence.size == 3) {
            return result
        }
        return calc(mutableListOf(result.toString()) + sequence.subList(3, sequence.size))
    }

    private fun eval(operator1: Int, operator2: Int, operation: String): Int {
        return when (operation) {
            "+" -> operator1 + operator2
            "-" -> operator1 - operator2
            "*" -> operator1 * operator2
            "/" -> operator1 / operator2
            "^" -> operator1.toDouble().pow(operator2.toDouble()).toInt()
            else -> 0
        }
    }
}
