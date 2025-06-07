package com.pandus.leetcode.solutions.top.interview

import com.pandus.leetcode.solutions.model.ListNode
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class AddTwoNumbersTest {
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
    fun addTwoNumbers_addsNumbersCorrectly_positiveCase() {
        val l1 = listNodeOf(2, 4, 3)
        val l2 = listNodeOf(5, 6, 4)
        val solution = AddTwoNumbers()
        val result = solution.addTwoNumbers(l1, l2)
        assertArrayEquals(intArrayOf(7, 0, 8), toArray(result))
    }

    @Test
    fun addTwoNumbers_returnsNullWhenBothNull_negativeCase() {
        val solution = AddTwoNumbers()
        val result = solution.addTwoNumbers(null, null)
        assertArrayEquals(intArrayOf(), toArray(result))
    }
}
