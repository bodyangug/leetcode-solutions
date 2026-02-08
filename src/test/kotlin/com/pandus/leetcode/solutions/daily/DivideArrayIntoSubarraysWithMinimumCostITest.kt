package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DivideArrayIntoSubarraysWithMinimumCostITest {
    private val solution = DivideArrayIntoSubarraysWithMinimumCostI()

    @Test
    @DisplayName("Example 1: [1, 2, 3, 12] should return 6")
    fun testExample1() {
        val nums = intArrayOf(1, 2, 3, 12)
        val result = solution.minimumCost(nums)
        assertEquals(6, result, "Should return 6 (1 + 2 + 3)")
    }

    @Test
    @DisplayName("Example 2: [5, 4, 3] should return 12")
    fun testExample2() {
        val nums = intArrayOf(5, 4, 3)
        val result = solution.minimumCost(nums)
        assertEquals(12, result, "Should return 12 (5 + 4 + 3)")
    }

    @Test
    @DisplayName("Example 3: [10, 3, 1, 1] should return 12")
    fun testExample3() {
        val nums = intArrayOf(10, 3, 1, 1)
        val result = solution.minimumCost(nums)
        assertEquals(12, result, "Should return 12 (10 + 1 + 1)")
    }

    @Test
    @DisplayName("Minimum size array: [1, 1, 1] should return 3")
    fun testMinimumSize() {
        val nums = intArrayOf(1, 1, 1)
        val result = solution.minimumCost(nums)
        assertEquals(3, result, "Should return 3 (1 + 1 + 1)")
    }

    @Test
    @DisplayName("Array with equal elements: [5, 5, 5, 5] should return 15")
    fun testEqualElements() {
        val nums = intArrayOf(5, 5, 5, 5)
        val result = solution.minimumCost(nums)
        assertEquals(15, result, "Should return 15 (5 + 5 + 5)")
    }

    @Test
    @DisplayName("Array sorted in ascending order: [1, 2, 3, 4, 5] should return 6")
    fun testAscendingOrder() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val result = solution.minimumCost(nums)
        assertEquals(6, result, "Should return 6 (1 + 2 + 3)")
    }

    @Test
    @DisplayName("Array with duplicates in middle: [5, 3, 3, 3, 1] should return 9")
    fun testWithDuplicates() {
        val nums = intArrayOf(5, 3, 3, 3, 1)
        val result = solution.minimumCost(nums)
        assertEquals(9, result, "Should return 9 (5 + 1 + 3)")
    }

    @Test
    @DisplayName("Larger array: [7, 6, 5, 4, 3, 2, 1] should return 10")
    fun testLargerArray() {
        val nums = intArrayOf(7, 6, 5, 4, 3, 2, 1)
        val result = solution.minimumCost(nums)
        assertEquals(10, result, "Should return 10 (7 + 1 + 2)")
    }
}
