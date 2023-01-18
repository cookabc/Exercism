enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    require(naturalNumber > 0)
    val aliquot = (1..naturalNumber / 2).filter { naturalNumber % it == 0 }.sum()
    return when {
        naturalNumber > aliquot -> Classification.DEFICIENT
        naturalNumber < aliquot -> Classification.ABUNDANT
        else -> Classification.PERFECT
    }
}
