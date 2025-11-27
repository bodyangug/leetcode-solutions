package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximumSubarraySumWithLengthDivisibleByKTest {

    private val solution = MaximumSubarraySumWithLengthDivisibleByK()

    @Test
    @DisplayName("Example 2: nums = [1,2], k = 1 should return 3")
    fun testExample2() {
        val nums = intArrayOf(1, 2)
        val k = 1
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(3L, result, "When k=1, any subarray length is valid. Maximum is entire array [1,2] = 3")
    }

    @Test
    @DisplayName("Example 3: nums = [-5,-2,0,3,4], k = 3 should return 7")
    fun testExample3() {
        val nums = intArrayOf(-5, -2, 0, 3, 4)
        val k = 3
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(7L, result, "Subarray [0,3,4] has length 3 (divisible by 3) and sum 7")
    }

    @Test
    @DisplayName("Minimum size array: k elements exactly")
    fun testMinimumSizeArray() {
        val nums = intArrayOf(5, 10, 15)
        val k = 3
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(30L, result, "Array of exactly k elements should return the sum of all elements")
    }

    @Test
    @DisplayName("All positive numbers with k = 1")
    fun testAllPositiveWithK1() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val k = 1
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(15L, result, "When k=1, maximum is sum of all elements")
    }

    @Test
    @DisplayName("All negative numbers with k = 1")
    fun testAllNegativeWithK1() {
        val nums = intArrayOf(-5, -3, -8, -2, -1)
        val k = 1
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(-1L, result, "When all negative and k=1, maximum is the least negative single element")
    }

    @Test
    @DisplayName("All negative numbers with k = array length")
    fun testAllNegativeFullLength() {
        val nums = intArrayOf(-5, -3, -8)
        val k = 3
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(-16L, result, "Only valid subarray is entire array")
    }

    @Test
    @DisplayName("Array with zeros and k = 2")
    fun testWithZeros() {
        val nums = intArrayOf(0, 0, 5, 5)
        val k = 2
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(10L, result, "Subarray [5,5] has sum 10")
    }

    @Test
    @DisplayName("Large k value equal to array size")
    fun testKEqualsArraySize() {
        val nums = intArrayOf(10, -5, 20, -3, 8)
        val k = 5
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(30L, result, "Only one valid subarray: entire array")
    }

    @Test
    @DisplayName("k = 1 with single element array")
    fun testSingleElementK1() {
        val nums = intArrayOf(42)
        val k = 1
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(42L, result, "Single element array with k=1")
    }

    @Test
    @DisplayName("k = 1 with negative single element")
    fun testSingleNegativeElementK1() {
        val nums = intArrayOf(-10)
        val k = 1
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(-10L, result, "Single negative element with k=1")
    }

    @Test
    @DisplayName("Alternating positive and negative with k = 3")
    fun testAlternatingK3() {
        val nums = intArrayOf(10, -5, 8, -3, 6, -2)
        val k = 3
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(14L, result, "Best subarray of length 3 or 6")
    }

    @Test
    @DisplayName("Large array with k = 4")
    fun testLargerArrayK4() {
        val nums = intArrayOf(1, 2, 3, 4, -10, 5, 6, 7, 8)
        val k = 4
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(26L, result, "Subarray [5,6,7,8] has sum 26")
    }

    @Test
    @DisplayName("Array where best subarray is at the beginning")
    fun testBestSubarrayAtBeginning() {
        val nums = intArrayOf(10, 10, -5, -5, -10, -10)
        val k = 2
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(20L, result, "Subarray [10,10] at beginning")
    }

    @Test
    @DisplayName("Array where best subarray is in the middle")
    fun testBestSubarrayInMiddle() {
        val nums = intArrayOf(-5, -5, 15, 15, -5, -5)
        val k = 2
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(30L, result, "Subarray [15,15] in the middle")
    }

    @Test
    @DisplayName("Array where best subarray is at the end")
    fun testBestSubarrayAtEnd() {
        val nums = intArrayOf(-10, -10, -5, -5, 20, 20)
        val k = 2
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(40L, result, "Subarray [20,20] at the end")
    }

    @Test
    @DisplayName("k = 2 with even-length array of all same values")
    fun testSameValuesK2() {
        val nums = intArrayOf(7, 7, 7, 7)
        val k = 2
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(28L, result, "All elements sum to 28")
    }

    @Test
    @DisplayName("Subarray length 2k is better than length k")
    fun testLongerSubarrayBetter() {
        val nums = intArrayOf(5, 5, 5, 5)
        val k = 2
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(20L, result, "Entire array of length 4 (2k) gives maximum sum")
    }

    @Test
    @DisplayName("Array with extreme values")
    fun testExtremeValues() {
        val nums = intArrayOf(100000, -100000, 100000, -100000, 100000)
        val k = 1
        val result = solution.maxSubarraySum(nums, k)
        assertEquals(100000L, result, "Maximum with extreme fluctuations")
    }
}
