package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class AdjacentIncreasingSubarraysDetectionITest {

    private val solution = AdjacentIncreasingSubarraysDetectionI()

    @Test
    fun `test basic case with two adjacent increasing subarrays of length 2`() {
        val nums = listOf(2, 5, 7, 8, 9, 2, 3, 4, 3, 1)
        val k = 3
        assertTrue(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test case with no valid adjacent increasing subarrays`() {
        val nums = listOf(1, 2, 3, 4, 4, 4, 4, 5, 6, 7)
        val k = 5
        assertFalse(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test case with k equals 1`() {
        val nums = listOf(1, 2, 3, 4, 5)
        val k = 1
        assertTrue(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test case with single long increasing sequence that can be split`() {
        val nums = listOf(1, 2, 3, 4, 5, 6)
        val k = 3
        assertTrue(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test case with decreasing sequence`() {
        val nums = listOf(5, 4, 3, 2, 1)
        val k = 2
        assertFalse(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test case with exactly k length adjacent increasing subarrays`() {
        val nums = listOf(1, 2, 3, 10, 11, 12)
        val k = 3
        assertTrue(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test case with mixed increasing and decreasing segments`() {
        val nums = listOf(1, 2, 3, 4, 3, 4, 5)
        val k = 2
        assertTrue(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test minimum size array`() {
        val nums = listOf(1, 2)
        val k = 1
        assertTrue(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test array too small for k`() {
        val nums = listOf(1, 2, 3)
        val k = 2
        assertFalse(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test array with duplicate values breaking sequence`() {
        val nums = listOf(1, 2, 2, 3, 4, 5)
        val k = 2
        assertTrue(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test case where previous and current sequences form valid pair`() {
        val nums = listOf(1, 2, 3, 5, 6, 7)
        val k = 3
        assertTrue(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test case with long increasing sequence splitting into k length subarrays`() {
        val nums = listOf(1, 2, 3, 4, 5, 6, 7, 8)
        val k = 4
        assertTrue(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test case with k greater than array length`() {
        val nums = listOf(1, 2, 3, 4)
        val k = 5
        assertFalse(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test case with adjacent pairs at the end of array`() {
        val nums = listOf(5, 4, 3, 1, 2, 3, 4, 5, 6)
        val k = 2
        assertTrue(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test case with exactly 2k length increasing sequence`() {
        val nums = listOf(1, 2, 3, 4)
        val k = 2
        assertTrue(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test case with barely insufficient split`() {
        val nums = listOf(1, 2, 3, 4, 5)
        val k = 3
        assertFalse(solution.hasIncreasingSubarrays(nums, k))
    }

    @Test
    fun `test multiple increasing sequences with one valid pair`() {
        val nums = listOf(1, 2, 5, 6, 3, 4, 7, 8, 9, 10)
        val k = 2
        assertTrue(solution.hasIncreasingSubarrays(nums, k))
    }
}
