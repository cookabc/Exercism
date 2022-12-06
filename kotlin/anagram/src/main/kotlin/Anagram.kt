class Anagram(private val source: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        val inputMap = source.lowercase().groupBy { it }
        return anagrams.filter { arg ->
            !arg.equals(source, true) && inputMap == arg.lowercase().groupBy { it }
        }.toSet()
    }
}
