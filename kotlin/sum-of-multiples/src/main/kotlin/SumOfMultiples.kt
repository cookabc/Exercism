object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        return factors.filterNot { it == 0 }.flatMap { (0 until limit).step(it) }.toSet().sum()
    }
}
