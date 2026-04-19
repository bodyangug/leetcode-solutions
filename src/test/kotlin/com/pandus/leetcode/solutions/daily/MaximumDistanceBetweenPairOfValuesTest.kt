package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDistanceBetweenPairOfValuesTest {
    private val solution = MaximumDistanceBetweenPairOfValues()

    @Test
    fun maxDistance_example1_returns2() {
        // Input: nums1 = [55,30,5,4,2], nums2 = [100,20,10,10,5]
        // Output: 2 (pair (2,4))
        val result = solution.maxDistance(intArrayOf(55, 30, 5, 4, 2), intArrayOf(100, 20, 10, 10, 5))
        assertEquals(2, result)
    }

    @Test
    fun maxDistance_example2_returns1() {
        // Input: nums1 = [2,2,2], nums2 = [10,10,1]
        // Output: 1 (pair (0,1))
        val result = solution.maxDistance(intArrayOf(2, 2, 2), intArrayOf(10, 10, 1))
        assertEquals(1, result)
    }

    @Test
    fun maxDistance_example3_returns2() {
        // Input: nums1 = [30,29,19,5], nums2 = [25,25,25,25,25]
        // Output: 2 (pair (2,4))
        val result = solution.maxDistance(intArrayOf(30, 29, 19, 5), intArrayOf(25, 25, 25, 25, 25))
        assertEquals(2, result)
    }

    @Test
    fun maxDistance_equalArrays_returns0() {
        // When nums1[i] == nums2[i] for all i, best distance is 0
        val result = solution.maxDistance(intArrayOf(5, 4, 3), intArrayOf(5, 4, 3))
        assertEquals(0, result)
    }

    @Test
    fun maxDistance_singleElement_returns0() {
        // Single element arrays, only pair is (0,0)
        val result = solution.maxDistance(intArrayOf(3), intArrayOf(5))
        assertEquals(0, result)
    }

    @Test
    fun maxDistance_nums2LargerThroughout_returnsMaxPossible() {
        // nums2 is always larger, maximum spread possible
        val result = solution.maxDistance(intArrayOf(1, 1, 1, 1), intArrayOf(10, 10, 10, 10, 10, 10))
        assertEquals(5, result)
    }

    @Test
    fun maxDistance_noValidPairBeyondDiagonal_returns0() {
        // nums1 is strictly decreasing and nums2 values become smaller quickly
        val result = solution.maxDistance(intArrayOf(10, 5, 2), intArrayOf(10, 4, 1))
        assertEquals(0, result)
    }
}
