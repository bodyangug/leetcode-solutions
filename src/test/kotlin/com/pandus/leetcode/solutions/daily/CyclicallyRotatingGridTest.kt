package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CyclicallyRotatingGridTest {
    private val solution = CyclicallyRotatingGrid()

    @Test
    fun `example 1 - 2x2 grid with k=1`() {
        val grid = arrayOf(intArrayOf(40, 10), intArrayOf(30, 20))
        val expected = arrayOf(intArrayOf(10, 20), intArrayOf(40, 30))
        val result = solution.rotateGrid(grid, 1)
        result.forEachIndexed { i, row -> assertArrayEquals(expected[i], row) }
    }

    @Test
    fun `example 2 - 4x4 grid with k=2`() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        val expected = arrayOf(
            intArrayOf(3, 4, 8, 12),
            intArrayOf(2, 11, 10, 16),
            intArrayOf(1, 7, 6, 15),
            intArrayOf(5, 9, 13, 14)
        )
        val result = solution.rotateGrid(grid, 2)
        result.forEachIndexed { i, row -> assertArrayEquals(expected[i], row) }
    }
}
