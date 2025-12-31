package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountNegativeNumbersInSortedMatrixTest {
    private val solution = CountNegativeNumbersInSortedMatrix()

    @Test
    @DisplayName("Example 1: 4x4 matrix with 8 negative numbers")
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(4, 3, 2, -1),
            intArrayOf(3, 2, 1, -1),
            intArrayOf(1, 1, -1, -2),
            intArrayOf(-1, -1, -2, -3)
        )
        val result = solution.countNegatives(grid)
        assertEquals(8, result, "There are 8 negative numbers in the matrix")
    }

    @Test
    @DisplayName("Example 2: 2x2 matrix with 0 negative numbers")
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(3, 2),
            intArrayOf(1, 0)
        )
        val result = solution.countNegatives(grid)
        assertEquals(0, result, "There are no negative numbers in the matrix")
    }

    @Test
    @DisplayName("Single element matrix - negative")
    fun testSingleElementNegative() {
        val grid = arrayOf(
            intArrayOf(-1)
        )
        val result = solution.countNegatives(grid)
        assertEquals(1, result, "Single negative element should return 1")
    }

    @Test
    @DisplayName("Single element matrix - positive")
    fun testSingleElementPositive() {
        val grid = arrayOf(
            intArrayOf(5)
        )
        val result = solution.countNegatives(grid)
        assertEquals(0, result, "Single positive element should return 0")
    }

    @Test
    @DisplayName("Single element matrix - zero")
    fun testSingleElementZero() {
        val grid = arrayOf(
            intArrayOf(0)
        )
        val result = solution.countNegatives(grid)
        assertEquals(0, result, "Zero is not negative, should return 0")
    }

    @Test
    @DisplayName("All negative numbers")
    fun testAllNegative() {
        val grid = arrayOf(
            intArrayOf(-1, -2, -3),
            intArrayOf(-4, -5, -6),
            intArrayOf(-7, -8, -9)
        )
        val result = solution.countNegatives(grid)
        assertEquals(9, result, "All 9 elements are negative")
    }

    @Test
    @DisplayName("All positive numbers")
    fun testAllPositive() {
        val grid = arrayOf(
            intArrayOf(9, 8, 7),
            intArrayOf(6, 5, 4),
            intArrayOf(3, 2, 1)
        )
        val result = solution.countNegatives(grid)
        assertEquals(0, result, "No negative numbers in the matrix")
    }

    @Test
    @DisplayName("Single row with mixed values")
    fun testSingleRow() {
        val grid = arrayOf(
            intArrayOf(5, 3, 1, -1, -3, -5)
        )
        val result = solution.countNegatives(grid)
        assertEquals(3, result, "There are 3 negative numbers in the row")
    }

    @Test
    @DisplayName("Single column with mixed values")
    fun testSingleColumn() {
        val grid = arrayOf(
            intArrayOf(5),
            intArrayOf(3),
            intArrayOf(1),
            intArrayOf(-1),
            intArrayOf(-3)
        )
        val result = solution.countNegatives(grid)
        assertEquals(2, result, "There are 2 negative numbers in the column")
    }

    @Test
    @DisplayName("Matrix with zeros and negatives")
    fun testWithZeros() {
        val grid = arrayOf(
            intArrayOf(2, 1, 0),
            intArrayOf(0, 0, -1),
            intArrayOf(-1, -2, -3)
        )
        val result = solution.countNegatives(grid)
        assertEquals(4, result, "There are 4 negative numbers (zeros don't count)")
    }

    @Test
    @DisplayName("Rectangular matrix - more rows than columns")
    fun testRectangularMatrixMoreRows() {
        val grid = arrayOf(
            intArrayOf(3, 2),
            intArrayOf(1, 0),
            intArrayOf(-1, -2),
            intArrayOf(-3, -4)
        )
        val result = solution.countNegatives(grid)
        assertEquals(4, result, "There are 4 negative numbers in the 4x2 matrix")
    }

    @Test
    @DisplayName("Rectangular matrix - more columns than rows")
    fun testRectangularMatrixMoreColumns() {
        val grid = arrayOf(
            intArrayOf(5, 4, 3, 2, -1, -2),
            intArrayOf(1, 0, -1, -2, -3, -4)
        )
        val result = solution.countNegatives(grid)
        assertEquals(6, result, "There are 6 negative numbers in the 2x6 matrix")
    }

    @Test
    @DisplayName("First row all positive, last row all negative")
    fun testFirstRowPositiveLastRowNegative() {
        val grid = arrayOf(
            intArrayOf(10, 9, 8),
            intArrayOf(5, 4, 3),
            intArrayOf(-1, -2, -3)
        )
        val result = solution.countNegatives(grid)
        assertEquals(3, result, "Only the last row has negative numbers")
    }

    @Test
    @DisplayName("Negative numbers at the end of each row")
    fun testNegativesAtEndOfRows() {
        val grid = arrayOf(
            intArrayOf(5, 4, -1),
            intArrayOf(3, 2, -1),
            intArrayOf(1, 0, -1)
        )
        val result = solution.countNegatives(grid)
        assertEquals(3, result, "Each row has one negative number at the end")
    }
}
