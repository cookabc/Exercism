class BinarySearchTree<T : Comparable<T>> {

    data class Node<T>(val data: T, var left: Node<T>?, var right: Node<T>?)

    var root: Node<T>? = null

    fun insert(value: T) {
        if (this.root == null) {
            this.root = Node(value, null, null)
        } else {
            insertPerNode(this.root!!, value)
        }
    }

    private fun insertPerNode(node: Node<T>, value: T) {
        val newNode = Node(value, null, null)
        if (value <= node.data) {
            if (node.left == null) {
                node.left = newNode
            } else {
                insertPerNode(node.left!!, value)
            }
        } else {
            if (node.right == null) {
                node.right = newNode
            } else {
                insertPerNode(node.right!!, value)
            }
        }
    }

    fun asSortedList(): List<T> {
        return this.asLevelOrderList().sorted()
    }

    fun asLevelOrderList(): List<T> {
        return this.getSubDataPerNode(this.root!!, 0).sortedBy { it.first }.map { it.second }
    }

    private fun getSubDataPerNode(node: Node<T>, level: Int): List<Pair<Int, T>> {
        val pairs = mutableListOf(Pair(level, node.data))
        if (node.left != null) {
            pairs.addAll(getSubDataPerNode(node.left!!, level + 1))
        }
        if (node.right != null) {
            pairs.addAll(getSubDataPerNode(node.right!!, level + 1))
        }
        return pairs
    }
}
