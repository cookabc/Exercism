class IsbnVerifier {

    fun isValid(number: String): Boolean {
        return number.replace("[^\\dX]".toRegex(), "")
            .run {
                this.matches("\\d{9}[\\dX]".toRegex())
                        && this.mapIndexed { i, it -> it.asDigit() * (10 - i) }.sum() % 11 == 0
            }
    }

    private fun Char.asDigit(): Int = if (this.isDigit()) this.digitToInt() else 10
}
