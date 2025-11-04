package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FindXSumOfAllKLongSubarraysITest {
    @Test
    @DisplayName("Basic case with simple subarray and x-sum calculation")
    fun findXSum_basic_simple() {
        val solution = FindXSumOfAllKLongSubarraysI()
        val nums = intArrayOf(1, 1, 2, 2, 3, 4, 2, 3)
        val result = solution.findXSum(nums, k = 6, x = 2)
        val expected = intArrayOf(6, 10, 12)
        assertArrayEquals(expected, result, "X-sum should correctly calculate top x frequent elements")
    }

    @Test
    @DisplayName("Basic case with x equals 1")
    fun findXSum_basic_x_one() {
        val solution = FindXSumOfAllKLongSubarraysI()
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val result = solution.findXSum(nums, k = 3, x = 1)
        val expected = intArrayOf(3, 4, 5)
        assertArrayEquals(expected, result, "X-sum with x=1 should return only the most frequent element")
    }

    @Test
    @DisplayName("Edge case with minimum k and x")
    fun findXSum_edge_minimum() {
        val solution = FindXSumOfAllKLongSubarraysI()
        val nums = intArrayOf(5, 3, 8)
        val result = solution.findXSum(nums, k = 1, x = 1)
        val expected = intArrayOf(5, 3, 8)
        assertArrayEquals(expected, result, "With k=1 and x=1, each element should be its own x-sum")
    }

    @Test
    @DisplayName("Edge case where x is larger than unique elements in subarray")
    fun findXSum_edge_x_larger_than_unique() {
        val solution = FindXSumOfAllKLongSubarraysI()
        val nums = intArrayOf(2, 2, 2, 2)
        val result = solution.findXSum(nums, k = 3, x = 5)
        val expected = intArrayOf(6, 6)
        assertArrayEquals(expected, result, "X-sum should use all available unique elements when x is larger")
    }
}
