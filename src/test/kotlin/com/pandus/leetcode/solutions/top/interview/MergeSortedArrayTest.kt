package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeSortedArrayTest {

    private val solution = MergeSortedArray()

    @Test
    fun testExample1() {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
        val nums2 = intArrayOf(2, 5, 6)
        solution.merge(nums1, 3, nums2, 3)
        assertArrayEquals(intArrayOf(1, 2, 2, 3, 5, 6), nums1)
    }

    @Test
    fun testExample2() {
        val nums1 = intArrayOf(1)
        val nums2 = intArrayOf()
        solution.merge(nums1, 1, nums2, 0)
        assertArrayEquals(intArrayOf(1), nums1)
    }

    @Test
    fun testExample3() {
        val nums1 = intArrayOf(0)
        val nums2 = intArrayOf(1)
        solution.merge(nums1, 0, nums2, 1)
        assertArrayEquals(intArrayOf(1), nums1)
    }

    @Test
    fun testAllFromNums2() {
        val nums1 = intArrayOf(0, 0, 0)
        val nums2 = intArrayOf(1, 2, 3)
        solution.merge(nums1, 0, nums2, 3)
        assertArrayEquals(intArrayOf(1, 2, 3), nums1)
    }

    @Test
    fun testMixedOrder() {
        val nums1 = intArrayOf(4, 5, 6, 0, 0, 0)
        val nums2 = intArrayOf(1, 2, 3)
        solution.merge(nums1, 3, nums2, 3)
        assertArrayEquals(intArrayOf(1, 2, 3, 4, 5, 6), nums1)
    }
}
