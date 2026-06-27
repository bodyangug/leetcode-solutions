package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindMaximumNumberOfElementsInSubsetTest {
    private val solution = FindMaximumNumberOfElementsInSubset()

    @Test
    fun `maximumLength returns three for basic square chain`() {
        val nums = intArrayOf(5, 4, 1, 2, 2)
        val result = solution.maximumLength(nums)
        assertEquals(3, result)
    }

    @Test
    fun `maximumLength handles multiple levels in chain`() {
        val nums = intArrayOf(2, 2, 4, 4, 16, 16, 256)
        val result = solution.maximumLength(nums)
        assertEquals(7, result)
    }

    @Test
    fun `maximumLength handles all ones with odd trimming`() {
        val nums = intArrayOf(1, 1, 1, 1, 1, 1)
        val result = solution.maximumLength(nums)
        assertEquals(5, result)
    }

    @Test
    fun `maximumLength returns one for example two`() {
        val nums = intArrayOf(1, 3, 2, 4)
        val result = solution.maximumLength(nums)
        assertEquals(1, result)
    }
}
