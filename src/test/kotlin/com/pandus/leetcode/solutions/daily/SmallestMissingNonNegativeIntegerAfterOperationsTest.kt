package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestMissingNonNegativeIntegerAfterOperationsTest {
    private val solution = SmallestMissingNonNegativeIntegerAfterOperations()

    @Test
    fun `test with zero included`() {
        val nums = intArrayOf(0, 1, 2, 3)
        val value = 2
        val expected = 4
        assertEquals(expected, solution.findSmallestInteger(nums, value))
    }

    @Test
    fun `test all same remainders`() {
        val nums = intArrayOf(2, 4, 6, 8)
        val value = 2
        val expected = 1
        assertEquals(expected, solution.findSmallestInteger(nums, value))
    }

    @Test
    fun `test single element array`() {
        val nums = intArrayOf(5)
        val value = 3
        val expected = 0
        assertEquals(expected, solution.findSmallestInteger(nums, value))
    }

    @Test
    fun `test single element zero`() {
        val nums = intArrayOf(0)
        val value = 1
        val expected = 1
        assertEquals(expected, solution.findSmallestInteger(nums, value))
    }

    @Test
    fun `test value equals one`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val value = 1
        val expected = 5
        assertEquals(expected, solution.findSmallestInteger(nums, value))
    }

    @Test
    fun `test large value`() {
        val nums = intArrayOf(1, 2, 3)
        val value = 10
        val expected = 0
        assertEquals(expected, solution.findSmallestInteger(nums, value))
    }

    @Test
    fun `test consecutive sequence starting from zero`() {
        val nums = intArrayOf(0, 1, 2, 3, 4, 5)
        val value = 3
        val expected = 6
        assertEquals(expected, solution.findSmallestInteger(nums, value))
    }

    @Test
    fun `test with duplicate values`() {
        val nums = intArrayOf(1, 1, 1, 1)
        val value = 3
        val expected = 0
        assertEquals(expected, solution.findSmallestInteger(nums, value))
    }

    @Test
    fun `test larger array with value 5`() {
        val nums = intArrayOf(5, 10, 15, 20, 25, 6, 11, 16, 21, 26)
        val value = 5
        val expected = 2
        assertEquals(expected, solution.findSmallestInteger(nums, value))
    }

    @Test
    fun `test all zeros`() {
        val nums = intArrayOf(0, 0, 0, 0)
        val value = 1
        val expected = 4
        assertEquals(expected, solution.findSmallestInteger(nums, value))
    }
}
