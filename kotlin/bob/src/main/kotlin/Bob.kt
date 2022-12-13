object Bob {
    fun hey(input: String): String {
        val trimmedInput = input.trim()
        val cleanedInput = trimmedInput.replace("[^A-Za-z]".toRegex(), "")
        return if (cleanedInput.isNotBlank() && cleanedInput.all { it.isUpperCase() }) {
            if (trimmedInput.endsWith("?")) {
                "Calm down, I know what I'm doing!"
            } else {
                "Whoa, chill out!"
            }
        } else if (trimmedInput.endsWith("?")) {
            "Sure."
        } else if (trimmedInput.isBlank()) {
            "Fine. Be that way!"
        } else {
            "Whatever."
        }
    }
}
