package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimizeMaximumPairSumInArrayTest {
    private val solution = MinimizeMaximumPairSumInArray()

    @Test
    fun minPairSum_example1_returns7() {
        val nums = intArrayOf(3, 5, 2, 3)
        assertEquals(7, solution.minPairSum(nums))
    }

    @Test
    fun minPairSum_example2_returns8() {
        val nums = intArrayOf(3, 5, 4, 2, 4, 6)
        assertEquals(8, solution.minPairSum(nums))
    }

    @Test
    fun minPairSum_twoElements_returnsSum() {
        val nums = intArrayOf(1, 5)
        assertEquals(6, solution.minPairSum(nums))
    }

    @Test
    fun minPairSum_allSameElements_returnsDoubleValue() {
        val nums = intArrayOf(4, 4, 4, 4)
        assertEquals(8, solution.minPairSum(nums))
    }

    @Test
    fun minPairSum_sortedArray_returnsCorrectMax() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6)
        assertEquals(7, solution.minPairSum(nums))
    }

    @Test
    fun minPairSum_reverseSortedArray_returnsCorrectMax() {
        val nums = intArrayOf(6, 5, 4, 3, 2, 1)
        assertEquals(7, solution.minPairSum(nums))
    }

    @Test
    fun minPairSum_largeValues_returnsCorrectMax() {
        val nums = intArrayOf(100, 200, 300, 400)
        assertEquals(500, solution.minPairSum(nums))
    }

    @Test
    fun minPairSum_withZeros_returnsCorrectMax() {
        val nums = intArrayOf(0, 0, 1, 1)
        assertEquals(1, solution.minPairSum(nums))
    }

    @Test
    fun minPairSum_consecutiveNumbers_returnsCorrectMax() {
        val nums = intArrayOf(1, 2, 3, 4)
        assertEquals(5, solution.minPairSum(nums))
    }

    @Test
    fun minPairSum_largeArray_returnsCorrectMax() {
        val nums = intArrayOf(1, 3, 5, 7, 9, 11, 2, 4, 6, 8)
        assertEquals(12, solution.minPairSum(nums))
    }

    @Test
    fun minPairSum_duplicateValues_returnsCorrectMax() {
        val nums = intArrayOf(5, 5, 10, 10)
        assertEquals(15, solution.minPairSum(nums))
    }

    @Test
    fun minPairSum_randomOrder_returnsCorrectMax() {
        val nums = intArrayOf(7, 1, 9, 3, 5, 11)
        assertEquals(12, solution.minPairSum(nums))
    }
}
