package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaxDotProductOfTwoSubsequencesTest {
    private val solution = MaxDotProductOfTwoSubsequences()

    @Test
    @DisplayName("Example 1: nums1 = [2,1,-2,5], nums2 = [3,0,-6] should return 18")
    fun testExample1() {
        val nums1 = intArrayOf(2, 1, -2, 5)
        val nums2 = intArrayOf(3, 0, -6)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(18, result, "Should return 18 (2*3 + (-2)*(-6)) = 6 + 12 = 18")
    }

    @Test
    @DisplayName("Example 2: nums1 = [3,-2], nums2 = [2,-6,7] should return 21")
    fun testExample2() {
        val nums1 = intArrayOf(3, -2)
        val nums2 = intArrayOf(2, -6, 7)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(21, result, "Should return 21 (3*7) = 21")
    }

    @Test
    @DisplayName("Example 3: nums1 = [-1,-1], nums2 = [1,1] should return -1")
    fun testExample3() {
        val nums1 = intArrayOf(-1, -1)
        val nums2 = intArrayOf(1, 1)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(-1, result, "Should return -1 (best single element product)")
    }

    @Test
    @DisplayName("Single element arrays with positive product")
    fun testSingleElementPositive() {
        val nums1 = intArrayOf(5)
        val nums2 = intArrayOf(3)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(15, result, "Should return 15 (5*3)")
    }

    @Test
    @DisplayName("Single element arrays with negative product")
    fun testSingleElementNegative() {
        val nums1 = intArrayOf(-5)
        val nums2 = intArrayOf(3)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(-15, result, "Should return -15 (-5*3)")
    }

    @Test
    @DisplayName("All positive numbers")
    fun testAllPositive() {
        val nums1 = intArrayOf(1, 2, 3)
        val nums2 = intArrayOf(4, 5)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(23, result, "Should return 23 (1*4 + 2*5 + 3*5 or optimal combination)")
    }

    @Test
    @DisplayName("All negative numbers in nums1, positive in nums2")
    fun testAllNegativeAndPositive() {
        val nums1 = intArrayOf(-1, -2, -3)
        val nums2 = intArrayOf(1, 2, 3)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(-1, result, "Should return -1 (best single element product)")
    }

    @Test
    @DisplayName("Mixed positive and negative - optimal subsequence selection")
    fun testMixedNumbers() {
        val nums1 = intArrayOf(5, -4, -3)
        val nums2 = intArrayOf(-2, 1, 3)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(15, result, "Should return 15 (5*3)")
    }

    @Test
    @DisplayName("Large positive products dominate")
    fun testLargePositiveProducts() {
        val nums1 = intArrayOf(10, 20, 30)
        val nums2 = intArrayOf(5, 10, 15)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(700, result, "Should maximize dot product with all positive values")
    }

    @Test
    @DisplayName("Negative multiplied by negative gives positive")
    fun testNegativeByNegative() {
        val nums1 = intArrayOf(-5, -10)
        val nums2 = intArrayOf(-2, -3)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(40, result, "Should return 40 (-5*-2 + -10*-3) = 10 + 30 = 40")
    }

    @Test
    @DisplayName("Zero in arrays")
    fun testWithZeros() {
        val nums1 = intArrayOf(0, 5, 3)
        val nums2 = intArrayOf(0, 2, 4)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(22, result, "Should skip zeros and maximize positive products")
    }

    @Test
    @DisplayName("Single best product among multiple options")
    fun testSingleBestProduct() {
        val nums1 = intArrayOf(1, 100, 1)
        val nums2 = intArrayOf(1, 50, 1)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(5002, result, "Should maximize with best combination")
    }

    @Test
    @DisplayName("Minimum length arrays")
    fun testMinimumLength() {
        val nums1 = intArrayOf(7)
        val nums2 = intArrayOf(8)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(56, result, "Should return 56 (7*8)")
    }

    @Test
    @DisplayName("Skip negative contributions")
    fun testSkipNegativeContributions() {
        val nums1 = intArrayOf(10, -5, 8)
        val nums2 = intArrayOf(2, -3, 4)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(67, result, "Should skip combinations that reduce total")
    }

    @Test
    @DisplayName("Complex mixed scenario")
    fun testComplexMixed() {
        val nums1 = intArrayOf(-3, 2, -4, 5)
        val nums2 = intArrayOf(1, -2, 3, -5)
        val result = solution.maxDotProduct(nums1, nums2)
        assertEquals(32, result, "Should find optimal subsequences: -4*-2 + 5*3 + -3*1 or better")
    }
}
