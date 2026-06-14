package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTwinSumOfLinkedListTest {

    private val solution = MaximumTwinSumOfLinkedList()

    private fun listNodeOf(vararg values: Int): ListNode? {
        val dummy = ListNode(0)
        var curr = dummy
        for (v in values) {
            curr.next = ListNode(v)
            curr = curr.next!!
        }
        return dummy.next
    }

    @Test
    fun `example 1 - all twin sums equal 6`() {
        val head = listNodeOf(5, 4, 2, 1)
        assertEquals(6, solution.pairSum(head))
    }

    @Test
    fun `example 2 - maximum twin sum is 7`() {
        val head = listNodeOf(4, 2, 2, 3)
        assertEquals(7, solution.pairSum(head))
    }

    @Test
    fun `example 3 - two nodes only`() {
        val head = listNodeOf(1, 100000)
        assertEquals(100001, solution.pairSum(head))
    }

    @Test
    fun `null head returns 0`() {
        assertEquals(0, solution.pairSum(null))
    }
}
