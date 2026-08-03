package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PredictWinnerTest {
    private val solution = PredictWinner()

    @Test
    fun `test example 1 - player 1 loses`() {
        val nums = intArrayOf(1, 5, 2)
        assertEquals(false, solution.predictTheWinner(nums))
    }

    @Test
    fun `test example 2 - player 1 wins`() {
        val nums = intArrayOf(1, 5, 233, 7)
        assertEquals(true, solution.predictTheWinner(nums))
    }

    @Test
    fun `test single element - player 1 always wins`() {
        val nums = intArrayOf(5)
        assertEquals(true, solution.predictTheWinner(nums))
    }

    @Test
    fun `test two elements - player 1 picks larger`() {
        val nums = intArrayOf(1, 2)
        assertEquals(true, solution.predictTheWinner(nums))
    }

    @Test
    fun `test equal elements - player 1 wins with tie`() {
        val nums = intArrayOf(3, 3, 3, 3)
        assertEquals(true, solution.predictTheWinner(nums))
    }

    @Test
    fun `test odd length array - player 1 always has advantage`() {
        val nums = intArrayOf(1, 2, 3)
        assertEquals(true, solution.predictTheWinner(nums))
    }

    @Test
    fun `test large values`() {
        val nums = intArrayOf(1000000, 1, 1, 1000000)
        assertEquals(true, solution.predictTheWinner(nums))
    }

    @Test
    fun `test zeros`() {
        val nums = intArrayOf(0, 0, 0, 0)
        assertEquals(true, solution.predictTheWinner(nums))
    }
}
