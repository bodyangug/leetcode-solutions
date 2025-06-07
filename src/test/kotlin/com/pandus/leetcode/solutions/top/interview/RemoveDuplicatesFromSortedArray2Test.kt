package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicatesFromSortedArray2Test {
    @Test
    fun removeDuplicates_allowsAtMostTwoDuplicates_positiveCase() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)
        val solution = RemoveDuplicatesFromSortedArray2()
        val k = solution.removeDuplicates(nums)
        assertEquals(7, k)
    }

    @Test
    fun removeDuplicates_handlesEmptyArray_negativeCase() {
        val nums = intArrayOf()
        val solution = RemoveDuplicatesFromSortedArray2()
        val k = solution.removeDuplicates(nums)
        assertEquals(0, k)
    }
}
