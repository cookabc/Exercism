class ChainNotFoundException : RuntimeException()

data class Domino(val left: Int, val right: Int)

object Dominoes {

    fun formChain(vararg xs: Domino) = formChain(xs.toList())

    fun formChain(xs: List<Domino>): List<Domino> =
        if (xs.isEmpty())
            emptyList()
        else {
            val ys = mutableListOf(listOf(xs.first()))
            go(ys, xs.drop(1))
            ys.removeIf { it.size != xs.size || it.first().left != it.last().right }
            if (ys.isEmpty()) throw ChainNotFoundException() else ys.first()
        }

    private fun go(acc: MutableList<List<Domino>>, pool: List<Domino>) {
        if (pool.isEmpty()) return
        val xs = acc.last()
        val last = xs.last()
        pool.filter { last.right == it.left || last.right == it.right }
            .forEach {
                acc.add(xs.plus(if (last.right == it.left) it else Domino(it.right, it.left)))
                go(acc, pool.minus(it))
            }
    }
}