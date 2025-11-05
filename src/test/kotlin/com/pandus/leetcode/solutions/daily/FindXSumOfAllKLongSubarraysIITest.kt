package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FindXSumOfAllKLongSubarraysIITest {

    private val solution = FindXSumOfAllKLongSubarraysII()

    @Test
    @DisplayName("Basic case with simple frequency counting")
    fun findXSum_basic() {
        val nums = intArrayOf(1, 1, 2, 2, 3, 4, 2, 3)
        val k = 6
        val x = 2
        val expected = longArrayOf(6, 10, 12)
        val result = solution.findXSum(nums, k, x)
        assertArrayEquals(expected, result)
    }

    @Test
    @DisplayName("Single element array")
    fun findXSum_singleElement() {
        val nums = intArrayOf(5)
        val k = 1
        val x = 1
        val expected = longArrayOf(5)
        val result = solution.findXSum(nums, k, x)
        assertArrayEquals(expected, result)
    }

    @Test
    @DisplayName("All elements are the same")
    fun findXSum_allSameElements() {
        val nums = intArrayOf(3, 3, 3, 3, 3)
        val k = 3
        val x = 1
        val expected = longArrayOf(9, 9, 9)
        val result = solution.findXSum(nums, k, x)
        assertArrayEquals(expected, result)
    }

    @Test
    @DisplayName("X equals K - all elements contribute")
    fun findXSum_xEqualsK() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val k = 3
        val x = 3
        val expected = longArrayOf(6, 9, 12)
        val result = solution.findXSum(nums, k, x)
        assertArrayEquals(expected, result)
    }

    @Test
    @DisplayName("X is 1 - only most frequent element")
    fun findXSum_xIsOne() {
        val nums = intArrayOf(1, 1, 2, 3, 3, 3)
        val k = 4
        val x = 1
        val expected = longArrayOf(2, 6, 9)
        val result = solution.findXSum(nums, k, x)
        assertArrayEquals(expected, result)
    }

    @Test
    @DisplayName("Tie breaking by value - higher value wins")
    fun findXSum_tieBreakingByValue() {
        val nums = intArrayOf(1, 2, 3, 4)
        val k = 4
        val x = 2
        val expected = longArrayOf(7)
        val result = solution.findXSum(nums, k, x)
        assertArrayEquals(expected, result)
    }

    @Test
    @DisplayName("Two element array with k=2")
    fun findXSum_twoElements() {
        val nums = intArrayOf(10, 20)
        val k = 2
        val x = 1
        val expected = longArrayOf(20)
        val result = solution.findXSum(nums, k, x)
        assertArrayEquals(expected, result)
    }

    @Test
    @DisplayName("Repeated pattern in array")
    fun findXSum_repeatedPattern() {
        val nums = intArrayOf(1, 2, 1, 2, 1, 2)
        val k = 4
        val x = 2
        val expected = longArrayOf(6, 6, 6)
        val result = solution.findXSum(nums, k, x)
        assertArrayEquals(expected, result)
    }
}
