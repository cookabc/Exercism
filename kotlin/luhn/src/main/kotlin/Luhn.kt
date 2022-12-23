object Luhn {

    fun isValid(candidate: String): Boolean {
        return with(candidate.replace(" ", "")) {
            matches("\\d{2,}".toRegex()) && reversed().mapIndexed { i, c ->
                if (i % 2 == 0) {
                    c.digitToInt()
                } else {
                    c.digitToInt() * 2 + c.digitToInt() / 5
                }
            }.sum() % 10 == 0
        }
    }
}
