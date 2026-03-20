package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MinimumAbsoluteDifferenceInSlidingSubmatrixTest {
    private val solution = MinimumAbsoluteDifferenceInSlidingSubmatrix()

    @Test
    fun `example 1 - 2x2 grid with k=2 returns single cell result`() {
        val grid = arrayOf(intArrayOf(1, 8), intArrayOf(3, -2))
        assertArrayEquals(arrayOf(intArrayOf(2)), solution.minAbsDiff(grid, 2))
    }

    @Test
    fun `example 2 - 1x2 grid with k=1 returns all zeros`() {
        val grid = arrayOf(intArrayOf(3, -1))
        assertArrayEquals(arrayOf(intArrayOf(0, 0)), solution.minAbsDiff(grid, 1))
    }

    @Test
    fun `example 3 - 2x3 grid with k=2 returns two cells`() {
        val grid = arrayOf(intArrayOf(1, -2, 3), intArrayOf(2, 3, 5))
        assertArrayEquals(arrayOf(intArrayOf(1, 2)), solution.minAbsDiff(grid, 2))
    }

    @Test
    fun `all same values returns zero for every cell`() {
        val grid = arrayOf(intArrayOf(5, 5), intArrayOf(5, 5))
        assertArrayEquals(arrayOf(intArrayOf(0)), solution.minAbsDiff(grid, 2))
    }

    @Test
    fun `k equals 1 always returns all zeros`() {
        val grid = arrayOf(intArrayOf(10, 20, 30), intArrayOf(40, 50, 60))
        val expected = arrayOf(intArrayOf(0, 0, 0), intArrayOf(0, 0, 0))
        assertArrayEquals(expected, solution.minAbsDiff(grid, 1))
    }

    @Test
    fun `k equals full grid size returns single cell`() {
        val grid = arrayOf(intArrayOf(1, 3), intArrayOf(6, 2))
        assertArrayEquals(arrayOf(intArrayOf(1)), solution.minAbsDiff(grid, 2))
    }

    @Test
    fun `negative values are handled correctly`() {
        val grid = arrayOf(intArrayOf(-5, -1), intArrayOf(-3, -2))
        assertArrayEquals(arrayOf(intArrayOf(1)), solution.minAbsDiff(grid, 2))
    }

    @Test
    fun `submatrix with adjacent duplicates skips them and finds correct diff`() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(2, 4))
        // distinct values: [1,2,4], min diff = |2-1| = 1
        assertArrayEquals(arrayOf(intArrayOf(1)), solution.minAbsDiff(grid, 2))
    }

    @Test
    fun `large spread values pick smallest difference`() {
        val grid = arrayOf(intArrayOf(1, 100), intArrayOf(50, 52))
        // sorted: [1, 50, 52, 100], min diff = |52-50| = 2
        assertArrayEquals(arrayOf(intArrayOf(2)), solution.minAbsDiff(grid, 2))
    }

    @Test
    fun `3x3 grid with k=2 produces 2x2 result`() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        // (0,0): [1,2,4,5] -> min=1; (0,1): [2,3,5,6] -> min=1
        // (1,0): [4,5,7,8] -> min=1; (1,1): [5,6,8,9] -> min=1
        val expected = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertArrayEquals(expected, solution.minAbsDiff(grid, 2))
    }
}
