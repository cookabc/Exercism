import kotlin.math.pow

object ArmstrongNumber {

    fun check(input: Int): Boolean {
        return "$input".run { sumOf { it.digitToInt().toDouble().pow(length).toInt() } == input }
    }

}
