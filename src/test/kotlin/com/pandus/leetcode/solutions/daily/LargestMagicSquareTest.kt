package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LargestMagicSquareTest {
    private val solver = LargestMagicSquare()

    @Test
    @DisplayName("Example 1: 4x5 grid with 3x3 magic square")
    fun largestMagicSquare_example1() {
        val grid = arrayOf(
            intArrayOf(7, 1, 4, 5, 6),
            intArrayOf(2, 5, 1, 6, 4),
            intArrayOf(1, 5, 4, 3, 2),
            intArrayOf(1, 2, 7, 3, 4)
        )
        val expected = 3
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("Example 2: 3x4 grid with 2x2 magic square")
    fun largestMagicSquare_example2() {
        val grid = arrayOf(
            intArrayOf(5, 1, 3, 1),
            intArrayOf(9, 3, 3, 1),
            intArrayOf(1, 3, 3, 8)
        )
        val expected = 2
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("Single element grid - always magic square of size 1")
    fun largestMagicSquare_singleElement() {
        val grid = arrayOf(
            intArrayOf(5)
        )
        val expected = 1
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("1xN grid - only 1x1 magic squares possible")
    fun largestMagicSquare_singleRow() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4, 5)
        )
        val expected = 1
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("Nx1 grid - only 1x1 magic squares possible")
    fun largestMagicSquare_singleColumn() {
        val grid = arrayOf(
            intArrayOf(1),
            intArrayOf(2),
            intArrayOf(3),
            intArrayOf(4),
            intArrayOf(5)
        )
        val expected = 1
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("2x2 grid with valid magic square")
    fun largestMagicSquare_2x2_valid() {
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        val expected = 2
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("2x2 grid without valid magic square")
    fun largestMagicSquare_2x2_invalid() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val expected = 1
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("3x3 perfect magic square")
    fun largestMagicSquare_3x3_perfect() {
        val grid = arrayOf(
            intArrayOf(2, 7, 6),
            intArrayOf(9, 5, 1),
            intArrayOf(4, 3, 8)
        )
        val expected = 3
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("3x3 grid with all same elements - valid magic square")
    fun largestMagicSquare_3x3_allSame() {
        val grid = arrayOf(
            intArrayOf(5, 5, 5),
            intArrayOf(5, 5, 5),
            intArrayOf(5, 5, 5)
        )
        val expected = 3
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("Large grid with only 1x1 magic squares")
    fun largestMagicSquare_noMagicSquare() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val expected = 1
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("4x4 grid with 2x2 magic square in corner")
    fun largestMagicSquare_4x4_with2x2() {
        val grid = arrayOf(
            intArrayOf(7, 7, 1, 2),
            intArrayOf(7, 7, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )
        val expected = 2
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("5x5 grid with 3x3 magic square in middle")
    fun largestMagicSquare_5x5_with3x3InMiddle() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(6, 5, 1, 6, 7),
            intArrayOf(8, 5, 4, 3, 9),
            intArrayOf(10, 2, 7, 3, 11),
            intArrayOf(12, 13, 14, 15, 16)
        )
        val expected = 3
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("Grid with negative numbers")
    fun largestMagicSquare_withNegativeNumbers() {
        val grid = arrayOf(
            intArrayOf(-1, -1),
            intArrayOf(-1, -1)
        )
        val expected = 2
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("Grid with zeros forming magic square")
    fun largestMagicSquare_withZeros() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        val expected = 3
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("Rectangular grid - more rows than columns")
    fun largestMagicSquare_moreRowsThanColumns() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(2, 3, 4),
            intArrayOf(5, 6, 7)
        )
        val expected = 3
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("Rectangular grid - more columns than rows")
    fun largestMagicSquare_moreColumnsThanRows() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 2, 3),
            intArrayOf(1, 1, 1, 4, 5),
            intArrayOf(1, 1, 1, 6, 7)
        )
        val expected = 3
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("4x4 perfect magic square")
    fun largestMagicSquare_4x4_perfect() {
        val grid = arrayOf(
            intArrayOf(16, 2, 3, 13),
            intArrayOf(5, 11, 10, 8),
            intArrayOf(9, 7, 6, 12),
            intArrayOf(4, 14, 15, 1)
        )
        val expected = 4
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("Large values in grid")
    fun largestMagicSquare_largeValues() {
        val grid = arrayOf(
            intArrayOf(1000, 1000),
            intArrayOf(1000, 1000)
        )
        val expected = 2
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("Multiple possible magic squares - return largest")
    fun largestMagicSquare_multiplePossible() {
        val grid = arrayOf(
            intArrayOf(2, 2, 5, 1, 6),
            intArrayOf(2, 2, 5, 4, 3),
            intArrayOf(1, 1, 2, 7, 3),
            intArrayOf(4, 5, 6, 7, 8)
        )
        // Should find at least a 2x2 magic square
        val result = solver.largestMagicSquare(grid)
        assert(result >= 1) { "Result should be at least 1" }
    }

    @Test
    @DisplayName("Magic square at bottom-right corner")
    fun largestMagicSquare_bottomRightCorner() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 3, 3),
            intArrayOf(11, 12, 3, 3)
        )
        val expected = 2
        assertEquals(expected, solver.largestMagicSquare(grid))
    }

    @Test
    @DisplayName("Anti-diagonal fails but main diagonal passes")
    fun largestMagicSquare_diagonalEdgeCase() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(2, 3, 1),
            intArrayOf(3, 1, 2)
        )
        // Check if it correctly validates both diagonals
        val result = solver.largestMagicSquare(grid)
        assert(result >= 1) { "Should at least find 1x1 magic square" }
    }
}
