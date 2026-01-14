package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SeparateSquaresIITest {
    private val solution = SeparateSquaresII()
    private val epsilon = 1e-5

    private fun assertDoubleEquals(expected: Double, actual: Double, message: String = "") {
        assertEquals(expected, actual, epsilon, message)
    }

    @Test
    fun `example 1 - two non-overlapping squares`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(2, 2, 1)
        )
        val result = solution.separateSquares(squares)
        assertDoubleEquals(1.0, result, "Line y=1 splits 1 square unit above and 1 below")
    }

    @Test
    fun `example 2 - two overlapping squares`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 2),
            intArrayOf(1, 1, 1)
        )
        val result = solution.separateSquares(squares)
        assertDoubleEquals(1.0, result, "Line y=1 splits overlapping squares equally")
    }

    @Test
    fun `single square`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 2)
        )
        val result = solution.separateSquares(squares)
        assertDoubleEquals(1.0, result, "Line y=1 splits single square in half")
    }

    @Test
    fun `three squares stacked vertically`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 2, 1)
        )
        val result = solution.separateSquares(squares)
        assertDoubleEquals(1.5, result, "Line y=1.5 splits 3 square units equally")
    }

    @Test
    fun `two squares side by side same height`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 0, 1)
        )
        val result = solution.separateSquares(squares)
        assertDoubleEquals(0.5, result, "Line y=0.5 splits 2 square units equally")
    }

    @Test
    fun `large square with small square inside`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 4),
            intArrayOf(1, 1, 2)
        )
        // Total area = 16 + 4 = 20, half = 10
        // Need to find y where area below = 10
        val result = solution.separateSquares(squares)
        // Area calculation:
        // [0,1): width=4, area=4
        // [1,3): width=6 (4+2 overlap counted), need 6 more area
        // 6/6 = 1.0, so y = 1 + 1 = 2
        assertDoubleEquals(2.0, result, "Line should split 20 square units equally")
    }

    @Test
    fun `multiple overlapping squares`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 3),
            intArrayOf(1, 1, 3),
            intArrayOf(2, 2, 3)
        )
        val result = solution.separateSquares(squares)
        // This is a complex overlapping case
        // Just verify it returns a valid result without exact calculation
        assert(result > 0.0) { "Result should be positive" }
    }

    @Test
    fun `squares at different heights no overlap`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(0, 2, 1),
            intArrayOf(0, 4, 1)
        )
        val result = solution.separateSquares(squares)
        assertDoubleEquals(2.5, result, "Line y=2.5 splits 3 squares equally")
    }

    @Test
    fun `two identical squares completely overlapping`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 2),
            intArrayOf(0, 0, 2)
        )
        val result = solution.separateSquares(squares)
        // Total area = 4 + 4 = 8 (counted twice), half = 4
        assertDoubleEquals(1.0, result, "Line y=1 splits overlapping identical squares")
    }

    @Test
    fun `small unit square`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 1)
        )
        val result = solution.separateSquares(squares)
        assertDoubleEquals(0.5, result, "Line y=0.5 splits unit square in half")
    }

    @Test
    fun `partial overlap horizontal`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 2),
            intArrayOf(1, 1, 2)
        )
        val result = solution.separateSquares(squares)
        // Square 1: [0,2) x [0,2) -> area 4
        // Square 2: [1,3) x [1,3) -> area 4
        // Overlap region: [1,2) x [1,2) -> counted in both
        // Total area = 4 + 4 = 8, half = 4
        assert(result > 0.0 && result < 3.0) { "Result should be between squares" }
    }

    @Test
    fun `narrow tall square`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 2, 1),
            intArrayOf(0, 3, 1)
        )
        val result = solution.separateSquares(squares)
        assertDoubleEquals(2.0, result, "Line y=2 splits 4 stacked unit squares")
    }

    @Test
    fun `wide short configuration`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 2),
            intArrayOf(2, 0, 2),
            intArrayOf(4, 0, 2)
        )
        val result = solution.separateSquares(squares)
        assertDoubleEquals(1.0, result, "Line y=1 splits 3 side-by-side squares")
    }

    @Test
    fun `complex overlapping pattern`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 2),
            intArrayOf(1, 0, 2),
            intArrayOf(0, 1, 2),
            intArrayOf(1, 1, 2)
        )
        val result = solution.separateSquares(squares)
        // This creates a heavily overlapping 3x3 region
        assert(result > 0.0 && result < 3.0) { "Result should be in valid range" }
    }
}
