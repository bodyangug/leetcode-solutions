package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestIncreasingSubsequenceTest {
    @Test
    fun lengthOfLIS_returnsCorrectLength_positiveCase() {
        val solution = LongestIncreasingSubsequence()
        assertEquals(4, solution.lengthOfLIS(intArrayOf(10, 9, 2, 5, 3, 7, 101, 18)))
    }

    @Test
    fun lengthOfLIS_returnsOneForSingleElement_negativeCase() {
        val solution = LongestIncreasingSubsequence()
        assertEquals(1, solution.lengthOfLIS(intArrayOf(7)))
    }
}
