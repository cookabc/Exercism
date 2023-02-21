class NumberSpeller {

    private val numberMap = mapOf(
        0L to "zero",
        1L to "one",
        2L to "two",
        3L to "three",
        4L to "four",
        5L to "five",
        6L to "six",
        7L to "seven",
        8L to "eight",
        9L to "nine",
        10L to "ten",
        11L to "eleven",
        12L to "twelve",
        13L to "thirteen",
        14L to "fourteen",
        15L to "fifteen",
        16L to "sixteen",
        17L to "seventeen",
        18L to "eighteen",
        19L to "nineteen",
        20L to "twenty",
        30L to "thirty",
        40L to "forty",
        50L to "fifty",
        60L to "sixty",
        70L to "seventy",
        80L to "eighty",
        90L to "ninety",
        100L to "hundred",
        1000L to "thousand",
        1000000L to "million",
        1000000000L to "billion",
    )

    fun say(input: Long): String {
        require(input in 0..999999999999)
        return when {
            input <= 20L -> numberMap[input].toString()
            input < 100L -> {
                val a = input / 10 * 10
                val b = input % 10
                numberMap[a] + (if (b == 0L) numberMap[a].toString() else "-" + numberMap[b])
            }
            else -> {
                listOf(
                    countToSay(1000000000L, input / 1000000000L),
                    countToSay(1000000L, (input % 1000000000L) / 1000000L),
                    countToSay(1000L, (input % 1000000L) / 1000L),
                    countToSay(100L, (input % 1000L) / 100L),
                    if (input % 100L == 0L) "" else say(input % 100L)
                ).joinToString(" ").trim()
            }
        }
    }

    private fun countToSay(value: Long, count: Long): String {
        return if (count > 0) {
            say(count) + " " + numberMap[value]
        } else {
            ""
        }
    }
}
