package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountSubarraysWithMajorityElementITest {
    private val solution = CountSubarraysWithMajorityElementI()

    @Test
    @DisplayName("Example 1: nums = [1,2,2,3], target = 2 - should return 5")
    fun testExample1() {
        val nums = intArrayOf(1, 2, 2, 3)
        val result = solution.countMajoritySubarrays(nums, 2)
        assertEquals(5, result, "Five subarrays have 2 as majority element")
    }

    @Test
    @DisplayName("Example 2: nums = [1,1,1,1], target = 1 - should return 10")
    fun testExample2() {
        val nums = intArrayOf(1, 1, 1, 1)
        val result = solution.countMajoritySubarrays(nums, 1)
        assertEquals(10, result, "All C(4,2)+4 = 10 subarrays have 1 as majority")
    }

    @Test
    @DisplayName("Example 3: nums = [1,2,3], target = 4 - should return 0")
    fun testExample3() {
        val nums = intArrayOf(1, 2, 3)
        val result = solution.countMajoritySubarrays(nums, 4)
        assertEquals(0, result, "Target not present, no majority subarrays")
    }

    @Test
    @DisplayName("Single element matching target: nums = [5], target = 5 - should return 1")
    fun testSingleElementMatch() {
        val nums = intArrayOf(5)
        val result = solution.countMajoritySubarrays(nums, 5)
        assertEquals(1, result, "The only subarray [5] has 5 as majority")
    }

    @Test
    @DisplayName("Single element not matching target: nums = [5], target = 3 - should return 0")
    fun testSingleElementNoMatch() {
        val nums = intArrayOf(5)
        val result = solution.countMajoritySubarrays(nums, 3)
        assertEquals(0, result, "Target not present")
    }

    @Test
    @DisplayName("Target never present in larger array: nums = [1,1,1,1,1], target = 2 - should return 0")
    fun testTargetAbsentMultipleElements() {
        val nums = intArrayOf(1, 1, 1, 1, 1)
        val result = solution.countMajoritySubarrays(nums, 2)
        assertEquals(0, result, "Target absent, no majority subarrays")
    }

    @Test
    @DisplayName("Target appears once: nums = [3,2,3], target = 2 - should return 1")
    fun testTargetAppearsOnce() {
        val nums = intArrayOf(3, 2, 3)
        val result = solution.countMajoritySubarrays(nums, 2)
        assertEquals(1, result, "Only [2] has 2 as strict majority")
    }

    @Test
    @DisplayName("Alternating pattern: nums = [1,2,1,2], target = 2 - should return 3")
    fun testAlternatingPattern() {
        // Valid subarrays: [2] (idx 1), [2,1,2] (idx 1-3), [2] (idx 3)
        val nums = intArrayOf(1, 2, 1, 2)
        val result = solution.countMajoritySubarrays(nums, 2)
        assertEquals(3, result, "Two singleton [2] subarrays and [2,1,2]")
    }

    @Test
    @DisplayName("All elements equal target: nums = [7,7,7], target = 7 - should return 6")
    fun testAllEqualTarget() {
        val nums = intArrayOf(7, 7, 7)
        val result = solution.countMajoritySubarrays(nums, 7)
        assertEquals(6, result, "All 6 subarrays have 7 as majority")
    }

    @Test
    @DisplayName("Target at boundaries: nums = [2,1,1,2], target = 2 - should return 2")
    fun testTargetAtBoundaries() {
        // Subarrays containing more 2s than non-2s: [2] (idx 0), [2] (idx 3)
        val nums = intArrayOf(2, 1, 1, 2)
        val result = solution.countMajoritySubarrays(nums, 2)
        assertEquals(2, result, "Only singleton [2] subarrays qualify")
    }

    @Test
    @DisplayName("Mixed with cluster of targets: nums = [3,2,2,2,1], target = 2 - should return 11")
    fun testClusterOfTargets() {
        // Valid subarrays (strict majority of 2):
        // singletons: [2]x3 -> 3
        // length 2: [2,2]x2 -> 2
        // length 3: [3,2,2], [2,2,2], [2,2,1] -> 3
        // length 4: [3,2,2,2], [2,2,2,1] -> 2
        // length 5: [3,2,2,2,1] -> 1
        // total = 11
        val nums = intArrayOf(3, 2, 2, 2, 1)
        val result = solution.countMajoritySubarrays(nums, 2)
        assertEquals(11, result, "Eleven subarrays have 2 as strict majority")
    }
}
