package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindSumOfArrayProductOfMagicalSequencesTest {

    private val solution = FindSumOfArrayProductOfMagicalSequences()

    @Test
    fun `test modular arithmetic with large result`() {
        val m = 5
        val k = 2
        val nums = intArrayOf(100, 200, 300)
        val result = solution.magicalSum(m, k, nums)
        // Should apply MOD correctly
        assert(result >= 0)
        assert(result < 1000000007)
    }

    @Test
    fun `test edge case m=1, k=1`() {
        val m = 1
        val k = 1
        val nums = intArrayOf(7, 8)
        val result = solution.magicalSum(m, k, nums)
        // With m=1, k=1, specific behavior expected
        assertEquals(15, result)
    }

    @Test
    fun `test result is within modulo bounds`() {
        val m = 4
        val k = 1
        val nums = intArrayOf(999999, 999998, 999997)
        val result = solution.magicalSum(m, k, nums)
        // Verify result is properly modded
        assert(result >= 0)
        assert(result < 1000000007)
    }

    @Test
    fun `test with zeros in array`() {
        val m = 2
        val k = 0
        val nums = intArrayOf(0, 1, 2)
        val result = solution.magicalSum(m, k, nums)
        // Zero should be handled correctly
        assertEquals(0, result)
    }

    @Test
    fun `test ascending sequence`() {
        val m = 3
        val k = 1
        val nums = intArrayOf(1, 2, 3, 4)
        val result = solution.magicalSum(m, k, nums)
        // Ascending values
        assert(result > 0)
        assert(result < 1000000007)
    }

    @Test
    fun `test descending sequence`() {
        val m = 3
        val k = 1
        val nums = intArrayOf(4, 3, 2, 1)
        val result = solution.magicalSum(m, k, nums)
        // Descending values
        assert(result > 0)
        assert(result < 1000000007)
    }
}

