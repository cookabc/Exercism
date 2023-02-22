import kotlin.random.Random

private val alphabets = ('a'..'z').toList()

data class Cipher(val key: String) {


    constructor() : this((1..100).map { alphabets[Random.nextInt(26)] }.joinToString(""))

    init {
        require(key.isNotEmpty() && key.all { it.isLowerCase() })
    }

    fun encode(s: String): String {
        return s.zip(this.getRealKey(s, key)).map {
            alphabets[(alphabets.indexOf(it.first) + alphabets.indexOf(it.second)) % alphabets.size]
        }.joinToString("")
    }

    fun decode(s: String): String {
        return s.zip(this.getRealKey(s, key)).map {
            alphabets[(alphabets.indexOf(it.first) - alphabets.indexOf(it.second) + alphabets.size) % alphabets.size]
        }.joinToString("")
    }

    private fun getRealKey(text: String, key: String?): String {
        return if (key == null) {
            ""
        } else if (text.length <= key.length) {
            key
        } else {
            generateSequence(key) { it + key }.takeWhile { text.length > it.length }.joinToString("")
        }
    }
}
