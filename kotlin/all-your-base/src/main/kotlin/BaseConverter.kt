import kotlin.math.pow

class BaseConverter(base: Int, number: IntArray) {

    init {
        require(base > 1) { "Bases must be at least 2." }
        require(number.isNotEmpty()) { "You must supply at least one digit." }
        require(number.first() != 0 || number.size == 1) { "Digits may not contain leading zeros." }
        require(number.all { it >= 0 }) { "Digits may not be negative." }
        require(number.all { it < base }) { "All digits must be strictly less than the base." }
    }

    private val baseTenValue: Int =
        number.reversed().mapIndexed { index, it -> it * base.toDouble().pow(index) }.sum().toInt()

    fun convertToBase(newBase: Int): IntArray {
        require(newBase > 1) { "Bases must be at least 2." }
        return convertToBase(newBase, baseTenValue)
    }

    private fun convertToBase(newBase: Int, number: Int): IntArray {
        return if (number < newBase) intArrayOf(number)
        else convertToBase(newBase, number / newBase) + number % newBase
    }
}
