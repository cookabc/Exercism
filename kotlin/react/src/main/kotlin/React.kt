import kotlin.properties.Delegates

class Reactor<T> {
    // Your compute cell's addCallback method must return an object
    // that implements the Subscription interface.
    interface Subscription {
        fun cancel()
    }

    abstract inner class Cell {
        abstract val value: T
        internal val dependents = mutableListOf<ComputeCell>()
    }

    inner class InputCell(value: T) : Cell() {
        override var value by Delegates.observable(value) { _, _, _ ->
            dependents.forEach { it.propagate() }
            dependents.forEach { it.fireCallbacks() }
        }
    }

    inner class ComputeCell(private vararg val cells: Cell, private val transform: (List<T>) -> T) : Cell() {
        init {
            for (cell in cells) {
                cell.dependents.add(this)
            }
        }

        override var value: T = transform(cells.map { it.value })

        private var lastCallbackValue = value
        private var callbacksIssued = 0
        private val callbackList = mutableMapOf<Int, (T) -> Any>()

        fun addCallback(callback: (T) -> Any): Subscription {
            val id = callbacksIssued++
            callbackList[id] = callback
            return object : Subscription {
                override fun cancel() {
                    callbackList.remove(id)
                }
            }
        }

        internal fun propagate() {
            val newValue = transform(cells.map { it.value })
            if (newValue == value) {
                return
            }
            value = newValue
            dependents.forEach { it.propagate() }
        }

        internal fun fireCallbacks() {
            if (value == lastCallbackValue) {
                return
            }
            lastCallbackValue = value
            for (cb in callbackList.values) {
                cb(value)
            }
            dependents.forEach { it.fireCallbacks() }
        }
    }
}
