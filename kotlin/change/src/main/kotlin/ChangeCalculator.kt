class ChangeCalculator(private val coins: List<Int>) {

    fun computeMostEfficientChange(change: Int): List<Int> {
        require(change >= 0) { "Negative totals are not allowed." }

        val changes: MutableList<List<Int>> = mutableListOf()
        (0..change).forEach { changes.add(computeMinChange(it, changes)) }

        return changes[change].takeIf { it.sum() == change }
            ?: throw IllegalArgumentException("The total $change cannot be represented in the given currency.")
    }

    private fun computeMinChange(change: Int, lowerChanges: List<List<Int>>) =
        this.coins.filter { it <= change }
            .reversed()
            .map { listOf(it) + lowerChanges[change - it] }
            .filter { it.sum() == change }
            .minByOrNull { it.size } ?: emptyList()
}