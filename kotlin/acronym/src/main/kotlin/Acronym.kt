object Acronym {
    fun generate(phrase: String): String {
        return phrase.split("[^A-Za-z']+".toRegex()).joinToString("") { it[0].uppercase() }
    }
}
