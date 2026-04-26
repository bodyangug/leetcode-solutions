package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeDistanceBetweenPointsOnSquareTest {
    private val solution = MaximizeDistanceBetweenPointsOnSquare()

    @Test
    fun `test example 1 - all four corners`() {
        val result =
            solution.maxDistance(2, arrayOf(intArrayOf(0, 2), intArrayOf(2, 0), intArrayOf(2, 2), intArrayOf(0, 0)), 4)
        assertEquals(2, result)
    }

    @Test
    fun `test example 2 - four points on square side 2`() {
        val result = solution.maxDistance(
            2,
            arrayOf(intArrayOf(0, 0), intArrayOf(1, 2), intArrayOf(2, 0), intArrayOf(2, 2), intArrayOf(2, 1)),
            4
        )
        assertEquals(1, result)
    }

    @Test
    fun `test example 3 - five points on square side 2`() {
        val result = solution.maxDistance(
            2,
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(0, 1),
                intArrayOf(0, 2),
                intArrayOf(1, 2),
                intArrayOf(2, 0),
                intArrayOf(2, 2),
                intArrayOf(2, 1)
            ),
            5
        )
        assertEquals(1, result)
    }
}
