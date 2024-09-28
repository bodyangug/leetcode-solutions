package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/design-circular-deque
class DesignCircularDeque(k: Int) {
    private val k = k
    private val head = Node()
    private val tail = Node()
    private var currentNodeCnt = 0

    init {
        head.next = tail
        tail.prev = head
    }

    fun insertFront(value: Int): Boolean {
        if (isFull()) return false
        var newNode = Node(value, head, head.next)
        val n = head.next
        head.next = newNode
        n?.prev = newNode
        currentNodeCnt++
        return true
    }

    fun insertLast(value: Int): Boolean {
        if (isFull()) return false
        var newNode = Node(value, tail.prev, tail)
        val p = tail.prev
        tail.prev = newNode
        p?.next = newNode
        currentNodeCnt++
        return true
    }

    fun deleteFront(): Boolean {
        if (isEmpty()) return false
        val n = head.next?.next
        n?.prev = head
        head.next = n

        currentNodeCnt--
        return true
    }

    fun deleteLast(): Boolean {
        if (isEmpty()) return false
        val n = tail.prev?.prev
        n?.next = tail
        tail.prev = n
        currentNodeCnt--
        return true
    }

    fun getFront(): Int {
        if (isEmpty()) return -1
        return head.next?.value ?: -1
    }

    fun getRear(): Int {
        if (isEmpty()) return -1
        return tail.prev?.value ?: -1
    }

    fun isEmpty(): Boolean {
        return head.next == tail
    }

    fun isFull(): Boolean {
        return currentNodeCnt == k
    }
}

data class Node(
    var value: Int = 0,
    var prev: Node? = null,
    var next: Node? = null,
)
