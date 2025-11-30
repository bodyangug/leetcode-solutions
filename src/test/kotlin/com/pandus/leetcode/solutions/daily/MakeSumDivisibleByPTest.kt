package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MakeSumDivisibleByPTest {

    private val solution = MakeSumDivisibleByP()

    @Test
    @DisplayName("Example 1: [3,1,4,2], p=6 should return 1")
    fun testExample1() {
        val nums = intArrayOf(3, 1, 4, 2)
        val p = 6
        val result = solution.minSubarray(nums, p)
        assertEquals(1, result, "Should remove subarray [4] of length 1")
    }

    @Test
    @DisplayName("Example 2: [6,3,5,2], p=9 should return 2")
    fun testExample2() {
        val nums = intArrayOf(6, 3, 5, 2)
        val p = 9
        val result = solution.minSubarray(nums, p)
        assertEquals(2, result, "Should remove subarray [5,2] of length 2")
    }

    @Test
    @DisplayName("Example 3: [1,2,3], p=3 should return 0")
    fun testExample3() {
        val nums = intArrayOf(1, 2, 3)
        val p = 3
        val result = solution.minSubarray(nums, p)
        assertEquals(0, result, "Sum is already divisible by p, no removal needed")
    }

    @Test
    @DisplayName("Sum already divisible by p")
    fun testSumAlreadyDivisible() {
        val nums = intArrayOf(4, 5, 6)
        val p = 5
        val result = solution.minSubarray(nums, p)
        assertEquals(0, result, "Sum 15 is divisible by 5")
    }

    @Test
    @DisplayName("Single element array - divisible")
    fun testSingleElementDivisible() {
        val nums = intArrayOf(6)
        val p = 3
        val result = solution.minSubarray(nums, p)
        assertEquals(0, result, "Single element 6 is divisible by 3")
    }

    @Test
    @DisplayName("Single element array - not divisible")
    fun testSingleElementNotDivisible() {
        val nums = intArrayOf(5)
        val p = 3
        val result = solution.minSubarray(nums, p)
        assertEquals(-1, result, "Cannot remove entire array")
    }

    @Test
    @DisplayName("Array with zeros")
    fun testArrayWithZeros() {
        val nums = intArrayOf(0, 0, 5, 0, 0)
        val p = 3
        val result = solution.minSubarray(nums, p)
        assertEquals(1, result, "Should remove [5] to make sum divisible")
    }

    @Test
    @DisplayName("Large values test")
    fun testLargeValues() {
        val nums = intArrayOf(1000000000, 1000000000, 1000000000)
        val p = 3
        val result = solution.minSubarray(nums, p)
        assertEquals(0, result, "Sum of large values should be handled correctly")
    }

    @Test
    @DisplayName("Complex case with multiple possible subarrays")
    fun testMultiplePossibleSubarrays() {
        val nums = intArrayOf(8, 32, 31, 18, 34, 20, 21, 13, 1, 27, 23, 22, 11, 15, 30, 4, 2)
        val p = 148
        val result = solution.minSubarray(nums, p)
        assertEquals(7, result, "Should find minimum length subarray among multiple options")
    }

    @Test
    @DisplayName("Edge case: sum equals p")
    fun testSumEqualsP() {
        val nums = intArrayOf(2, 3)
        val p = 5
        val result = solution.minSubarray(nums, p)
        assertEquals(0, result, "Sum equals p, already divisible")
    }
}
