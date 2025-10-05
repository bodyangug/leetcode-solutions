package com.pandus.leetcode.solutions.top.interview

import com.pandus.leetcode.solutions.model.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class AddTwoNumbersTest {

    private val solution = AddTwoNumbers()

    private fun createListNode(values: IntArray): ListNode? {
        if (values.isEmpty()) return null
        val head = ListNode(values[0])
        var current = head
        for (i in 1 until values.size) {
            current.next = ListNode(values[i])
            current = current.next!!
        }
        return head
    }

    private fun listNodeToArray(node: ListNode?): IntArray {
        val result = mutableListOf<Int>()
        var current = node
        while (current != null) {
            result.add(current.`val`)
            current = current.next
        }
        return result.toIntArray()
    }

    @Test
    fun testExample1() {
        // [2,4,3] + [5,6,4] = [7,0,8] (342 + 465 = 807)
        val l1 = createListNode(intArrayOf(2, 4, 3))
        val l2 = createListNode(intArrayOf(5, 6, 4))
        val result = solution.addTwoNumbers(l1, l2)
        assertArrayEquals(intArrayOf(7, 0, 8), listNodeToArray(result))
    }

    @Test
    fun testExample2() {
        // [0] + [0] = [0]
        val l1 = createListNode(intArrayOf(0))
        val l2 = createListNode(intArrayOf(0))
        val result = solution.addTwoNumbers(l1, l2)
        assertArrayEquals(intArrayOf(0), listNodeToArray(result))
    }

    @Test
    fun testExample3() {
        // [9,9,9,9,9,9,9] + [9,9,9,9] = [8,9,9,9,0,0,0,1]
        val l1 = createListNode(intArrayOf(9, 9, 9, 9, 9, 9, 9))
        val l2 = createListNode(intArrayOf(9, 9, 9, 9))
        val result = solution.addTwoNumbers(l1, l2)
        assertArrayEquals(intArrayOf(8, 9, 9, 9, 0, 0, 0, 1), listNodeToArray(result))
    }

    @Test
    fun testDifferentLengths() {
        // [5] + [5,5] = [0,6]
        val l1 = createListNode(intArrayOf(5))
        val l2 = createListNode(intArrayOf(5, 5))
        val result = solution.addTwoNumbers(l1, l2)
        assertArrayEquals(intArrayOf(0, 6), listNodeToArray(result))
    }

    @Test
    fun testCarryPropagation() {
        // [1,8] + [0] = [1,8]
        val l1 = createListNode(intArrayOf(1, 8))
        val l2 = createListNode(intArrayOf(0))
        val result = solution.addTwoNumbers(l1, l2)
        assertArrayEquals(intArrayOf(1, 8), listNodeToArray(result))
    }
}
