object ResistorColorDuo {

    fun value(vararg colors: Color): Int {
        return colors.map { it.ordinal }
            .take(2)
            .joinToString("")
            .toInt()
    }
}
