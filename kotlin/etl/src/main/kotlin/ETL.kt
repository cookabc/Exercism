object ETL {
    fun transform(source: Map<Int, Collection<Char>>): Map<Char, Int> {
        return source.flatMap { entry ->
            entry.value.map { Pair(it.lowercaseChar(), entry.key) }
        }.toMap()
    }
}
