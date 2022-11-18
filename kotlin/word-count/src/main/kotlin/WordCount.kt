object WordCount {

    fun phrase(phrase: String): Map<String, Int> {
        return phrase
            .lowercase()
            .split("[^0-9a-zA-Z']+".toRegex())
            .map { it.replace("^'|'$".toRegex(), "") }
            .filter(String::isNotEmpty)
            .groupingBy { it }
            .eachCount()
    }
}
