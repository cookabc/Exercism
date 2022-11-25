class Deque<T> {

    private var front: Node<T>? = null
    private var back: Node<T>? = null

    fun push(value: T) {
        val newNode = Node(value)
        if (back == null) {
            front = newNode
            back = newNode
        } else {
            newNode.prev = back
            back?.next = newNode
            back = newNode
        }
    }

    fun pop(): T? {
        return if (back == null) {
            null
        } else {
            val delNode = back
            back?.prev?.next = null
            back = back?.prev
            delNode?.value
        }
    }

    fun unshift(value: T) {
        val newNode = Node(value)
        if (front == null) {
            front = newNode
            back = newNode
        } else {
            newNode.next = front
            front?.prev = newNode
            front = newNode
        }
    }

    fun shift(): T? {
        return if (front == null) {
            null
        } else {
            val delNode = front
            front?.next?.prev = null
            front = front?.next
            delNode?.value
        }
    }
}

class Node<T>(val value: T) {
    var prev: Node<T>? = null
    var next: Node<T>? = null
}