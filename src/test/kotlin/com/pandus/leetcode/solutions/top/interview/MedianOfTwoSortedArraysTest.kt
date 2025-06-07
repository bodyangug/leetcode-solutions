package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MedianOfTwoSortedArraysTest {
    @Test
    fun findMedianSortedArrays_returnsCorrectMedian_positiveCase() {
        val solution = MedianOfTwoSortedArrays()
        assertEquals(2.0, solution.findMedianSortedArrays(intArrayOf(1, 3), intArrayOf(2)))
    }
}
