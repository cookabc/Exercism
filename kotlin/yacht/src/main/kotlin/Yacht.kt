import YachtCategory.*

object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        return when (category) {
            ONES -> dices.filter { it == 1 }.sum()
            TWOS -> dices.filter { it == 2 }.sum()
            THREES -> dices.filter { it == 3 }.sum()
            FOURS -> dices.filter { it == 4 }.sum()
            FIVES -> dices.filter { it == 5 }.sum()
            SIXES -> dices.filter { it == 6 }.sum()
            FULL_HOUSE -> {
                if (dices.toList().groupingBy { it }.eachCount().values.toList() == listOf(2, 3)) {
                    return dices.sum()
                } else {
                    return 0
                }
            }
            FOUR_OF_A_KIND -> {
                for (item in dices.toList().groupingBy { it }.eachCount()) {
                    if (item.value >= 4) {
                        return item.key * 4
                    }
                }
                return 0
            }
            LITTLE_STRAIGHT -> {
                if (dices.sorted() == listOf(1, 2, 3, 4, 5)) {
                    return 30
                } else {
                    return 0
                }
            }
            BIG_STRAIGHT -> {
                if (dices.sorted() == listOf(2, 3, 4, 5, 6)) {
                    return 30
                } else {
                    return 0
                }
            }
            CHOICE -> dices.sum()
            YACHT -> {
                if (dices.all { it == dices[0] }) {
                    return 50
                } else {
                    return 0
                }
            }
        }
    }
}
