package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicatesFromSortedArrayTest {
    @Test
    fun removeDuplicates_removesDuplicates_positiveCase() {
        val nums = intArrayOf(1, 1, 2)
        val solution = RemoveDuplicatesFromSortedArray()
        val k = solution.removeDuplicates(nums)
        assertEquals(2, k)
    }

    @Test
    fun removeDuplicates_handlesEmptyArray_negativeCase() {
        val nums = intArrayOf()
        val solution = RemoveDuplicatesFromSortedArray()
        val k = solution.removeDuplicates(nums)
        assertEquals(0, k)
    }
}
