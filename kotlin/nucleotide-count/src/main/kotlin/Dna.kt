class Dna(s: String) {

    init {
        require(!s.contains("[^ACGT]".toRegex()))
    }

    val nucleotideCounts = mapOf('A' to 0, 'C' to 0, 'G' to 0, 'T' to 0) + s.groupingBy { it }.eachCount()
}
