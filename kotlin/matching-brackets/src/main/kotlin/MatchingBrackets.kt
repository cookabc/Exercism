import java.util.Stack

object MatchingBrackets {

    private val openSymbols = listOf('(', '[', '{')
    private val symbolMap = mapOf('(' to ')', '[' to ']', '{' to '}')

    fun isValid(input: String): Boolean {
        val charStack = Stack<Char>()
        val cleanText = input.replace("[^\\[\\](){}]".toRegex(), "")
        for (char in cleanText) {
            if (openSymbols.contains(char)) {
                charStack.push(char)
            } else {
                if (charStack.isEmpty() || symbolMap[charStack.peek()] != char) {
                    return false
                }
                charStack.pop()
            }
        }

        return charStack.isEmpty()
    }
}
