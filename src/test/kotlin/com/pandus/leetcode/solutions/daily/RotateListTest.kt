package com.pandus.leetcode.solutions.daily

import com.pandus.leetcode.solutions.model.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class RotateListTest {
    private val solution = RotateList()

    private fun buildList(values: List<Int>): ListNode? {
        if (values.isEmpty()) return null
        val head = ListNode(values[0])
        var current = head
        for (i in 1 until values.size) {
            val node = ListNode(values[i])
            current.next = node
            current = node
        }
        return head
    }

    private fun toList(head: ListNode?): List<Int> {
        val result = mutableListOf<Int>()
        var current = head
        while (current != null) {
            result.add(current.`val`)
            current = current.next
        }
        return result
    }

    @Test
    fun `example 1 - rotate by 2`() {
        val head = buildList(listOf(1, 2, 3, 4, 5))
        val result = solution.rotateRight(head, 2)
        assertEquals(listOf(4, 5, 1, 2, 3), toList(result))
    }

    @Test
    fun `example 2 - rotate by 4`() {
        val head = buildList(listOf(0, 1, 2))
        val result = solution.rotateRight(head, 4)
        assertEquals(listOf(2, 0, 1), toList(result))
    }

    @Test
    fun `null head`() {
        val result = solution.rotateRight(null, 1)
        assertNull(result)
    }

    @Test
    fun `single element`() {
        val head = buildList(listOf(1))
        val result = solution.rotateRight(head, 5)
        assertEquals(listOf(1), toList(result))
    }

    @Test
    fun `k equals zero`() {
        val head = buildList(listOf(1, 2, 3))
        val result = solution.rotateRight(head, 0)
        assertEquals(listOf(1, 2, 3), toList(result))
    }
}
