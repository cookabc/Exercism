class DiamondPrinter {

    fun printToList(c: Char): List<String> {
        require(c in 'A'..'Z')
        val vp = ('A' until c) + (c downTo 'A')
        val hp = (c downTo 'A') + ('B'..c)
        return vp.map { y -> hp.map { x -> if (x == y) y else ' ' }.joinToString("") }
    }
}
