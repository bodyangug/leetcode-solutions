package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AdjacentIncreasingSubarraysDetectionIITest {

    private val solution = AdjacentIncreasingSubarraysDetectionII()

    @Test
    fun `test basic increasing sequence split in half`() {
        val nums = listOf(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)
        val result = solution.maxIncreasingSubarrays(nums)
        assertEquals(3, result)
    }

    @Test
    fun `test two adjacent increasing sequences`() {
        val nums = listOf(1, 2, 3, 4, 4, 4, 4, 5, 6, 7)
        val result = solution.maxIncreasingSubarrays(nums)
        assertEquals(2, result)
    }

    @Test
    fun `test single element array`() {
        val nums = listOf(1)
        val result = solution.maxIncreasingSubarrays(nums)
        assertEquals(0, result)
    }

    @Test
    fun `test two element increasing array`() {
        val nums = listOf(1, 2)
        val result = solution.maxIncreasingSubarrays(nums)
        assertEquals(1, result)
    }

    @Test
    fun `test all increasing sequence`() {
        val nums = listOf(1, 2, 3, 4, 5, 6)
        val result = solution.maxIncreasingSubarrays(nums)
        assertEquals(3, result) // Can split into [1,2,3] and [4,5,6]
    }

    @Test
    fun `test one long increasing sequence`() {
        val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val result = solution.maxIncreasingSubarrays(nums)
        assertEquals(4, result) // Split into two halves of 4 each
    }

    @Test
    fun `test adjacent sequences of equal length`() {
        val nums = listOf(1, 2, 3, 10, 11, 12)
        val result = solution.maxIncreasingSubarrays(nums)
        assertEquals(3, result) // [1,2,3] and [10,11,12]
    }

    @Test
    fun `test three element increasing array`() {
        val nums = listOf(1, 2, 3)
        val result = solution.maxIncreasingSubarrays(nums)
        assertEquals(1, result) // Split into [1] and [2,3] or [1,2] and [3]
    }

    @Test
    fun `test four element increasing array`() {
        val nums = listOf(1, 2, 3, 4)
        val result = solution.maxIncreasingSubarrays(nums)
        assertEquals(2, result) // Split into [1,2] and [3,4]
    }

    @Test
    fun `test sequence ending with long increase`() {
        val nums = listOf(5, 1, 2, 3, 4, 5, 6)
        val result = solution.maxIncreasingSubarrays(nums)
        assertEquals(3, result) // [1,2,3,4,5,6] split into [1,2,3] and [4,5,6]
    }
}
