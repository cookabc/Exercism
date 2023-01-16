data class MinesweeperBoard(val inputBoard: List<String>) {

    fun withNumbers(): List<String> {
        if (inputBoard.isEmpty()) {
            return emptyList()
        }
        val columns = inputBoard[0].length
        val rows = inputBoard.size

        val result = mutableListOf<String>()

        var mineCount = 0
        for (i in inputBoard.indices) {
            var rowStr = ""
            for (j in inputBoard[i].indices) {
                if (inputBoard[i][j] == '*') {
                    rowStr += '*'
                    continue
                }
                if (i - 1 >= 0) {
                    if (j - 1 >= 0 && inputBoard[i - 1][j - 1] == '*') {
                        mineCount++
                    }
                    if (inputBoard[i - 1][j] == '*') {
                        mineCount++
                    }
                    if (j + 1 < columns && inputBoard[i - 1][j + 1] == '*') {
                        mineCount++
                    }
                }
                if (j - 1 >= 0 && inputBoard[i][j - 1] == '*') {
                    mineCount++
                }
                if (j + 1 < columns && inputBoard[i][j + 1] == '*') {
                    mineCount++
                }
                if (i + 1 < rows) {
                    if (j - 1 >= 0 && inputBoard[i + 1][j - 1] == '*') {
                        mineCount++
                    }
                    if (inputBoard[i + 1][j] == '*') {
                        mineCount++
                    }
                    if (j + 1 < columns && inputBoard[i + 1][j + 1] == '*') {
                        mineCount++
                    }
                }
                if (mineCount == 0) {
                    rowStr += ' '
                } else {
                    rowStr += mineCount
                }
                mineCount = 0
            }
            result.add(rowStr)
        }

        return result
    }
}
