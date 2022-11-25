object BinarySearch {
    fun search(list: List<Int>, item: Int): Int {
        return (list.size / 2).let { targetIndex ->
            when {
                list.isEmpty() -> throw NoSuchElementException()
                list[targetIndex] < item -> (targetIndex + 1) + search(list.subList(targetIndex + 1, list.size), item)
                list[targetIndex] > item -> search(list.subList(0, targetIndex), item)
                else -> targetIndex
            }
        }
    }
}
