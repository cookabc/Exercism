object SpiralMatrix {

    fun ofSize(size: Int): Array<IntArray> {
        val grid = Array(size) { IntArray(size) }
        var count = 0
        var start = 0
        var end = size - 1
        while (start <= end) {
            (start..end).forEach { grid[start][it] = ++count }
            (start + 1..end).forEach { grid[it][end] = ++count }
            (end - 1 downTo start).forEach { grid[end][it] = ++count }
            (end - 1 downTo start + 1).forEach { grid[it][start] = ++count }
            ++start
            --end
        }
        return grid
    }
}
