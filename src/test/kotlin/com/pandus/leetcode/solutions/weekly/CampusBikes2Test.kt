package com.pandus.leetcode.solutions.weekly

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CampusBikes2Test {
    private val solution = CampusBikes2()

    @Test
    fun `should return minimum distance for workers and bikes`() {
        val workers = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(2, 1)
        )
        val bikes = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 3)
        )

        val result = solution.assignBikes(workers, bikes)

        assertEquals(6, result)
    }

    @Test
    fun `should return zero when there are no workers`() {
        val workers = arrayOf<IntArray>()
        val bikes = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 3)
        )

        val result = solution.assignBikes(workers, bikes)

        assertEquals(0, result)
    }
}
