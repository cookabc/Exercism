object AffineCipher {

    private const val m = 26

    fun encode(input: String, a: Int, b: Int): String {
        require(a.coPrime(m)) { "Error: a and m must be coprime." }
        return input.lowercase()
            .filter(Char::isLetterOrDigit)
            .map { doEncode(it, a, b) }
            .chunked(5)
            .joinToString(" ") { group ->
                group.joinToString("")
            }
    }

    fun decode(input: String, a: Int, b: Int): String {
        require(a.coPrime(m)) { "Error: a and m must be coprime." }
        return input.filter(Char::isLetterOrDigit)
            .map { doDecode(it, a, b) }
            .joinToString("")
    }

    private fun doEncode(c: Char, a: Int, b: Int): Char {
        return if (c.isDigit()) c else 'a' + (a * (c - 'a') + b) % m
    }

    private fun doDecode(c: Char, a: Int, b: Int): Char {
        return if (c.isDigit()) c else 'a' + (a.calcMmi(m) * (c - 'a' - b) % m + m) % m
    }

    private fun Int.coPrime(m: Int): Boolean = this.factors().intersect(m.factors().toSet()).isEmpty()

    private fun Int.factors(): List<Int> = (2..this).filter { this % it == 0 }

    private fun Int.calcMmi(m: Int): Int = (2 until m).first { this * it % m == 1 }
}
