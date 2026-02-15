package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestBalancedSubarrayIITest {
    private val solution = LongestBalancedSubarrayII()

    @Test
    fun `test example 1 - full array balanced`() {
        val nums = intArrayOf(2, 5, 4, 3)
        val expected = 4
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test example 2 - with duplicate even`() {
        val nums = intArrayOf(3, 2, 2, 5, 4)
        val expected = 5
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test example 3 - subarray in middle`() {
        val nums = intArrayOf(1, 2, 3, 2)
        val expected = 3
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test empty array`() {
        val nums = intArrayOf()
        val expected = 0
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test single even element`() {
        val nums = intArrayOf(2)
        val expected = 0
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test single odd element`() {
        val nums = intArrayOf(1)
        val expected = 0
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test one even and one odd`() {
        val nums = intArrayOf(2, 1)
        val expected = 2
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test all same even values`() {
        val nums = intArrayOf(2, 2, 2, 2)
        val expected = 0
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test all same odd values`() {
        val nums = intArrayOf(1, 1, 1, 1)
        val expected = 0
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test distinct evens exceed distinct odds`() {
        val nums = intArrayOf(2, 4, 6, 1)
        val expected = 2
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test distinct odds exceed distinct evens`() {
        val nums = intArrayOf(1, 3, 5, 2)
        val expected = 2
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test multiple balanced subarrays - pick longest`() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6)
        val expected = 6
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test balanced with many duplicates`() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 2)
        val expected = 6
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test interleaved even and odd duplicates`() {
        val nums = intArrayOf(1, 2, 1, 2, 3, 4)
        val expected = 6
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test no balanced subarray possible`() {
        val nums = intArrayOf(2, 4, 6)
        val expected = 0
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test balanced at start of array`() {
        val nums = intArrayOf(1, 2, 4, 4, 4)
        val expected = 2
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test large balanced subarray with repeats`() {
        val nums = intArrayOf(1, 1, 2, 2, 3, 3, 4, 4)
        val expected = 8
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test negative numbers - even and odd`() {
        val nums = intArrayOf(-2, -1, -4, -3)
        val expected = 4
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test mixed positive and negative`() {
        val nums = intArrayOf(-1, 2, 3, -4)
        val expected = 4
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test zero included as even`() {
        val nums = intArrayOf(0, 1)
        val expected = 2
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test multiple zeros with one odd`() {
        val nums = intArrayOf(0, 0, 0, 1)
        val expected = 4
        assertEquals(expected, solution.longestBalanced(nums))
    }
}
