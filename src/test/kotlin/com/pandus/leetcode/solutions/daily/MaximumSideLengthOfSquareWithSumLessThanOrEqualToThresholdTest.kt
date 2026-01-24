package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSideLengthOfSquareWithSumLessThanOrEqualToThresholdTest {
    private val solution = MaximumSideLengthOfSquareWithSumLessThanOrEqualToThreshold()

    @Test
    fun `example 1 - returns 2 for 3x7 matrix with threshold 4`() {
        val mat = arrayOf(
            intArrayOf(1, 1, 3, 2, 4, 3, 2),
            intArrayOf(1, 1, 3, 2, 4, 3, 2),
            intArrayOf(1, 1, 3, 2, 4, 3, 2)
        )
        val threshold = 4

        val result = solution.maxSideLength(mat, threshold)

        assertEquals(2, result)
    }

    @Test
    fun `example 2 - returns 0 for 5x5 matrix with threshold 1`() {
        val mat = arrayOf(
            intArrayOf(2, 2, 2, 2, 2),
            intArrayOf(2, 2, 2, 2, 2),
            intArrayOf(2, 2, 2, 2, 2),
            intArrayOf(2, 2, 2, 2, 2),
            intArrayOf(2, 2, 2, 2, 2)
        )
        val threshold = 1

        val result = solution.maxSideLength(mat, threshold)

        assertEquals(0, result)
    }

    @Test
    fun `single cell matrix within threshold`() {
        val mat = arrayOf(intArrayOf(1))
        val threshold = 1

        val result = solution.maxSideLength(mat, threshold)

        assertEquals(1, result)
    }

    @Test
    fun `single cell matrix exceeds threshold`() {
        val mat = arrayOf(intArrayOf(5))
        val threshold = 3

        val result = solution.maxSideLength(mat, threshold)

        assertEquals(0, result)
    }

    @Test
    fun `2x2 matrix with all cells within threshold`() {
        val mat = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        val threshold = 4

        val result = solution.maxSideLength(mat, threshold)

        assertEquals(2, result)
    }

    @Test
    fun `3x3 matrix with maximum square of size 2`() {
        val mat = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        val threshold = 4

        val result = solution.maxSideLength(mat, threshold)

        assertEquals(2, result)
    }

    @Test
    fun `large threshold covers entire matrix`() {
        val mat = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        val threshold = 100

        val result = solution.maxSideLength(mat, threshold)

        assertEquals(3, result)
    }

    @Test
    fun `rectangular matrix where width is less than height`() {
        val mat = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        val threshold = 4

        val result = solution.maxSideLength(mat, threshold)

        assertEquals(2, result)
    }

    @Test
    fun `rectangular matrix where height is less than width`() {
        val mat = arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1)
        )
        val threshold = 4

        val result = solution.maxSideLength(mat, threshold)

        assertEquals(2, result)
    }

    @Test
    fun `matrix with varying values - square found in corner`() {
        val mat = arrayOf(
            intArrayOf(1, 1, 5, 5),
            intArrayOf(1, 1, 5, 5),
            intArrayOf(5, 5, 5, 5),
            intArrayOf(5, 5, 5, 5)
        )
        val threshold = 4

        val result = solution.maxSideLength(mat, threshold)

        assertEquals(2, result)
    }

    @Test
    fun `zero threshold with all positive values`() {
        val mat = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        val threshold = 0

        val result = solution.maxSideLength(mat, threshold)

        assertEquals(0, result)
    }

    @Test
    fun `threshold equals to single cell value`() {
        val mat = arrayOf(
            intArrayOf(3, 3, 3),
            intArrayOf(3, 3, 3),
            intArrayOf(3, 3, 3)
        )
        val threshold = 3

        val result = solution.maxSideLength(mat, threshold)

        assertEquals(1, result)
    }
}
