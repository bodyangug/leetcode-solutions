package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTotalSubarrayValueITest {
    private val solution = MaximumTotalSubarrayValueI()

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
    fun `k equals one`() {
        val nums = intArrayOf(10, 1, 5, 8)
        val k = 1
        assertEquals(9L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `two elements`() {
        val nums = intArrayOf(2, 9)
        val k = 4
        assertEquals(28L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `negative numbers handled`() {
        val nums = intArrayOf(-5, -1, -10, 3)
        val k = 2
        assertEquals(26L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `large k stays within long range`() {
        val nums = intArrayOf(1, 1_000_000_000)
        val k = 100_000
        assertEquals(99_999_999_900_000L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `min and max at array boundaries`() {
        val nums = intArrayOf(1, 50, 25, 100)
        val k = 3
        assertEquals(297L, solution.maxTotalValue(nums, k))
    }

    @Test
    fun `descending array`() {
        val nums = intArrayOf(9, 7, 5, 3, 1)
        val k = 6
        assertEquals(48L, solution.maxTotalValue(nums, k))
    }
}
