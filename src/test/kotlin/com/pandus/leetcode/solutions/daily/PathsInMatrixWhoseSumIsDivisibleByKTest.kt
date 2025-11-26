package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PathsInMatrixWhoseSumIsDivisibleByKTest {

    private val solution = PathsInMatrixWhoseSumIsDivisibleByK()

    @Test
    @DisplayName("Example 1: 3x3 grid with k=3 should return 2")
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(5, 2, 4),
            intArrayOf(3, 0, 5),
            intArrayOf(0, 7, 2)
        )
        val k = 3
        val result = solution.numberOfPaths(grid, k)
        assertEquals(2, result, "There are 2 paths with sum divisible by 3")
    }

    @Test
    @DisplayName("Example 2: 3x2 grid with k=5 should return 2")
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(0, 0)
        )
        val k = 5
        val result = solution.numberOfPaths(grid, k)
        assertEquals(1, result, "One path from (0,0) to (0,1) with sum divisible by 5")
    }

    @Test
    @DisplayName("Single cell grid with value divisible by k")
    fun testSingleCellDivisible() {
        val grid = arrayOf(
            intArrayOf(6)
        )
        val k = 3
        val result = solution.numberOfPaths(grid, k)
        assertEquals(1, result, "Single cell with value divisible by k returns 1")
    }

    @Test
    @DisplayName("Single cell grid with value not divisible by k")
    fun testSingleCellNotDivisible() {
        val grid = arrayOf(
            intArrayOf(7)
        )
        val k = 3
        val result = solution.numberOfPaths(grid, k)
        assertEquals(0, result, "Single cell with value not divisible by k returns 0")
    }

    @Test
    @DisplayName("1xN grid (single row)")
    fun testSingleRow() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4, 5)
        )
        val k = 5
        val result = solution.numberOfPaths(grid, k)
        assertEquals(1, result, "Single row with sum 15 divisible by 5")
    }

    @Test
    @DisplayName("Nx1 grid (single column)")
    fun testSingleColumn() {
        val grid = arrayOf(
            intArrayOf(2),
            intArrayOf(3),
            intArrayOf(4),
            intArrayOf(6)
        )
        val k = 5
        val result = solution.numberOfPaths(grid, k)
        assertEquals(1, result, "Single column with sum 15 divisible by 5")
    }

    @Test
    @DisplayName("2x2 grid with all zeros and k=1")
    fun testAllZeros() {
        val grid = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        val k = 1
        val result = solution.numberOfPaths(grid, k)
        assertEquals(2, result, "All zeros grid, all paths have sum 0 divisible by any k")
    }

    @Test
    @DisplayName("2x2 grid with no valid paths")
    fun testNoValidPaths() {
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        val k = 5
        val result = solution.numberOfPaths(grid, k)
        assertEquals(0, result, "No path with sum divisible by 5 (all paths sum to 4)")
    }

    @Test
    @DisplayName("Large k value (k=50)")
    fun testLargeK() {
        val grid = arrayOf(
            intArrayOf(10, 20, 30),
            intArrayOf(15, 25, 35),
            intArrayOf(5, 15, 25)
        )
        val k = 50
        val result = solution.numberOfPaths(grid, k)
        // Expected: paths that sum to multiples of 50
        assertEquals(0, result, "Testing with large k value")
    }

    @Test
    @DisplayName("Grid with k=1 should return all possible paths")
    fun testKEqualsOne() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val k = 1
        val result = solution.numberOfPaths(grid, k)
        assertEquals(2, result, "With k=1, all paths should be divisible by 1")
    }

    @Test
    @DisplayName("Grid with large values and k=7")
    fun testLargeValues() {
        val grid = arrayOf(
            intArrayOf(7, 14, 21),
            intArrayOf(28, 35, 42)
        )
        val k = 7
        val result = solution.numberOfPaths(grid, k)
        assertEquals(3, result, "All values divisible by 7")
    }

    @Test
    @DisplayName("3x3 grid with mixed values and k=2")
    fun testMixedValues() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        val k = 2
        val result = solution.numberOfPaths(grid, k)
        // Path length is always (m-1) + (n-1) + 1 = m + n - 1
        // For 3x3, path sum is always 5 (odd), never divisible by 2
        assertEquals(0, result, "All paths sum to 5, not divisible by 2")
    }

    @Test
    @DisplayName("Grid with maximum value constraint (m=100)")
    fun testMaxValue() {
        val grid = arrayOf(
            intArrayOf(100, 100),
            intArrayOf(100, 100)
        )
        val k = 50
        val result = solution.numberOfPaths(grid, k)
        // Sum paths: 400, divisible by 50
        assertEquals(2, result, "All paths sum to 400, divisible by 50")
    }

    @Test
    @DisplayName("Edge case: k equals grid starting value")
    fun testKEqualsStartValue() {
        val grid = arrayOf(
            intArrayOf(5, 0),
            intArrayOf(0, 0)
        )
        val k = 5
        val result = solution.numberOfPaths(grid, k)
        assertEquals(2, result, "All paths from (0,0) with value 5")
    }
}
