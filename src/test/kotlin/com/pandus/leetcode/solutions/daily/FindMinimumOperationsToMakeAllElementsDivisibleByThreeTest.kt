package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class FindMinimumOperationsToMakeAllElementsDivisibleByThreeTest {

    private val solution = FindMinimumOperationsToMakeAllElementsDivisibleByThree()

    @Test
    @DisplayName("All elements already divisible by 3")
    fun testAllElementsAlreadyDivisible() {
        val nums = intArrayOf(3, 6, 9, 12)
        val result = solution.minimumOperations(nums)
        assertEquals(0, result, "Should return 0 operations when all elements are divisible by 3")
    }

    @Test
    @DisplayName("Elements with remainder 1")
    fun testElementsWithRemainder1() {
        val nums = intArrayOf(1, 4, 7, 10)
        val result = solution.minimumOperations(nums)
        assertEquals(4, result, "Should return 4 operations (1 operation per element with remainder 1)")
    }

    @Test
    @DisplayName("Elements with remainder 2")
    fun testElementsWithRemainder2() {
        val nums = intArrayOf(2, 5, 8, 11)
        val result = solution.minimumOperations(nums)
        assertEquals(4, result, "Should return 4 operations (1 operation per element with remainder 2)")
    }

    @Test
    @DisplayName("Mixed elements with different remainders")
    fun testMixedElements() {
        val nums = intArrayOf(1, 2, 3, 4)
        val result = solution.minimumOperations(nums)
        assertEquals(3, result, "Should return 3 operations (1+1+0+1)")
    }

    @Test
    @DisplayName("Single element already divisible by 3")
    fun testSingleElementDivisible() {
        val nums = intArrayOf(9)
        val result = solution.minimumOperations(nums)
        assertEquals(0, result, "Should return 0 operations for single divisible element")
    }

    @Test
    @DisplayName("Single element with remainder 1")
    fun testSingleElementRemainder1() {
        val nums = intArrayOf(4)
        val result = solution.minimumOperations(nums)
        assertEquals(1, result, "Should return 1 operation for element with remainder 1")
    }

    @Test
    @DisplayName("Single element with remainder 2")
    fun testSingleElementRemainder2() {
        val nums = intArrayOf(5)
        val result = solution.minimumOperations(nums)
        assertEquals(1, result, "Should return 1 operation for element with remainder 2")
    }

    @Test
    @DisplayName("Example case 1: [1, 2, 3, 4]")
    fun testExample1() {
        val nums = intArrayOf(1, 2, 3, 4)
        val result = solution.minimumOperations(nums)
        assertEquals(3, result, "Should return 3 operations")
    }

    @Test
    @DisplayName("Example case 2: [3, 6, 9]")
    fun testExample2() {
        val nums = intArrayOf(3, 6, 9)
        val result = solution.minimumOperations(nums)
        assertEquals(0, result, "Should return 0 operations when all elements are divisible by 3")
    }

    @Test
    @DisplayName("Large array with all elements divisible by 3")
    fun testLargeArrayAllDivisible() {
        val nums = IntArray(1000) { (it + 1) * 3 }
        val result = solution.minimumOperations(nums)
        assertEquals(0, result, "Should return 0 operations for large array where all elements are divisible by 3")
    }

    @Test
    @DisplayName("Large array with mixed remainders")
    fun testLargeArrayMixed() {
        val nums = IntArray(100) { it + 1 } // [1, 2, 3, ..., 100]
        val result = solution.minimumOperations(nums)
        // Elements divisible by 3: 33 elements (3, 6, 9, ..., 99) -> 0 operations
        // Elements with remainder 1: 34 elements (1, 4, 7, ..., 100) -> 34 operations
        // Elements with remainder 2: 33 elements (2, 5, 8, ..., 98) -> 33 operations
        // Total: 67 operations
        assertEquals(67, result, "Should return 67 operations for array [1..100]")
    }

    @Test
    @DisplayName("Array with zeros")
    fun testArrayWithZeros() {
        val nums = intArrayOf(0, 0, 0)
        val result = solution.minimumOperations(nums)
        assertEquals(0, result, "Should return 0 operations as 0 is divisible by 3")
    }

    @Test
    @DisplayName("Array with mixed zeros and non-zeros")
    fun testMixedZerosAndNonZeros() {
        val nums = intArrayOf(0, 1, 2, 3)
        val result = solution.minimumOperations(nums)
        assertEquals(2, result, "Should return 2 operations (0+1+1+0)")
    }

    @Test
    @DisplayName("Minimum operations choosing between adding and subtracting")
    fun testMinimumOperationChoice() {
        val nums = intArrayOf(7, 8) // 7 % 3 = 1 (min(1, 2) = 1), 8 % 3 = 2 (min(2, 1) = 1)
        val result = solution.minimumOperations(nums)
        assertEquals(2, result, "Should return 2 operations choosing optimal operation")
    }

    @Test
    @DisplayName("Edge case: very large numbers")
    fun testVeryLargeNumbers() {
        val nums = intArrayOf(1000000, 1000001, 1000002)
        val result = solution.minimumOperations(nums)
        // 1000000 % 3 = 1 -> min(1, 2) = 1
        // 1000001 % 3 = 2 -> min(2, 1) = 1
        // 1000002 % 3 = 0 -> min(0, 3) = 0
        assertEquals(2, result, "Should handle very large numbers correctly")
    }
}
