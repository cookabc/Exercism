object PrimeFactorCalculator {

    fun primeFactors(int: Int): List<Int> {
        return primeFactors(int.toLong()).map { it.toInt() }
    }

    fun primeFactors(long: Long): List<Long> {
        val result = mutableListOf<Long>()
        var leaving = long
        generateSequence(2L) { it + 1 }
            .takeWhile { leaving != 1L }
            .forEach {
                while (leaving % it == 0L) {
                    result.add(it)
                    leaving /= it
                }
            }
        return result
    }
}
