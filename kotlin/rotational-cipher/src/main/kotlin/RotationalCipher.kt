class RotationalCipher(private val i: Int) {

    private val lowerCases = ('a'..'z').toList()
    private val upperCases = ('A'..'Z').toList()

    private fun buildLetterMap(chars: List<Char>, n: Int): Map<Char, Char> =
        chars.zip(chars.drop(n) + chars.take(n)).toMap()

    private val letterMap = buildLetterMap(lowerCases, i) + buildLetterMap(upperCases, i)

    fun encode(text: String): String {
        return text.map { letterMap[it] ?: it }.joinToString("")
    }
}
