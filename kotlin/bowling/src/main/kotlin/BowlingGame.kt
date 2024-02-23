class BowlingGame {

    private val frames = mutableListOf<Frame>(OpenFrame(null))

    fun roll(pins: Int) {
        check(pins >= 0) { "rolls can not score negative points" }
        check(pins <= 10) { "a roll can not score more than 10 points" }
        check(frames.size <= 9 || (frames.size == 10 && !frames[9].isFinished)) { "can not roll if game already has ten frames" }

        var currentFrame = frames.last()
        if (currentFrame is TenthSpecialFrame) {
            currentFrame = if (currentFrame.p2 == null) {
                TenthSpecialFrame(currentFrame.p1, pins)
            } else {
                TenthSpecialFrame(currentFrame.p1, currentFrame.p2, pins)
            }
            frames[frames.size - 1] = currentFrame
        } else if (currentFrame is OpenFrame && !currentFrame.isFinished) {
            val is10Frame = frames.size == 10
            val firstPins = currentFrame.p1
            if (firstPins == null) {
                if (pins == 10) {
                    currentFrame = Strike
                } else {
                    currentFrame.p1 = pins
                }
            } else {
                currentFrame = if (firstPins + pins == 10) {
                    if (is10Frame) TenthSpecialFrame(firstPins, pins) else Spare(firstPins)
                } else {
                    OpenFrame(firstPins, pins)
                }
            }
            frames[frames.size - 1] = currentFrame
        } else {
            val is10Frame = frames.size + 1 == 10
            frames.add(if (pins == 10) if (is10Frame) TenthSpecialFrame(10) else Strike else OpenFrame(pins))
        }
    }

    fun score(): Int {
        check(frames.size == 10 && frames.all { it.isFinished }) { "an incomplete game can not be scored" }
        var sum = 0
        frames.forEachIndexed { index, frame ->
            when (frame) {
                is OpenFrame -> {
                    sum += (frame.p1 ?: 0) + (frame.p2 ?: 0)
                }

                is Spare -> {
                    val extraPoints = when (val nextThrow = frames[index + 1]) {
                        is OpenFrame -> nextThrow.p1 ?: 0
                        is Spare -> nextThrow.p1
                        is Strike -> 10
                        is TenthSpecialFrame -> nextThrow.p1
                    }
                    sum += 10 + extraPoints
                }

                is Strike -> {
                    val extraPoints = when (val nextThrow = frames[index + 1]) {
                        is OpenFrame -> (nextThrow.p1 ?: 0) + (nextThrow.p2 ?: 0)
                        is Spare -> 10
                        is Strike -> {
                            10 + when (val next2Throw = frames[index + 2]) {
                                is OpenFrame -> next2Throw.p1 ?: 0
                                is Spare -> next2Throw.p1
                                is Strike -> 10
                                is TenthSpecialFrame -> next2Throw.p1
                            }
                        }

                        is TenthSpecialFrame -> nextThrow.p1 + (nextThrow.p2 ?: 0)
                    }
                    sum += 10 + extraPoints
                }

                is TenthSpecialFrame -> {
                    sum += frame.p1 + (frame.p2 ?: 0) + (frame.p3 ?: 0)
                }

            }
        }
        return sum
    }

    sealed class Frame {
        abstract val isFinished: Boolean
    }

    class OpenFrame(var p1: Int?, var p2: Int? = null) : Frame() {
        init {
            validate()
        }

        override val isFinished: Boolean
            get() = p1 != null && p2 != null

        private fun validate() {
            check((p1 ?: 0) + (p2 ?: 0) <= 10)
        }

        override fun toString() = "[$p1, $p2]"
    }

    class Spare(val p1: Int) : Frame() {
        override val isFinished: Boolean
            get() = true

        override fun toString() = "[$p1, X]"
    }

    object Strike : Frame() {
        override val isFinished: Boolean
            get() = true

        override fun toString() = "[X]"
    }

    class TenthSpecialFrame(val p1: Int, var p2: Int? = null, var p3: Int? = null) : Frame() {
        init {
            validate()
        }

        override val isFinished: Boolean = p2 != null && p3 != null

        private fun validate() {
            if (p1 != 10 || p2 != 10) {
                if (p1 == 10) {
                    check((p2 ?: 0) + (p3 ?: 0) <= 10)
                } else {
                    check(p1 + (p2 ?: 0) <= 10)
                }
            }
        }

        override fun toString() = "[$p1, $p2, $p3]"
    }
}