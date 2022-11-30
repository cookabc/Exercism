object Isogram {

    fun isIsogram(input: String): Boolean = input.lowercase()
        .filter(Char::isLetter)
        .let { it.toSet().size == it.length }
}
