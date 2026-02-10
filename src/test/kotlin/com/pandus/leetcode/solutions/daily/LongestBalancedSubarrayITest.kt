package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestBalancedSubarrayITest {
    private val solution = LongestBalancedSubarrayI()

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
    fun `test one even and one odd - different values`() {
        val nums = intArrayOf(2, 1)
        val expected = 2
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test one even and one odd - reversed order`() {
        val nums = intArrayOf(3, 4)
        val expected = 2
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test two evens and two odds - balanced`() {
        val nums = intArrayOf(2, 4, 1, 3)
        val expected = 4
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test multiple evens then multiple odds`() {
        val nums = intArrayOf(2, 4, 6, 1, 3, 5)
        val expected = 6
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test interleaved evens and odds`() {
        val nums = intArrayOf(2, 1, 4, 3, 6, 5)
        val expected = 6
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test all even numbers`() {
        val nums = intArrayOf(2, 4, 6, 8)
        val expected = 0
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test all odd numbers`() {
        val nums = intArrayOf(1, 3, 5, 7)
        val expected = 0
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test complex case with multiple balanced subarrays`() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6)
        val expected = 6
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test with zero`() {
        val nums = intArrayOf(0, 1)
        val expected = 2
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test with negative numbers - even`() {
        val nums = intArrayOf(-2, -1)
        val expected = 2
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test with negative numbers - mixed`() {
        val nums = intArrayOf(-4, -2, -1, -3)
        val expected = 4
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test unbalanced with more evens`() {
        val nums = intArrayOf(2, 4, 6, 8, 1)
        val expected = 2
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test unbalanced with more odds`() {
        val nums = intArrayOf(1, 3, 5, 7, 2)
        val expected = 2
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test large array with balanced pattern`() {
        val nums = intArrayOf(10, 20, 30, 11, 21, 31)
        val expected = 6
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test alternating pattern starting with odd`() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8)
        val expected = 8
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test with three distinct evens and three distinct odds`() {
        val nums = intArrayOf(2, 4, 6, 1, 3, 5, 7)
        val expected = 6
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test edge case with balanced then unbalanced`() {
        val nums = intArrayOf(2, 1, 4, 6, 8)
        val expected = 2
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test array starting with multiple same evens`() {
        val nums = intArrayOf(8, 8, 8, 1, 3)
        val expected = 4
        assertEquals(expected, solution.longestBalanced(nums))
    }

    @Test
    fun `test array ending with multiple same odds`() {
        val nums = intArrayOf(2, 4, 9, 9, 9)
        val expected = 4
        assertEquals(expected, solution.longestBalanced(nums))
    }
}
