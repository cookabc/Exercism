object HandshakeCalculator {

    fun calculateHandshake(n: Int): List<Signal> =
        if (n >= 16)
            calculateHandshake(n - 16).reversed()
        else if (n >= 8)
            calculateHandshake(n - 8) + listOf(Signal.JUMP)
        else if (n >= 4)
            calculateHandshake(n - 4) + listOf(Signal.CLOSE_YOUR_EYES)
        else if (n >= 2)
            calculateHandshake(n - 2) + listOf(Signal.DOUBLE_BLINK)
        else if (n >= 1)
            listOf(Signal.WINK)
        else
            listOf()
}
