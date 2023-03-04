data class Item(val weight: Int, val value: Int)

fun knapsack(maximumWeight: Int, items: List<Item>): Int {
    val W = maximumWeight
    val n = items.size
    val w = items.map { it.weight }
    val v = items.map { it.value }

    if (n <= 0 || W <= 0) {
        return 0
    }

    val m = Array(n + 1) { IntArray(W + 1) }
    for (j in 0..W) {
        m[0][j] = 0
    }

    for (i in 1..n) {
        for (j in 1..W) {
            if (w[i - 1] > j) {
                m[i][j] = m[i - 1][j]
            } else {
                m[i][j] = Math.max(
                    m[i - 1][j],
                    m[i - 1][j - w[i - 1]] + v[i - 1]
                )
            }
        }
    }
    return m[n][W]
}
