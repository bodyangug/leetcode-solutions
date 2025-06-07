package com.pandus.leetcode.solutions.weekly

import com.pandus.leetcode.solutions.model.ListNode
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WinnerOfLinkedListGameTest {
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
    fun gameResult_returnsEvenWhenEvenWins_positiveCase() {
        val input = listNodeOf(5, 1, 6, 2)
        val solution = WinnerOfLinkedListGame()
        assertEquals("Even", solution.gameResult(input))
    }

    @Test
    fun gameResult_returnsOddWhenNoWinner_negativeCase() {
        val input = listNodeOf(1, 2, 3, 4)
        val solution = WinnerOfLinkedListGame()
        assertEquals("Odd", solution.gameResult(input))
    }
}
