package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeSortedArrayTest {
    @Test
    fun merge_mergesArraysCorrectly_positiveCase() {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val nums2 = intArrayOf(2, 5, 6)
        val solution = MergeSortedArray()
        solution.merge(nums1, 3, nums2, 3)
        assertArrayEquals(intArrayOf(1, 2, 2, 3, 5, 6), nums1)
    }

    @Test
    fun merge_handlesEmptySecondArray_negativeCase() {
        val nums1 = intArrayOf(1)
        val nums2 = intArrayOf()
        val solution = MergeSortedArray()
        solution.merge(nums1, 1, nums2, 0)
        assertArrayEquals(intArrayOf(1), nums1)
    }
}
