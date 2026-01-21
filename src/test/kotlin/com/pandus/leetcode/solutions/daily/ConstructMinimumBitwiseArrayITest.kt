package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConstructMinimumBitwiseArrayITest {
    private val solution = ConstructMinimumBitwiseArrayI()

    @Test
    fun `test example 1 - basic case with mixed results`() {
        val nums = mutableListOf(2, 3, 5, 7)
        val expected = intArrayOf(-1, 1, 4, 3)
        assertArrayEquals(expected, solution.minBitwiseArray(nums))
    }

    @Test
    fun `test example 2 - larger numbers`() {
        val nums = mutableListOf(11, 13, 31)
        val expected = intArrayOf(9, 12, 15)
        assertArrayEquals(expected, solution.minBitwiseArray(nums))
    }

    @Test
    fun `test single element with no solution`() {
        val nums = mutableListOf(2)
        val expected = intArrayOf(-1)
        assertArrayEquals(expected, solution.minBitwiseArray(nums))
    }

    @Test
    fun `test single element with solution`() {
        val nums = mutableListOf(3)
        val expected = intArrayOf(1)
        assertArrayEquals(expected, solution.minBitwiseArray(nums))
    }

    @Test
    fun `test all elements have no solution`() {
        val nums = mutableListOf(2, 4, 8, 16)
        val expected = intArrayOf(-1, -1, -1, -1)
        assertArrayEquals(expected, solution.minBitwiseArray(nums))
    }

    @Test
    fun `test all elements have solutions`() {
        val nums = mutableListOf(3, 7, 15, 31)
        val expected = intArrayOf(1, 3, 7, 15)
        assertArrayEquals(expected, solution.minBitwiseArray(nums))
    }

    @Test
    fun `test mixed consecutive numbers`() {
        val nums = mutableListOf(5, 6, 7, 8)
        val expected = intArrayOf(4, -1, 3, -1)
        assertArrayEquals(expected, solution.minBitwiseArray(nums))
    }

    @Test
    fun `test larger values`() {
        val nums = mutableListOf(63, 127, 255)
        val expected = intArrayOf(31, 63, 127)
        assertArrayEquals(expected, solution.minBitwiseArray(nums))
    }

    @Test
    fun `test small odd numbers`() {
        val nums = mutableListOf(3, 5, 7, 9, 11)
        val expected = intArrayOf(1, 4, 3, 8, 9)
        assertArrayEquals(expected, solution.minBitwiseArray(nums))
    }

    @Test
    fun `test verification of example 1 logic`() {
        // Verify: 1 OR (1 + 1) = 1 OR 2 = 3
        val nums = mutableListOf(3)
        val result = solution.minBitwiseArray(nums)
        val ans = result[0]
        assertEquals(1, ans)
        assertEquals(3, ans or (ans + 1))
    }

    @Test
    fun `test verification of example 2 first case`() {
        // Verify: 9 OR (9 + 1) = 9 OR 10 = 11
        val nums = mutableListOf(11)
        val result = solution.minBitwiseArray(nums)
        val ans = result[0]
        assertEquals(9, ans)
        assertEquals(11, ans or (ans + 1))
    }

    @Test
    fun `test numbers that are powers of two minus one`() {
        // Numbers like 3, 7, 15, 31, 63 (2^n - 1) always have solutions
        val nums = mutableListOf(3, 7, 15, 31, 63, 127)
        val expected = intArrayOf(1, 3, 7, 15, 31, 63)
        assertArrayEquals(expected, solution.minBitwiseArray(nums))
    }

    @Test
    fun `test numbers that are powers of two`() {
        // Powers of 2 (2, 4, 8, 16, 32) have no solutions
        val nums = mutableListOf(2, 4, 8, 16, 32)
        val expected = intArrayOf(-1, -1, -1, -1, -1)
        assertArrayEquals(expected, solution.minBitwiseArray(nums))
    }

    private fun assertEquals(expected: Int, actual: Int) {
        org.junit.jupiter.api.Assertions.assertEquals(expected, actual)
    }
}
