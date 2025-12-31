package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LastDayWhereYouCanStillCrossTest {
    private val solution = LastDayWhereYouCanStillCross()

    @Test
    @DisplayName("Example 1: 2x2 grid with diagonal fill pattern")
    fun testExample1() {
        // Given
        val row = 2
        val col = 2
        val cells = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 2)
        )

        // When
        val result = solution.latestDayToCross(row, col, cells)

        // Then
        assertEquals(2, result, "Should be able to cross until day 2")
    }

    @Test
    @DisplayName("Example 2: 2x2 grid with top row filled first")
    fun testExample2() {
        // Given
        val row = 2
        val col = 2
        val cells = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(2, 2)
        )

        // When
        val result = solution.latestDayToCross(row, col, cells)

        // Then
        assertEquals(1, result, "Should be able to cross until day 1")
    }

    @Test
    @DisplayName("Example 3: 3x3 grid with scattered fill pattern")
    fun testExample3() {
        // Given
        val row = 3
        val col = 3
        val cells = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 1),
            intArrayOf(3, 3),
            intArrayOf(2, 2),
            intArrayOf(1, 1),
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(3, 2),
            intArrayOf(3, 1)
        )

        // When
        val result = solution.latestDayToCross(row, col, cells)

        // Then
        assertEquals(3, result, "Should be able to cross until day 3")
    }

    @Test
    @DisplayName("Edge case: 1x1 grid")
    fun testSingleCell() {
        // Given
        val row = 1
        val col = 1
        val cells = arrayOf(intArrayOf(1, 1))

        // When
        val result = solution.latestDayToCross(row, col, cells)

        // Then
        assertEquals(0, result, "Cannot cross a 1x1 grid once the single cell is filled")
    }

    @Test
    @DisplayName("Edge case: Single column grid")
    fun testSingleColumn() {
        // Given
        val row = 3
        val col = 1
        val cells = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(3, 1)
        )

        // When
        val result = solution.latestDayToCross(row, col, cells)

        // Then
        assertEquals(0, result, "Cannot cross once any cell in single column is filled")
    }

    @Test
    @DisplayName("Edge case: All cells filled on last day")
    fun testAllCellsFilled() {
        // Given
        val row = 2
        val col = 3
        val cells = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(1, 1),
            intArrayOf(2, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 2)
        )

        // When
        val result = solution.latestDayToCross(row, col, cells)

        // Then
        assertEquals(4, result, "Should be able to cross through middle column until day 4")
    }

    @Test
    @DisplayName("Path through corners: zigzag pattern")
    fun testZigzagPath() {
        // Given
        val row = 3
        val col = 4
        val cells = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 2),
            intArrayOf(1, 1),
            intArrayOf(2, 2),
            intArrayOf(3, 3),
            intArrayOf(1, 3),
            intArrayOf(2, 1),
            intArrayOf(3, 1),
            intArrayOf(1, 4),
            intArrayOf(2, 4),
            intArrayOf(3, 4)
        )

        // When
        val result = solution.latestDayToCross(row, col, cells)

        // Then
        assertEquals(9, result, "Should navigate zigzag path until day 9")
    }
}
