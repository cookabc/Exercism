object ResistorColorTrio {

    fun text(vararg input: Color): String {
        val rawStr = input.take(2).map { it.ordinal }.joinToString("") + "0".repeat(input.elementAt(2).ordinal)
        var count = 0
        for (i in rawStr.length - 1 downTo 0) {
            if (rawStr[i] == '0') {
                count += 1
            }
        }
        val kiloIndex = count / 3
        val unit = Unit.values()[kiloIndex]
        return rawStr.dropLast(kiloIndex * 3) + " $unit".lowercase()
    }
}
