class Triangle<out T : Number>(a: T, b: T, c: T) {

    private val first = a.toDouble()
    private val second = b.toDouble()
    private val third = c.toDouble()

    init {
        require(first > 0 && second > 0 && third > 0)
        require(first + second > third && first + third > second && second + third > first)
    }

    val isEquilateral: Boolean = first == second && second == third
    val isIsosceles: Boolean = first == second || second == third || first == third
    val isScalene: Boolean = !isIsosceles
}
