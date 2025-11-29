package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumOperationsToMakeArraySumDivisibleByKTest {

    private val solution = MinimumOperationsToMakeArraySumDivisibleByK()

    @Test
    @DisplayName("Example 2: Sum already divisible by k")
    fun testSumAlreadyDivisible() {
        val nums = intArrayOf(3, 6, 9)
        val k = 3
        val result = solution.minOperations(nums, k)
        assertEquals(0, result, "Sum is 18, already divisible by 3, no operations needed")
    }

    @Test
    @DisplayName("Example 3: [5, 10, 15], k=10 should return 0")
    fun testExample3() {
        val nums = intArrayOf(5, 10, 15)
        val k = 10
        val result = solution.minOperations(nums, k)
        assertEquals(0, result, "Sum is 30, 30 % 10 = 0, no operations needed")
    }

    @Test
    @DisplayName("Example 4: [1, 2, 3], k=5 should return 1")
    fun testExample4() {
        val nums = intArrayOf(1, 2, 3)
        val k = 5
        val result = solution.minOperations(nums, k)
        assertEquals(1, result, "Sum is 6, 6 % 5 = 1, needs 1 operation to reach 10")
    }

    @Test
    @DisplayName("Edge case: Single element divisible by k")
    fun testSingleElementDivisible() {
        val nums = intArrayOf(10)
        val k = 5
        val result = solution.minOperations(nums, k)
        assertEquals(0, result, "Sum is 10, 10 % 5 = 0, no operations needed")
    }

    @Test
    @DisplayName("Edge case: Single element not divisible by k")
    fun testSingleElementNotDivisible() {
        val nums = intArrayOf(7)
        val k = 5
        val result = solution.minOperations(nums, k)
        assertEquals(2, result, "Sum is 7, 7 % 5 = 2, needs 2 operations to reach 10")
    }

    @Test
    @DisplayName("Edge case: k=1 (all sums divisible by 1)")
    fun testKEqualsOne() {
        val nums = intArrayOf(5, 7, 3, 9)
        val k = 1
        val result = solution.minOperations(nums, k)
        assertEquals(0, result, "Any sum is divisible by 1, no operations needed")
    }

    @Test
    @DisplayName("Large array: Sum requires k-1 operations")
    fun testLargeArrayMaxOperations() {
        val nums = intArrayOf(1, 1, 1, 1, 1)
        val k = 3
        val result = solution.minOperations(nums, k)
        assertEquals(2, result, "Sum is 5, 5 % 3 = 2, needs 2 operations to reach 6")
    }

    @Test
    @DisplayName("Array with larger numbers")
    fun testLargerNumbers() {
        val nums = intArrayOf(100, 200, 300)
        val k = 7
        val result = solution.minOperations(nums, k)
        assertEquals(5, result, "Sum is 600, 600 % 7 = 5, needs 5 operations")
    }

    @Test
    @DisplayName("Array with mixed values")
    fun testMixedValues() {
        val nums = intArrayOf(1, 5, 11, 3)
        val k = 4
        val result = solution.minOperations(nums, k)
        assertEquals(0, result, "Sum is 20, 20 % 4 = 0, no operations needed")
    }

    @Test
    @DisplayName("Two elements: [7, 8], k=5")
    fun testTwoElements() {
        val nums = intArrayOf(7, 8)
        val k = 5
        val result = solution.minOperations(nums, k)
        assertEquals(0, result, "Sum is 15, 15 % 5 = 0, no operations needed")
    }

    @Test
    @DisplayName("Remainder is 1: [10, 11], k=7")
    fun testRemainderOne() {
        val nums = intArrayOf(10, 11)
        val k = 7
        val result = solution.minOperations(nums, k)
        assertEquals(0, result, "Sum is 21, 21 % 7 = 0, no operations needed")
    }

    @Test
    @DisplayName("Large k value: [1, 2, 3], k=100")
    fun testLargeK() {
        val nums = intArrayOf(1, 2, 3)
        val k = 100
        val result = solution.minOperations(nums, k)
        assertEquals(6, result, "Sum is 6, 6 % 100 = 6, needs 6 operations to reach 100")
    }
}
