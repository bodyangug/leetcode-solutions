package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DivideArrayIntoSubarraysWithMinimumCostIITest {
    private val solution = DivideArrayIntoSubarraysWithMinimumCostII()

    @Test
    @DisplayName("Example 1: nums = [1,3,2,6,4,2], k = 3, dist = 3 should return 5")
    fun testExample1() {
        val nums = intArrayOf(1, 3, 2, 6, 4, 2)
        val k = 3
        val dist = 3
        val result = solution.minimumCost(nums, k, dist)
        assertEquals(5L, result, "Should return 5 (1 + 2 + 2)")
    }

    @Test
    @DisplayName("Example 2: nums = [10,1,2,2,2,1], k = 4, dist = 3 should return 15")
    fun testExample2() {
        val nums = intArrayOf(10, 1, 2, 2, 2, 1)
        val k = 4
        val dist = 3
        val result = solution.minimumCost(nums, k, dist)
        assertEquals(15L, result, "Should return 15 (10 + 1 + 2 + 2)")
    }

    @Test
    @DisplayName("Example 3: nums = [10,8,18,9], k = 3, dist = 1 should return 36")
    fun testExample3() {
        val nums = intArrayOf(10, 8, 18, 9)
        val k = 3
        val dist = 1
        val result = solution.minimumCost(nums, k, dist)
        assertEquals(36L, result, "Should return 36 (10 + 8 + 18)")
    }

    @Test
    @DisplayName("Minimum case: k = 2, dist = 1, simple array")
    fun testMinimumCase() {
        val nums = intArrayOf(5, 3, 7)
        val k = 2
        val dist = 1
        val result = solution.minimumCost(nums, k, dist)
        assertEquals(8L, result, "Should return 8 (5 + 3)")
    }

    @Test
    @DisplayName("All elements are equal")
    fun testEqualElements() {
        val nums = intArrayOf(5, 5, 5, 5, 5)
        val k = 3
        val dist = 2
        val result = solution.minimumCost(nums, k, dist)
        assertEquals(15L, result, "Should return 15 (5 + 5 + 5)")
    }

    @Test
    @DisplayName("Small window: dist = 1, k = 3")
    fun testSmallWindow() {
        val nums = intArrayOf(10, 2, 3, 4, 5)
        val k = 3
        val dist = 1
        val result = solution.minimumCost(nums, k, dist)
        assertEquals(15L, result, "Should return 15 (10 + 2 + 3)")
    }

    @Test
    @DisplayName("Ascending order array")
    fun testAscendingOrder() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6)
        val k = 3
        val dist = 3
        val result = solution.minimumCost(nums, k, dist)
        assertEquals(6L, result, "Should return 6 (1 + 2 + 3)")
    }

    @Test
    @DisplayName("First element is largest")
    fun testFirstElementLargest() {
        val nums = intArrayOf(100, 1, 2, 3, 4)
        val k = 3
        val dist = 2
        val result = solution.minimumCost(nums, k, dist)
        assertEquals(103L, result, "Should return 103 (100 + 1 + 2)")
    }

    @Test
    @DisplayName("First element is smallest")
    fun testFirstElementSmallest() {
        val nums = intArrayOf(1, 10, 20, 30, 5)
        val k = 3
        val dist = 3
        val result = solution.minimumCost(nums, k, dist)
        assertEquals(16L, result, "Should return 16 (1 + 5 + 10)")
    }

    @Test
    @DisplayName("Array with duplicates")
    fun testWithDuplicates() {
        val nums = intArrayOf(5, 3, 3, 3, 1, 3)
        val k = 3
        val dist = 4
        val result = solution.minimumCost(nums, k, dist)
        assertEquals(9L, result, "Should return 9 (5 + 1 + 3)")
    }

    @Test
    @DisplayName("Mixed values with optimal choice in middle")
    fun testOptimalInMiddle() {
        val nums = intArrayOf(15, 10, 5, 8, 3, 12)
        val k = 3
        val dist = 4
        val result = solution.minimumCost(nums, k, dist)
        assertEquals(23L, result, "Should return 23 (15 + 3 + 5)")
    }

    @Test
    @DisplayName("Minimum k = 2 with larger array")
    fun testMinimumKWithLargerArray() {
        val nums = intArrayOf(20, 15, 10, 5, 1)
        val k = 2
        val dist = 3
        val result = solution.minimumCost(nums, k, dist)
        assertEquals(21L, result, "Should return 21 (20 + 1)")
    }
}
