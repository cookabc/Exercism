class CustomSet(vararg items: Int) {

    private val internalSet = items.toMutableSet()

    fun isEmpty(): Boolean {
        return internalSet.isEmpty()
    }

    fun isSubset(other: CustomSet): Boolean {
        return internalSet.all { other.contains(it) }
    }

    fun isDisjoint(other: CustomSet): Boolean {
        return internalSet.none { other.contains(it) }
    }

    fun contains(other: Int): Boolean {
        return internalSet.contains(other)
    }

    fun intersection(other: CustomSet): CustomSet {
        internalSet.removeAll { !other.contains(it) }
        return this
    }

    fun add(other: Int) {
        internalSet.add(other)
    }

    override fun equals(other: Any?): Boolean {
        return isSubset(other as CustomSet) && other.isSubset(this)
    }

    operator fun plus(other: CustomSet): CustomSet {
        internalSet.forEach { other.add(it) }
        return other
    }

    operator fun minus(other: CustomSet): CustomSet {
        internalSet.removeIf { other.contains(it) }
        return this
    }

    override fun hashCode(): Int {
        return internalSet.hashCode()
    }
}
