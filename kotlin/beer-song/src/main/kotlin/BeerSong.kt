object BeerSong {
    fun verses(startBottles: Int, takeDown: Int): String {
        return (startBottles downTo takeDown).joinToString("\n") { verse(it) }
    }

    private fun verse(bottlesCount: Int): String {
        return when {
            bottlesCount > 1 -> "$bottlesCount bottles of beer on the wall, $bottlesCount bottles of beer.\n" +
                    "Take one down and pass it around, ${getLeftBottle(bottlesCount - 1)} of beer on the wall.\n"
            bottlesCount == 1 -> "1 bottle of beer on the wall, 1 bottle of beer.\n" +
                    "Take it down and pass it around, no more bottles of beer on the wall.\n"
            bottlesCount == 0 -> "No more bottles of beer on the wall, no more bottles of beer.\n" +
                    "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
            else -> ""
        }
    }

    private fun getLeftBottle(bottlesCount: Int): String {
        return when {
            bottlesCount > 1 -> "$bottlesCount bottles"
            else -> "1 bottle"
        }
    }
}
