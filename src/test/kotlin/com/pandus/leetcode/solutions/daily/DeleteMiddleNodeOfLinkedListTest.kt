package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class DeleteMiddleNodeOfLinkedListTest {
    private val solution = DeleteMiddleNodeOfLinkedList()

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
    fun `should remove the middle node from an odd-length list`() {
        val input = listNodeOf(1, 3, 4, 7, 1, 2, 6)

        val output = solution.deleteMiddle(input)

        assertArrayEquals(intArrayOf(1, 3, 4, 1, 2, 6), toArray(output))
    }

    @Test
    fun `should remove the second middle node from an even-length list`() {
        val input = listNodeOf(1, 2, 3, 4)

        val output = solution.deleteMiddle(input)

        assertArrayEquals(intArrayOf(1, 2, 4), toArray(output))
    }

    @Test
    fun `should remove the middle node from a two-node list`() {
        val input = listNodeOf(2, 1)

        val output = solution.deleteMiddle(input)

        assertArrayEquals(intArrayOf(2), toArray(output))
    }

    @Test
    fun `should return null for a single-node list`() {
        val input = listNodeOf(1)

        val output = solution.deleteMiddle(input)

        assertNull(output)
    }

    @Test
    fun `should return null for a null head`() {
        val output = solution.deleteMiddle(null)

        assertNull(output)
    }

    @Test
    fun `should remove the middle node from a three-node list`() {
        val input = listNodeOf(1, 2, 3)

        val output = solution.deleteMiddle(input)

        assertArrayEquals(intArrayOf(1, 3), toArray(output))
    }
}

