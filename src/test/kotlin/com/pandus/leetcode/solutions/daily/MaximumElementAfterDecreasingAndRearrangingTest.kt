package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumElementAfterDecreasingAndRearrangingTest {

    private val solution = MaximumElementAfterDecreasingAndRearranging()

    @Test
    fun maximumElementAfterDecrementingAndRearranging_example1_returns2() {
        val result = solution.maximumElementAfterDecrementingAndRearranging(intArrayOf(2, 2, 1, 2, 1))
        assertEquals(2, result)
    }

    @Test
    fun maximumElementAfterDecrementingAndRearranging_example2_returns3() {
        val result = solution.maximumElementAfterDecrementingAndRearranging(intArrayOf(100, 1, 1000))
        assertEquals(3, result)
    }

    @Test
    fun maximumElementAfterDecrementingAndRearranging_example3_returns5() {
        val result = solution.maximumElementAfterDecrementingAndRearranging(intArrayOf(1, 2, 3, 4, 5))
        assertEquals(5, result)
    }
}
