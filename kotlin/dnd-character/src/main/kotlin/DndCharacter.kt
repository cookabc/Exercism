import kotlin.math.floor

class DndCharacter {
    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + modifier(constitution)

    companion object {

        fun ability(): Int {
            return (1..4).map { (1..6).random() }.sorted().drop(1).sum()
        }

        fun modifier(score: Int): Int {
            return floor((score - 10).toDouble() / 2).toInt()
        }
    }
}