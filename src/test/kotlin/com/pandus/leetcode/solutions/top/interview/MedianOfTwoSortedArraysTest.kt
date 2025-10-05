package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MedianOfTwoSortedArraysTest {

    private val solution = MedianOfTwoSortedArrays()
    private val epsilon = 1e-9

    @Test
    fun testExample1() {
        val nums1 = intArrayOf(1, 3)
        val nums2 = intArrayOf(2)
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }

    @Test
    fun testExample2() {
        val nums1 = intArrayOf(1, 2)
        val nums2 = intArrayOf(3, 4)
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }

    @Test
    fun testOneEmptyArray() {
        val nums1 = intArrayOf()
        val nums2 = intArrayOf(1)
        assertEquals(1.0, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }

    @Test
    fun testBothArraysSameSize() {
        val nums1 = intArrayOf(1, 3, 5)
        val nums2 = intArrayOf(2, 4, 6)
        assertEquals(3.5, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }

    @Test
    fun testDifferentSizes() {
        val nums1 = intArrayOf(1, 2, 3, 4, 5)
        val nums2 = intArrayOf(6, 7)
        assertEquals(4.0, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }

    @Test
    fun testNegativeNumbers() {
        val nums1 = intArrayOf(-5, -1)
        val nums2 = intArrayOf(-3, 0, 2)
        assertEquals(-1.0, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }

    @Test
    fun testSecondArrayEmpty() {
        val nums1 = intArrayOf(1, 2, 3)
        val nums2 = intArrayOf()
        assertEquals(2.0, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }

    @Test
    fun testEvenTotalLength() {
        val nums1 = intArrayOf(1, 4)
        val nums2 = intArrayOf(2, 3)
        assertEquals(2.5, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }

    @Test
    fun testOddTotalLength() {
        val nums1 = intArrayOf(1, 2)
        val nums2 = intArrayOf(3, 4, 5)
        assertEquals(3.0, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }

    @Test
    fun testSingleElementArrays() {
        val nums1 = intArrayOf(1)
        val nums2 = intArrayOf(2)
        assertEquals(1.5, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }

    @Test
    fun testDuplicateElements() {
        val nums1 = intArrayOf(1, 1, 3)
        val nums2 = intArrayOf(1, 2, 2)
        assertEquals(1.5, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }

    @Test
    fun testLargerArrays() {
        val nums1 = intArrayOf(1, 3, 5, 7, 9)
        val nums2 = intArrayOf(2, 4, 6, 8, 10, 11, 12)
        assertEquals(6.5, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }

    @Test
    fun testAllSameValues() {
        val nums1 = intArrayOf(1, 1, 1)
        val nums2 = intArrayOf(1, 1)
        assertEquals(1.0, solution.findMedianSortedArrays(nums1, nums2), epsilon)
    }
}
