package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalSubarrayValueIITest {
    private val solution = MaximumTotalSubarrayValueII()

    @Test
    fun `example 1`() {
        val nums = intArrayOf(1, 3, 2)
        val k = 2
        assertEquals(4L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `example 2`() {
        val nums = intArrayOf(4, 2, 5, 1)
        val k = 3
        assertEquals(12L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `single element array yields zero`() {
        val nums = intArrayOf(7)
        val k = 5
        assertEquals(0L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `all equal elements yield zero`() {
        val nums = intArrayOf(4, 4, 4, 4)
        val k = 10
        assertEquals(0L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `k equals one picks full range difference`() {
        val nums = intArrayOf(10, 1, 5, 8)
        val k = 1
        assertEquals(9L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `k exceeds distinct subarrays stops when heap empty`() {
        // Distinct subarrays of [2,9]: [2,9]=7, [2]=0, [9]=0 -> sum = 7.
        val nums = intArrayOf(2, 9)
        val k = 4
        assertEquals(7L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `negative numbers handled`() {
        // Top-2 distinct subarray values are 13 and 13.
        val nums = intArrayOf(-5, -1, -10, 3)
        val k = 2
        assertEquals(26L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `large values stay within long range`() {
        // Only 3 distinct subarrays exist; best is 999_999_999.
        val nums = intArrayOf(1, 1_000_000_000)
        val k = 100_000
        assertEquals(999_999_999L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `min and max at array boundaries`() {
        // Top-3 values: 99, 75, 75.
        val nums = intArrayOf(1, 50, 25, 100)
        val k = 3
        assertEquals(249L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `descending array`() {
        // Top-6 values: 8, 6, 6, 4, 4, 4.
        val nums = intArrayOf(9, 7, 5, 3, 1)
        val k = 6
        assertEquals(32L, solution.maxTotalValue(nums, k))
    }
}
