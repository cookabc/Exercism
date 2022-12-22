class Series(private val input: String) {

    init {
        require(input.all { it.isDigit() })
    }

    fun getLargestProduct(span: Int): Long {
        require(span >= 0 && span <= input.length)
        return if (span == 0) 1 else input.windowed(span) {
            it.fold(1) { acc, digit -> acc * digit.digitToInt() }
        }.maxOf { it.toLong() }
    }
}
