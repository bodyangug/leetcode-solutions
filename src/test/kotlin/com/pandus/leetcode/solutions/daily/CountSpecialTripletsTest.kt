package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountSpecialTripletsTest {
    private val solution = CountSpecialTriplets()

    @Test
    @DisplayName("Example 1: nums = [6,3,6] - should return 1")
    fun testExample1() {
        val nums = intArrayOf(6, 3, 6)
        val result = solution.specialTriplets(nums)
        assertEquals(1, result, "Only one special triplet (0,1,2): nums[0]=6, nums[1]=3, nums[2]=6")
    }

    @Test
    @DisplayName("Example 2: nums = [0,1,0,0] - should return 1")
    fun testExample2() {
        val nums = intArrayOf(0, 1, 0, 0)
        val result = solution.specialTriplets(nums)
        assertEquals(1, result, "Only one special triplet (0,2,3): nums[0]=0, nums[2]=0, nums[3]=0")
    }

    @Test
    @DisplayName("Example 3: nums = [8,4,2,8,4] - should return 2")
    fun testExample3() {
        val nums = intArrayOf(8, 4, 2, 8, 4)
        val result = solution.specialTriplets(nums)
        assertEquals(2, result, "Two special triplets: (0,1,3) and (1,2,4)")
    }

    @Test
    @DisplayName("Minimum size array: nums = [2,1,2] - should return 1")
    fun testMinimumSizeArray() {
        val nums = intArrayOf(2, 1, 2)
        val result = solution.specialTriplets(nums)
        assertEquals(1, result, "Triplet (0,1,2): nums[0]=2, nums[1]=1, nums[2]=2")
    }

    @Test
    @DisplayName("No special triplets: nums = [1,2,3] - should return 0")
    fun testNoSpecialTriplets() {
        val nums = intArrayOf(1, 2, 3)
        val result = solution.specialTriplets(nums)
        assertEquals(0, result, "No element is double of another")
    }

    @Test
    @DisplayName("All zeros: nums = [0,0,0,0] - should return 4")
    fun testAllZeros() {
        // With all zeros, any triplet (i,j,k) where i < j < k satisfies the condition
        // Since 0 = 0 * 2
        // Possible triplets: (0,1,2), (0,1,3), (0,2,3), (1,2,3) = 4 triplets
        val nums = intArrayOf(0, 0, 0, 0)
        val result = solution.specialTriplets(nums)
        assertEquals(4, result, "With all zeros, C(4,3) = 4 triplets")
    }

    @Test
    @DisplayName("All same non-zero values: nums = [4,4,4] - should return 0")
    fun testAllSameNonZero() {
        val nums = intArrayOf(4, 4, 4)
        val result = solution.specialTriplets(nums)
        assertEquals(0, result, "4 != 4 * 2, so no special triplets")
    }

    @Test
    @DisplayName("Multiple pairs with doubling pattern: nums = [4,2,4,1,2] - should return 2")
    fun testMultiplePairs() {
        val nums = intArrayOf(4, 2, 4, 1, 2)
        val result = solution.specialTriplets(nums)
        assertEquals(2, result, "Triplets: (0,1,2) and (1,3,4)")
    }

    @Test
    @DisplayName("Large values: nums = [1000000,500000,1000000] - should return 1")
    fun testLargeValues() {
        val nums = intArrayOf(1000000, 500000, 1000000)
        val result = solution.specialTriplets(nums)
        assertEquals(1, result, "Triplet (0,1,2): 1000000 = 500000 * 2")
    }

    @Test
    @DisplayName("Single element pattern: nums = [10,5,10,10,5,10] - should return 6")
    fun testRepeatedPattern() {
        val nums = intArrayOf(10, 5, 10, 10, 5, 10)
        val result = solution.specialTriplets(nums)
        // Triplets where nums[j] = 5 and nums[i] = nums[k] = 10
        // j can be at index 1 or 4
        // For j=1: i can be 0, k can be 2,3,5 => 3 triplets
        // For j=4: i can be 0,2,3, k can be 5 => 3 triplets
        assertEquals(6, result, "Multiple triplets with 10 = 5 * 2")
    }

    @Test
    @DisplayName("Edge case with single doubling: nums = [6,3] - should return 0")
    fun testTwoElementsOnly() {
        val nums = intArrayOf(6, 3)
        val result = solution.specialTriplets(nums)
        assertEquals(0, result, "Not enough elements for a triplet (need at least 3)")
    }

    @Test
    @DisplayName("Descending order: nums = [8,4,2,1] - should return 0")
    fun testDescendingOrder() {
        val nums = intArrayOf(8, 4, 2, 1)
        val result = solution.specialTriplets(nums)
        // Even though there are doubling relationships, the order i < j < k must be satisfied
        // We need nums[i] = nums[j] * 2 AND nums[k] = nums[j] * 2
        // No such triplet exists in descending order
        assertEquals(0, result, "No valid triplets in descending order")
    }
}
