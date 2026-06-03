package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EarliestFinishTimeForLandAndWaterRidesIITest {
    private val solution = EarliestFinishTimeForLandAndWaterRidesII()

    @Test
    fun `should return 9 for example 1`() {
        val result = solution.earliestFinishTime(
            landStartTime = intArrayOf(2, 8),
            landDuration = intArrayOf(4, 1),
            waterStartTime = intArrayOf(6),
            waterDuration = intArrayOf(3)
        )
        assertEquals(9, result)
    }

    @Test
    fun `should return 14 for example 2`() {
        val result = solution.earliestFinishTime(
            landStartTime = intArrayOf(5),
            landDuration = intArrayOf(3),
            waterStartTime = intArrayOf(1),
            waterDuration = intArrayOf(10)
        )
        assertEquals(14, result)
    }

    @Test
    fun `should handle case where water ride starts after land ride finishes`() {
        val result = solution.earliestFinishTime(
            landStartTime = intArrayOf(1),
            landDuration = intArrayOf(2),
            waterStartTime = intArrayOf(10),
            waterDuration = intArrayOf(3)
        )
        assertEquals(13, result)
    }

    @Test
    fun `should handle case where land ride starts after water ride finishes`() {
        val result = solution.earliestFinishTime(
            landStartTime = intArrayOf(10),
            landDuration = intArrayOf(3),
            waterStartTime = intArrayOf(1),
            waterDuration = intArrayOf(2)
        )
        assertEquals(13, result)
    }

    @Test
    fun `should handle single ride in each category with same start time`() {
        val result = solution.earliestFinishTime(
            landStartTime = intArrayOf(5),
            landDuration = intArrayOf(3),
            waterStartTime = intArrayOf(5),
            waterDuration = intArrayOf(3)
        )
        assertEquals(11, result)
    }
}
