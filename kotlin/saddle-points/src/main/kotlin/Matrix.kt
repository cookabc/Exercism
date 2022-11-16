data class MatrixCoordinate(val row: Int, val col: Int)

class Matrix(private val matrix: List<List<Int>>) {

    val saddlePoints: Set<MatrixCoordinate>
        get() = matrix.asSequence()
            .mapIndexed { r, row -> List(row.size) { c -> MatrixCoordinate(r, c) } }
            .flatten()
            .filter { (checkRow(it) && checkCol(it)) }
            .map { MatrixCoordinate(it.row + 1, it.col + 1) }
            .toSet()

    private fun checkRow(c: MatrixCoordinate) = matrix[c.row][c.col] == matrix[c.row].maxOf { it }
    private fun checkCol(c: MatrixCoordinate) = matrix[c.row][c.col] == matrix.map { it[c.col] }.minOf { it }
}
