package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TwoSumTest {
    @Test
    fun twoSum_returnsCorrectIndices_positiveCase() {
        val solution = TwoSum()
        assertArrayEquals(intArrayOf(0, 1), solution.twoSum(intArrayOf(2, 7, 11, 15), 9))
    }

    @Test
    fun twoSum_returnsMinusOneForNoSolution_negativeCase() {
        val solution = TwoSum()
        assertArrayEquals(intArrayOf(-1, -1), solution.twoSum(intArrayOf(1, 2, 3), 7))
    }
}
