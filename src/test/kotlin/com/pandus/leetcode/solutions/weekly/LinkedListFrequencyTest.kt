package com.pandus.leetcode.solutions.weekly

import com.pandus.leetcode.solutions.model.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LinkedListFrequencyTest {
    private val solution = LinkedListFrequency()

    private fun listNodeOf(vararg values: Int): ListNode? {
        val dummy = ListNode(0)
        var curr = dummy
        for (v in values) {
            curr.next = ListNode(v)
            curr = curr.next!!
        }
        return dummy.next
    }

    private fun toArray(head: ListNode?): IntArray {
        val result = mutableListOf<Int>()
        var curr = head
        while (curr != null) {
            result.add(curr.`val`)
            curr = curr.next
        }
        return result.toIntArray()
    }

    @Test
    fun `should return frequencies for list with repeated elements`() {
        val input = listNodeOf(1, 2, 2, 3, 3, 3) // List: 1->2->2->3->3->3

        val output = solution.frequenciesOfElements(input)

        assertArrayEquals(intArrayOf(1, 2, 3), toArray(output))
    }

    @Test
    fun `should return empty array for null input`() {
        val input: ListNode? = null

        val output = solution.frequenciesOfElements(input)

        assertArrayEquals(intArrayOf(), toArray(output))
    }
}
