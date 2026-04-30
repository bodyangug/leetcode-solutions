package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumPathScoreInGridTest {
    private val solution = MaximumPathScoreInGrid()

    @Test
    fun `test example 1 - grid with zero cost path`() {
        val grid = arrayOf(intArrayOf(0, 1), intArrayOf(2, 0))
        assertEquals(2, solution.maxPathScore(grid, 1))
    }

    @Test
    fun `test example 2 - no valid path returns -1`() {
        val grid = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(-1, solution.maxPathScore(grid, 1))
    }

    @Test
    fun `test single cell grid`() {
        val grid = arrayOf(intArrayOf(0))
        assertEquals(0, solution.maxPathScore(grid, 0))
    }

    @Test
    fun `test large k allows all paths`() {
        val grid = arrayOf(intArrayOf(0, 1), intArrayOf(1, 2))
        assertEquals(3, solution.maxPathScore(grid, 3))
    }

    @Test
    fun `test all zeros grid`() {
        val grid = arrayOf(intArrayOf(0, 0), intArrayOf(0, 0))
        assertEquals(0, solution.maxPathScore(grid, 0))
    }
}
