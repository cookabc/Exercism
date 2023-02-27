fun <T> List<T>.customAppend(list: List<T>): List<T> {
    return this + list
}

fun List<Any>.customConcat(): List<Any> {
    return this.flatMap { if (it is List<*>) it.filterNotNull().customConcat() else listOf(it) }
}

fun <T> List<T>.customFilter(predicate: (T) -> Boolean): List<T> {
    return this.filter { predicate(it) }
}

val List<Any>.customSize: Int get() = this.size

fun <T, U> List<T>.customMap(transform: (T) -> U): List<U> {
    return this.map { transform(it) }
}

fun <T, U> List<T>.customFoldLeft(initial: U, f: (U, T) -> U): U {
    return this.fold(initial, f)
}

fun <T, U> List<T>.customFoldRight(initial: U, f: (T, U) -> U): U {
    return this.foldRight(initial, f)
}

fun <T> List<T>.customReverse(): List<T> {
    return this.reversed()
}
