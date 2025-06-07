package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TwoSum2InputArrayIsSortedTest {
    @Test
    fun twoSum_returnsCorrectIndices_positiveCase() {
        val solution = TwoSum2InputArrayIsSorted()
        assertArrayEquals(intArrayOf(1, 2), solution.twoSum(intArrayOf(2, 7, 11, 15), 9))
    }

    @Test
    fun twoSum_returnsZeroForNoSolution_negativeCase() {
        val solution = TwoSum2InputArrayIsSorted()
        assertArrayEquals(intArrayOf(0, 0), solution.twoSum(intArrayOf(1, 2, 3), 7))
    }
}
