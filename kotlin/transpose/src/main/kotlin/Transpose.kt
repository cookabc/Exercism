object Transpose {

    fun transpose(input: List<String>): List<String> {
        val result = mutableListOf<String>()
        input.forEachIndexed { index, it ->
            it.forEachIndexed { i, c ->
                if (result.size <= i) result.add(i, "".padEnd(index, ' ') + c)
                else result[i] = result[i].padEnd(index, ' ') + c
            }
        }
        return result
    }
}
