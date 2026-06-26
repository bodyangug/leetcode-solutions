package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountSubarraysWithMajorityElementIITest {
    private val solution = CountSubarraysWithMajorityElementII()

    @Test
    @DisplayName("Example 1: nums = [1,2,2,3], target = 2 - should return 5")
    fun testExample1() {
        val nums = intArrayOf(1, 2, 2, 3)
        val result = solution.countMajoritySubarrays(nums, 2)
        assertEquals(5L, result, "Five subarrays have 2 as majority element")
    }

    @Test
    @DisplayName("Example 2: nums = [1,1,1,1], target = 1 - should return 10")
    fun testExample2() {
        val nums = intArrayOf(1, 1, 1, 1)
        val result = solution.countMajoritySubarrays(nums, 1)
        assertEquals(10L, result, "All C(4,2)+4 = 10 subarrays have 1 as majority")
    }

    @Test
    @DisplayName("Example 3: nums = [1,2,3], target = 4 - should return 0")
    fun testExample3() {
        val nums = intArrayOf(1, 2, 3)
        val result = solution.countMajoritySubarrays(nums, 4)
        assertEquals(0L, result, "Target not present, no majority subarrays")
    }

    @Test
    @DisplayName("Single element matching target: nums = [5], target = 5 - should return 1")
    fun testSingleElementMatch() {
        val nums = intArrayOf(5)
        val result = solution.countMajoritySubarrays(nums, 5)
        assertEquals(1L, result, "The only subarray [5] has 5 as majority")
    }

    @Test
    @DisplayName("Single element not matching target: nums = [5], target = 3 - should return 0")
    fun testSingleElementNoMatch() {
        val nums = intArrayOf(5)
        val result = solution.countMajoritySubarrays(nums, 3)
        assertEquals(0L, result, "Target not present")
    }

    @Test
    @DisplayName("Target never present in larger array: nums = [1,1,1,1,1], target = 2 - should return 0")
    fun testTargetAbsentMultipleElements() {
        val nums = intArrayOf(1, 1, 1, 1, 1)
        val result = solution.countMajoritySubarrays(nums, 2)
        assertEquals(0L, result, "Target absent, no majority subarrays")
    }

    @Test
    @DisplayName("Target appears once: nums = [3,2,3], target = 2 - should return 1")
    fun testTargetAppearsOnce() {
        val nums = intArrayOf(3, 2, 3)
        val result = solution.countMajoritySubarrays(nums, 2)
        assertEquals(1L, result, "Only [2] has 2 as strict majority")
    }

    @Test
    @DisplayName("Alternating pattern: nums = [1,2,1,2], target = 2 - should return 3")
    fun testAlternatingPattern() {
        val nums = intArrayOf(1, 2, 1, 2)
        val result = solution.countMajoritySubarrays(nums, 2)
        assertEquals(3L, result, "Two singleton [2] subarrays and [2,1,2]")
    }

    @Test
    @DisplayName("All elements equal target: nums = [7,7,7], target = 7 - should return 6")
    fun testAllEqualTarget() {
        val nums = intArrayOf(7, 7, 7)
        val result = solution.countMajoritySubarrays(nums, 7)
        assertEquals(6L, result, "All 6 subarrays have 7 as majority")
    }

    @Test
    @DisplayName("Target at boundaries: nums = [2,1,1,2], target = 2 - should return 2")
    fun testTargetAtBoundaries() {
        val nums = intArrayOf(2, 1, 1, 2)
        val result = solution.countMajoritySubarrays(nums, 2)
        assertEquals(2L, result, "Only singleton [2] subarrays qualify")
    }

    @Test
    @DisplayName("Mixed with cluster of targets: nums = [3,2,2,2,1], target = 2 - should return 11")
    fun testClusterOfTargets() {
        val nums = intArrayOf(3, 2, 2, 2, 1)
        val result = solution.countMajoritySubarrays(nums, 2)
        assertEquals(11L, result, "Eleven subarrays have 2 as strict majority")
    }

    @Test
    @DisplayName("Large input of all matching elements stresses Long result")
    fun testLargeAllMatching() {
        val n = 100_000
        val nums = IntArray(n) { 1 }
        val result = solution.countMajoritySubarrays(nums, 1)
        // All n*(n+1)/2 subarrays qualify; for n = 100000 this exceeds Int range.
        val expected = n.toLong() * (n.toLong() + 1) / 2
        assertEquals(expected, result, "Every subarray of identical targets is a majority subarray")
    }
}
