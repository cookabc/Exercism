class Matrix(matrixAsString: String) {

    private val matrix: List<List<Int>> = matrixAsString.lines().map {
        it.trim().split("\\s+".toRegex()).map(String::toInt)
    }

    fun column(colNr: Int): List<Int> {
        return matrix.map { it[colNr - 1] }
    }

    fun row(rowNr: Int): List<Int> {
        return matrix[rowNr - 1]
    }
}
