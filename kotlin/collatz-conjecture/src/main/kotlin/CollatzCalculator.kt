object CollatzCalculator {

    fun computeStepCount(start: Int): Int {
        require(start > 0)
        return when {
            start == 1 -> 0
            start % 2 == 0 -> computeStepCount(start / 2) + 1
            else -> computeStepCount(start * 3 + 1) + 1
        }
    }
}
