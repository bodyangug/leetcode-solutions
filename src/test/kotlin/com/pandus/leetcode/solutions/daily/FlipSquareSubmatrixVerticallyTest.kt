package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FlipSquareSubmatrixVerticallyTest {
    private val solution = FlipSquareSubmatrixVertically()

    @Test
    @DisplayName("Example 1: 4x4 grid, x=1, y=0, k=3 -> rows of submatrix reversed vertically")
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        val expected = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(13, 14, 15, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(5, 6, 7, 16)
        )
        assertArrayEquals(expected, solution.reverseSubmatrix(grid, 1, 0, 3))
    }

    @Test
    @DisplayName("Example 2: 2x4 grid, x=0, y=2, k=2 -> columns 2-3 rows reversed")
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(3, 4, 2, 3),
            intArrayOf(2, 3, 4, 2)
        )
        val expected = arrayOf(
            intArrayOf(3, 4, 4, 2),
            intArrayOf(2, 3, 2, 3)
        )
        assertArrayEquals(expected, solution.reverseSubmatrix(grid, 0, 2, 2))
    }

    @Test
    @DisplayName("k=1: single cell submatrix, no rows to swap -> grid unchanged")
    fun testKEquals1() {
        val grid = arrayOf(
            intArrayOf(7, 8),
            intArrayOf(9, 10)
        )
        val expected = arrayOf(
            intArrayOf(7, 8),
            intArrayOf(9, 10)
        )
        assertArrayEquals(expected, solution.reverseSubmatrix(grid, 0, 0, 1))
    }

    @Test
    @DisplayName("Submatrix covers entire grid: 3x3 at x=0, y=0, k=3")
    fun testFullGridSubmatrix() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val expected = arrayOf(
            intArrayOf(7, 8, 9),
            intArrayOf(4, 5, 6),
            intArrayOf(1, 2, 3)
        )
        assertArrayEquals(expected, solution.reverseSubmatrix(grid, 0, 0, 3))
    }

    @Test
    @DisplayName("Submatrix at top-right corner: 4x4 grid, x=0, y=2, k=2")
    fun testTopRightCorner() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        val expected = arrayOf(
            intArrayOf(1, 2, 7, 8),
            intArrayOf(5, 6, 3, 4),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        assertArrayEquals(expected, solution.reverseSubmatrix(grid, 0, 2, 2))
    }

    @Test
    @DisplayName("Even k=4: submatrix covers full 4x4 grid")
    fun testEvenKFullGrid() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 15, 16)
        )
        val expected = arrayOf(
            intArrayOf(13, 14, 15, 16),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(1, 2, 3, 4)
        )
        assertArrayEquals(expected, solution.reverseSubmatrix(grid, 0, 0, 4))
    }
}
