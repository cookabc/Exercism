object ScrabbleScore {

    private fun scoreLetter(c: Char): Int {
        return when (c) {
            in "DG" -> 2
            in "BCMP" -> 3
            in "FHVWY" -> 4
            'K' -> 5
            in "JX" -> 8
            in "QZ" -> 10
            else -> 1
        }
    }

    fun scoreWord(input: String) = input.uppercase().sumOf { scoreLetter(it) }
}
