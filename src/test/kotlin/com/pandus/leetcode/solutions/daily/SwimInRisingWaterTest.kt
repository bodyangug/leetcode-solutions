package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SwimInRisingWaterTest {
    private val solution = SwimInRisingWater()

    @Test
    fun `should return 3 for basic 2x2 grid`() {
        val grid = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(1, 3)
        )
        assertEquals(3, solution.swimInWater(grid))
    }

    @Test
    fun `should return 16 for complex 3x3 grid`() {
        val grid = arrayOf(
            intArrayOf(0, 1, 2, 3, 4),
            intArrayOf(24, 23, 22, 21, 5),
            intArrayOf(12, 13, 14, 15, 16),
            intArrayOf(11, 17, 18, 19, 20),
            intArrayOf(10, 9, 8, 7, 6)
        )
        assertEquals(16, solution.swimInWater(grid))
    }

    @Test
    fun `should return 0 for single cell grid`() {
        val grid = arrayOf(
            intArrayOf(0)
        )
        assertEquals(0, solution.swimInWater(grid))
    }

    @Test
    fun `should return 5 for single cell with height 5`() {
        val grid = arrayOf(
            intArrayOf(5)
        )
        assertEquals(5, solution.swimInWater(grid))
    }

    @Test
    fun `should return 2 for 2x2 grid with alternative path`() {
        val grid = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(2, 3)
        )
        assertEquals(3, solution.swimInWater(grid))
    }

    @Test
    fun `should return maximum height when forced to traverse high cells`() {
        val grid = arrayOf(
            intArrayOf(0, 10),
            intArrayOf(1, 2)
        )
        assertEquals(2, solution.swimInWater(grid))
    }

    @Test
    fun `should handle 3x3 grid with ascending values`() {
        val grid = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 8)
        )
        assertEquals(8, solution.swimInWater(grid))
    }

    @Test
    fun `should handle grid where optimal path requires waiting`() {
        val grid = arrayOf(
            intArrayOf(0, 100, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 0)
        )
        assertEquals(1, solution.swimInWater(grid))
    }

    @Test
    fun `should handle larger grid with mixed heights`() {
        val grid = arrayOf(
            intArrayOf(0, 10, 10, 10),
            intArrayOf(10, 1, 2, 10),
            intArrayOf(10, 3, 4, 10),
            intArrayOf(10, 10, 10, 5)
        )
        assertEquals(10, solution.swimInWater(grid))
    }

    @Test
    fun `should handle grid with same heights`() {
        val grid = arrayOf(
            intArrayOf(5, 5, 5),
            intArrayOf(5, 5, 5),
            intArrayOf(5, 5, 5)
        )
        assertEquals(5, solution.swimInWater(grid))
    }
}
