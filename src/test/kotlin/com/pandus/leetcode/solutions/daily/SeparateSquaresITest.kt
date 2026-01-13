package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.math.abs

class SeparateSquaresITest {
    private val solution = SeparateSquaresI()

    private fun assertDoubleEquals(expected: Double, actual: Double, delta: Double = 1e-5) {
        assertTrue(
            abs(expected - actual) < delta,
            "Expected $expected but got $actual (difference: ${abs(expected - actual)})"
        )
    }

    @Test
    fun `test single square`() {
        val squares = arrayOf(intArrayOf(0, 0, 4))
        val result = solution.separateSquares(squares)
        // Total area = 16, half = 8
        // Area below y = width * height = 4 * 2 = 8
        assertDoubleEquals(2.0, result)
    }

    @Test
    fun `test two non-overlapping squares vertically`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 2), // Area = 4, from y=0 to y=2
            intArrayOf(0, 2, 2) // Area = 4, from y=2 to y=4
        )
        val result = solution.separateSquares(squares)
        // Total area = 8, half = 4
        // At y=2: area below = 4
        assertDoubleEquals(2.0, result)
    }

    @Test
    fun `test squares at same y level`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 2),
            intArrayOf(3, 0, 2)
        )
        val result = solution.separateSquares(squares)
        // Total area = 8, half = 4
        // Both squares same height, divide at y=1
        assertDoubleEquals(1.0, result)
    }

    @Test
    fun `test one tall square`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 10)
        )
        val result = solution.separateSquares(squares)
        // Total area = 100, half = 50
        // Area = width * height = 10 * h = 50, h = 5
        assertDoubleEquals(5.0, result)
    }

    @Test
    fun `test edge case with single unit square`() {
        val squares = arrayOf(intArrayOf(5, 3, 1))
        val result = solution.separateSquares(squares)
        // Total area = 1, half = 0.5
        // Divide at y = 3.5
        assertDoubleEquals(3.5, result)
    }

    @Test
    fun `test squares with gap`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 2), // y: 0-2, area=4
            intArrayOf(0, 5, 2) // y: 5-7, area=4
        )
        val result = solution.separateSquares(squares)
        // Total area = 8, half = 4
        // First square gives exactly 4, so y=2
        assertDoubleEquals(2.0, result)
    }

    @Test
    fun `test perfect split at boundary`() {
        val squares = arrayOf(
            intArrayOf(0, 0, 4),
            intArrayOf(0, 4, 4)
        )
        val result = solution.separateSquares(squares)
        // Total area = 32, half = 16
        // At y=4: first square completely below (16)
        assertDoubleEquals(4.0, result)
    }

    @Test
    fun `test empty array`() {
        val squares = arrayOf<IntArray>()
        val result = solution.separateSquares(squares)
        assertDoubleEquals(0.0, result)
    }
}
