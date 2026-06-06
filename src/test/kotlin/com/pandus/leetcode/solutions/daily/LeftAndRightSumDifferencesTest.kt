package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class LeftAndRightSumDifferencesTest {
    private val solution = LeftAndRightSumDifferences()

    @Test
    fun `should return correct differences for nums 10,4,8,3`() {
        val result = solution.leftRightDifference(intArrayOf(10, 4, 8, 3))
        assertArrayEquals(intArrayOf(15, 1, 11, 22), result)
    }

    @Test
    fun `should return zero for single element array`() {
        val result = solution.leftRightDifference(intArrayOf(1))
        assertArrayEquals(intArrayOf(0), result)
    }
}
