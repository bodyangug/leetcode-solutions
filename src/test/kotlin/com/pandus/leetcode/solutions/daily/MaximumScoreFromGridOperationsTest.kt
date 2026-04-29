package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumScoreFromGridOperationsTest {

    private val solution = MaximumScoreFromGridOperations()

    @Test
    fun `example 1`() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 3, 0, 0),
            intArrayOf(0, 1, 0, 0, 0),
            intArrayOf(5, 0, 0, 3, 0),
            intArrayOf(0, 0, 0, 0, 2)
        )
        assertEquals(11L, solution.maximumScore(grid))
    }

    @Test
    fun `example 2`() {
        val grid = arrayOf(
            intArrayOf(10, 9, 0, 0, 15),
            intArrayOf(7, 1, 0, 8, 0),
            intArrayOf(5, 20, 0, 11, 0),
            intArrayOf(0, 0, 0, 1, 2),
            intArrayOf(8, 12, 1, 10, 3)
        )
        assertEquals(94L, solution.maximumScore(grid))
    }

    @Test
    fun `single column grid returns zero`() {
        val grid = arrayOf(
            intArrayOf(5),
            intArrayOf(3),
            intArrayOf(7)
        )
        assertEquals(0L, solution.maximumScore(grid))
    }

    @Test
    fun `all zeros grid`() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertEquals(0L, solution.maximumScore(grid))
    }
}
