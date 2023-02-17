object Atbash {

    private val cipherMap = ('a'..'z').zip('z' downTo 'a').toMap()

    fun encode(s: String): String {
        return s.lowercase()
            .replace("[^a-z0-9]".toRegex(), "")
            .chunked(5)
            .joinToString(" ") { group ->
                group.map { cipherMap.getOrDefault(it, it) }.joinToString("")
            }
    }

    fun decode(s: String): String {
        return s.lowercase()
            .replace(" ", "")
            .map { cipherMap.getOrDefault(it, it) }
            .joinToString("")
    }
}
