package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumDifferenceBetweenHighestAndLowestOfKScoresTest {
    private val solution = MinimumDifferenceBetweenHighestAndLowestOfKScores()

    @Test
    fun minimumDifference_example1_returns0() {
        val nums = intArrayOf(90)
        val k = 1
        assertEquals(0, solution.minimumDifference(nums, k))
    }

    @Test
    fun minimumDifference_example2_returns2() {
        val nums = intArrayOf(9, 4, 1, 7)
        val k = 2
        assertEquals(2, solution.minimumDifference(nums, k))
    }

    @Test
    fun minimumDifference_kIsZero_returns0() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val k = 0
        assertEquals(0, solution.minimumDifference(nums, k))
    }

    @Test
    fun minimumDifference_kIsOne_returns0() {
        val nums = intArrayOf(5, 10, 15, 20)
        val k = 1
        assertEquals(0, solution.minimumDifference(nums, k))
    }

    @Test
    fun minimumDifference_allSameScores_returns0() {
        val nums = intArrayOf(5, 5, 5, 5, 5)
        val k = 3
        assertEquals(0, solution.minimumDifference(nums, k))
    }

    @Test
    fun minimumDifference_kEqualsArrayLength_returnsFullRangeDifference() {
        val nums = intArrayOf(1, 3, 6, 10)
        val k = 4
        assertEquals(9, solution.minimumDifference(nums, k))
    }

    @Test
    fun minimumDifference_sortedArray_returnsMinConsecutiveDifference() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val k = 3
        assertEquals(2, solution.minimumDifference(nums, k))
    }

    @Test
    fun minimumDifference_unsortedArray_returnsMinDifference() {
        val nums = intArrayOf(41, 56, 31, 30, 75, 12)
        val k = 3
        assertEquals(11, solution.minimumDifference(nums, k))
    }

    @Test
    fun minimumDifference_largeGaps_findsMinimumWindow() {
        val nums = intArrayOf(1, 100, 2, 3, 200)
        val k = 2
        assertEquals(1, solution.minimumDifference(nums, k))
    }

    @Test
    fun minimumDifference_twoElements_returnsDifference() {
        val nums = intArrayOf(10, 20)
        val k = 2
        assertEquals(10, solution.minimumDifference(nums, k))
    }

    @Test
    fun minimumDifference_consecutiveNumbers_returnsKMinus1() {
        val nums = intArrayOf(5, 6, 7, 8, 9, 10)
        val k = 4
        assertEquals(3, solution.minimumDifference(nums, k))
    }

    @Test
    fun minimumDifference_largeNumbers_handlesCorrectly() {
        val nums = intArrayOf(87063, 61094, 44530, 21297, 95857, 93551, 9918)
        val k = 6
        assertEquals(74560, solution.minimumDifference(nums, k))
    }

    @Test
    fun minimumDifference_duplicateScores_handlesCorrectly() {
        val nums = intArrayOf(1, 3, 3, 5, 7, 7, 9)
        val k = 3
        assertEquals(2, solution.minimumDifference(nums, k))
    }
}
