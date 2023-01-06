class Allergies(private val score: Int) {

    fun getList(): List<Allergen> = enumValues<Allergen>().filter { isAllergicTo(it) }

    fun isAllergicTo(allergen: Allergen) = score and allergen.score != 0
}
