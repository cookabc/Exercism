object PigLatin {

    private val vowel = Regex("(\\s*)(a|e|i|o|u|yt|xr)(\\w+)")
    private val consonant = Regex("(\\s*)(ch|qu|thr|th|sch|yt|rh|\\wqu|\\w)(\\w+)")

    fun translate(input: String): String {
        return if (vowel.matches(input))
            vowel.replace(input, "\$1\$2\$3ay")
        else
            consonant.replace(input, "\$1\$3\$2ay")
    }
}
