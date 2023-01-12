val tonicList = listOf("A", "A#", "B", "C", "C#", "D", "D#", "E", "F", "F#", "G", "G#")

val tonicMap = mapOf(
    "Bb" to "A#", "Db" to "C#", "Eb" to "D#", "Gb" to "F#", "Ab" to "G#"
)

val internalMap = mapOf(
    "m" to 1, "M" to 2, "A" to 3
)

class Scale(tonic: String) {

    private val chromaticList: List<String>

    init {
        val normalized = tonic.replaceFirstChar { it.uppercase() }.let { tonicMap.getOrElse(it) { it } }
        chromaticList = tonicList.indexOf(normalized).let { idx ->
            tonicList.subList(idx, tonicList.size) + tonicList.subList(0, idx)
        }
    }

    fun chromatic(): List<String> {
        return this.chromaticList
    }

    fun interval(intervals: String): List<String> {
        return intervals.dropLast(1).scan(0) { acc, iter ->
            acc + internalMap.getValue(iter.toString())
        }.map { this.chromaticList[it] }
    }

}
