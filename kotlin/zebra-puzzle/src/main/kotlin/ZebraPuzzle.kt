val colors = listOf("Red", "Green", "Ivory", "Yellow", "Blue")
val nations = listOf("English", "Ukrainian", "Spaniard", "Norwegian", "Japanese")
val animals = listOf("Dog", "Fox", "Snails", "Horse", "Zebra")
val drinks = listOf("Tea", "Coffee", "Milk", "Orange juice", "Water")
val smokes = listOf("Kools", "Chesterfield", "Old Gold", "Lucky Strike", "Parliament")

val p = Array(120) { IntArray(5) { -1 } } //  stores all permutations of numbers 0..4

private fun nextPerm(perm: IntArray): Boolean {
    val size = perm.size
    var k = -1
    for (i in size - 2 downTo 0) {
        if (perm[i] < perm[i + 1]) {
            k = i
            break
        }
    }
    if (k == -1) return false  // last permutation
    for (l in size - 1 downTo k) {
        if (perm[k] < perm[l]) {
            val temp = perm[k]
            perm[k] = perm[l]
            perm[l] = temp
            var m = k + 1
            var n = size - 1
            while (m < n) {
                val temp2 = perm[m]
                perm[m++] = perm[n]
                perm[n--] = temp2
            }
            break
        }
    }
    return true
}

private fun check(a1: Int, a2: Int, v1: Int, v2: Int): Boolean {
    for (i in 0..4)
        if (p[a1][i] == v1) return p[a2][i] == v2
    return false
}

private fun checkLeft(a1: Int, a2: Int, v1: Int, v2: Int): Boolean {
    for (i in 0..4)
        if (p[a1][i] == v1) return p[a2][i + 1] == v2
    return false
}

private fun checkRight(a1: Int, a2: Int, v1: Int, v2: Int): Boolean {
    for (i in 1..4)
        if (p[a1][i] == v1) return p[a2][i - 1] == v2
    return false
}

private fun checkAdjacent(a1: Int, a2: Int, v1: Int, v2: Int): Boolean {
    return checkLeft(a1, a2, v1, v2) || checkRight(a1, a2, v1, v2)
}

private fun printHouses(c: Int, n: Int, a: Int, d: Int, s: Int) {
    println("=====  ======  =========  ======  ============  ============")
    println("House  Color   Nation     Animal  Drink         Smokes")
    println("=====  ======  =========  ======  ============  ============")
    for (i in 0..4) {
        val f = "%3d    %-6s  %-9s  %-6s  %-12s  %-11s\n"
        System.out.printf(
            f,
            i + 1,
            colors[p[c][i]],
            nations[p[n][i]],
            animals[p[a][i]],
            drinks[p[d][i]],
            smokes[p[s][i]]
        )
    }
    println("=====  ======  =========  ======  ============  ============")
}

private fun fillHouses(): List<List<Int>> {
    val solutions = mutableListOf<List<Int>>()
    for (c in 0..119) {
        if (!checkRight(c, c, 1, 2)) continue                     // C6: Green right of ivory
        for (n in 0..119) {
            if (p[n][0] != 3) continue                                   // C10: Norwegian in First
            if (!check(n, c, 0, 0)) continue                      // C2 : English in Red
            if (!checkAdjacent(n, c, 3, 4)) continue              // C15: Norwegian next to Blue
            for (a in 0..119) {
                if (!check(a, n, 0, 2)) continue                  // C3 : Spaniard has Dog
                for (d in 0..119) {
                    if (p[d][2] != 2) continue                           // C9 : Middle drinks Milk
                    if (!check(d, n, 0, 1)) continue              // C5 : Ukrainian drinks Tea
                    if (!check(d, c, 1, 1)) continue              // C4 : Green drinks Coffee
                    for (s in 0..119) {
                        if (!check(s, a, 2, 2)) continue          // C7 : Old Gold owns snails
                        if (!check(s, c, 0, 3)) continue          // C8 : Yellow smokes Kools
                        if (!check(s, d, 3, 3)) continue          // C13: Lucky Strike drinks orange juice
                        if (!check(s, n, 4, 4)) continue          // C14: Japanese smokes Parliaments
                        if (!checkAdjacent(s, a, 1, 1)) continue  // C11: Chesterfields next to fox
                        if (!checkAdjacent(s, a, 0, 3)) continue  // C12: Kools next to Horse
                        solutions.add(listOf(c, n, a, d, s))
                        printHouses(c, n, a, d, s)
                    }
                }
            }
        }
    }
    return solutions
}

private fun solute(): List<Int> {
    val perm = IntArray(5) { it }
    for (i in 0..119) {
        for (j in 0..4) p[i][j] = perm[j]
        nextPerm(perm)
    }
    return fillHouses()[0]
}

private val solution = solute()

class ZebraPuzzle() {

    fun drinksWater(): String {
        val n = solution[1]
        val d = solution[3]
        var owner = ""
        for (i in 0..4) {
            if (drinks[p[d][i]] == "Water") owner = nations[p[n][i]]
        }
        return owner
    }

    fun ownsZebra(): String {
        val n = solution[1]
        val a = solution[2]
        var owner = ""
        for (i in 0..4) {
            if (animals[p[a][i]] == "Zebra") owner = nations[p[n][i]]
        }
        return owner
    }
}