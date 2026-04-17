package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumAbsoluteDistanceBetweenMirrorPairsTest {
    private val solution = MinimumAbsoluteDistanceBetweenMirrorPairs()

    @Test
    @DisplayName("Example 1: nums = [12,21,45,33,54] - should return 1")
    fun testExample1() {
        val nums = intArrayOf(12, 21, 45, 33, 54)
        val result = solution.minMirrorPairDistance(nums)
        assertEquals(1, result, "Mirror pairs: (0,1) with distance 1, (2,4) with distance 2; minimum is 1")
    }

    @Test
    @DisplayName("Example 2: nums = [120,21] - should return 1")
    fun testExample2() {
        val nums = intArrayOf(120, 21)
        val result = solution.minMirrorPairDistance(nums)
        assertEquals(1, result, "reverse(120) = 21, only mirror pair (0,1) with distance 1")
    }

    @Test
    @DisplayName("Example 3: nums = [21,120] - should return -1")
    fun testExample3() {
        val nums = intArrayOf(21, 120)
        val result = solution.minMirrorPairDistance(nums)
        assertEquals(-1, result, "reverse(21) = 12, not present in array; no mirror pairs")
    }

    @Test
    @DisplayName("Single element: nums = [12] - should return -1")
    fun testSingleElement() {
        val nums = intArrayOf(12)
        val result = solution.minMirrorPairDistance(nums)
        assertEquals(-1, result, "Cannot form a pair with a single element")
    }

    @Test
    @DisplayName("Palindrome numbers: nums = [11,22,33,11] - should return -1")
    fun testPalindromeNumbers() {
        // reverse(11)=11, reverse(22)=22 — a number equal to its own reverse
        // (0,3): reverse(11)=11=nums[3], distance=3
        val nums = intArrayOf(11, 22, 33, 11)
        val result = solution.minMirrorPairDistance(nums)
        assertEquals(3, result, "reverse(11)=11, mirror pair (0,3) with distance 3")
    }

    @Test
    @DisplayName("Adjacent mirror pair: nums = [13,31] - should return 1")
    fun testAdjacentMirrorPair() {
        val nums = intArrayOf(13, 31)
        val result = solution.minMirrorPairDistance(nums)
        assertEquals(1, result, "reverse(13)=31, mirror pair (0,1) with distance 1")
    }

    @Test
    @DisplayName("No mirror pairs in array: nums = [12,34,56] - should return -1")
    fun testNoMirrorPairs() {
        val nums = intArrayOf(12, 34, 56)
        val result = solution.minMirrorPairDistance(nums)
        assertEquals(-1, result, "None of the reverses match any element in the array")
    }

    @Test
    @DisplayName("Multiple mirror pairs, pick closest: nums = [12,99,21,21,12] - should return 1")
    fun testMultipleMirrorPairsPickClosest() {
        // (0,2): reverse(12)=21=nums[2], distance=2
        // (1,?): reverse(99)=99, no match
        // (2,3): reverse(21)=12, nums[3]=21 no; but nums[3]=21 and nums[4]=12 => (3,4) reverse(21)=12=nums[4], distance=1
        val nums = intArrayOf(12, 99, 21, 21, 12)
        val result = solution.minMirrorPairDistance(nums)
        assertEquals(1, result, "Mirror pair (3,4) has distance 1")
    }

    @Test
    @DisplayName("Leading zeros after reverse: nums = [100,1] - should return 1")
    fun testLeadingZerosAfterReverse() {
        // reverse(100) = 001 = 1
        val nums = intArrayOf(100, 1)
        val result = solution.minMirrorPairDistance(nums)
        assertEquals(1, result, "reverse(100)=1, mirror pair (0,1) with distance 1")
    }
}
