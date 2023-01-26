class Forth {

    private val operandList = listOf("+", "-", "*", "/", "dup", "drop", "swap", "over")

    fun evaluate(vararg lines: String): List<Int> {
        var result = mutableListOf<Int>()
        val expressionMap = mutableMapOf<String, String>()
        for (line in lines) {
            if (line.startsWith(":") && line.endsWith(";")) {
                val clearLineTks = line.lowercase().replace("(: )|( ;)".toRegex(), "").split(" ")
                if (clearLineTks.filterNot { tk -> tk.all { it.isDigit() } }.isEmpty()) {
                    throw IllegalArgumentException("illegal operation")
                }
                val expression = clearLineTks.subList(1, clearLineTks.size).joinToString(" ")
                var newExpression = expression
                expressionMap.forEach { (key, value) -> newExpression = newExpression.lowercase().replace(key, value) }
                expressionMap[clearLineTks[0]] = newExpression
            } else {
                var newLine = line
                expressionMap.forEach { (key, value) -> newLine = newLine.lowercase().replace(key, value) }
                val tokens = newLine.lowercase().split(" ")
                val operators = tokens.filter { tk -> tk.all { it.isDigit() } }
                if (operators.isEmpty()) {
                    if (tokens.filterNot { operandList.contains(it) }.isNotEmpty()) {
                        throw IllegalArgumentException("undefined operation")
                    }
                    throw IllegalArgumentException("empty stack")
                }
                for (tk in tokens) {
                    if (tk.all { it.isDigit() }) {
                        result.add(tk.toInt())
                    } else {
                        val stack = mutableListOf<Int>()
                        if (result.size - 1 >= 0) {
                            stack.add(result[result.size - 1])
                        }
                        if (result.size - 2 >= 0) {
                            stack.add(result[result.size - 2])
                        }
                        when (tk) {
                            "+" -> {
                                if (operators.size == 1) {
                                    throw IllegalArgumentException("only one value on the stack")
                                }
                                result = result.dropLast(2).toMutableList()
                                result.add(stack[1] + stack[0])
                            }
                            "-" -> {
                                if (operators.size == 1) {
                                    throw IllegalArgumentException("only one value on the stack")
                                }
                                result = result.dropLast(2).toMutableList()
                                result.add(stack[1] - stack[0])
                            }
                            "*" -> {
                                if (operators.size == 1) {
                                    throw IllegalArgumentException("only one value on the stack")
                                }
                                result = result.dropLast(2).toMutableList()
                                result.add(stack[1] * stack[0])
                            }
                            "/" -> {
                                if (operators.size == 1) {
                                    throw IllegalArgumentException("only one value on the stack")
                                }
                                if (stack[0] == 0) {
                                    throw IllegalArgumentException("divide by zero")
                                } else {
                                    result = result.dropLast(2).toMutableList()
                                    result.add(stack[1] / stack[0])
                                }
                            }
                            "dup" -> {
                                result.add(stack[0])
                            }
                            "drop" -> {
                                result = result.dropLast(1).toMutableList()
                            }
                            "swap" -> {
                                if (operators.size == 1) {
                                    throw IllegalArgumentException("only one value on the stack")
                                }
                                result = result.dropLast(2).toMutableList()
                                result.add(stack[0])
                                result.add(stack[1])
                            }
                            "over" -> {
                                if (operators.size == 1) {
                                    throw IllegalArgumentException("only one value on the stack")
                                }
                                result.add(stack[1])
                            }
                        }
                        stack.clear()
                    }
                }
            }
        }
        return result
    }
}
