import kotlin.math.pow

class Squares(private val naturalNumber: Int) {

    private fun Int.squared(): Int = toDouble().pow(2).toInt()

    fun sumOfSquares(): Int {
        return 1.rangeTo(naturalNumber).sumOf { it.squared() }
    }

    fun squareOfSum(): Int {
        return 1.rangeTo(naturalNumber).sum().squared()
    }

    fun difference(): Int {
        return squareOfSum() - sumOfSquares()
    }
}
