import Orientation.*

class Robot(var gridPosition: GridPosition = GridPosition(0, 0), var orientation: Orientation = NORTH) {

    fun simulate(instructions: String) {
        instructions.forEach {
            when (it.uppercase()) {
                "A" -> advance()
                "L" -> turnLeft()
                "R" -> turnRight()
            }
        }
    }

    private fun turnRight() {
        orientation = mapOf(NORTH to EAST, EAST to SOUTH, SOUTH to WEST, WEST to NORTH)[orientation]!!
    }

    private fun turnLeft() {
        orientation = mapOf(NORTH to WEST, WEST to SOUTH, SOUTH to EAST, EAST to NORTH)[orientation]!!
    }

    private fun advance() {
        val step =
            mapOf(NORTH to Pair(0, 1), SOUTH to Pair(0, -1), EAST to Pair(1, 0), WEST to Pair(-1, 0))[orientation]!!
        gridPosition = GridPosition(gridPosition.x + step.first, gridPosition.y + step.second)
    }
}
