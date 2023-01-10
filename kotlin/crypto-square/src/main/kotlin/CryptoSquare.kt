import kotlin.math.ceil
import kotlin.math.sqrt

object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        val normalized = plaintext.lowercase().replace("[^\\da-z]".toRegex(), "")
        return if (normalized.isEmpty()) "" else with(normalized) {
            val c = ceil(sqrt(length.toDouble())).toInt()
            val r = ceil(length.toDouble() / c).toInt()
            padEnd((c * r), ' ').chunked(c).let { rect ->
                (0 until c).joinToString(" ") { idx -> rect.map { it[idx] }.joinToString("") }
            }
        }
    }

}