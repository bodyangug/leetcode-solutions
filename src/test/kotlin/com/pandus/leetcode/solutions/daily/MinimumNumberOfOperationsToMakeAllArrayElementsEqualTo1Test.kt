package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1Test {

    private val solution = MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1()

    @Test
    @DisplayName("Array with all elements already 1")
    fun testAllOnes() {
        val nums = intArrayOf(1, 1, 1, 1)
        val result = solution.minOperations(nums)
        assertEquals(0, result, "Should return 0 when all elements are already 1")
    }

    @Test
    @DisplayName("Array with single 1 and other elements")
    fun testSingleOne() {
        val nums = intArrayOf(1, 5)
        val result = solution.minOperations(nums)
        assertEquals(1, result, "Should return 1 operation to make all elements 1")
    }

    @Test
    @DisplayName("Basic case with coprime numbers")
    fun testBasicCoprime() {
        val nums = intArrayOf(2, 6, 3, 4)
        val result = solution.minOperations(nums)
        assertEquals(4, result, "Should find minimum operations for coprime array")
    }

    @Test
    @DisplayName("Array where GCD of all elements is not 1 - impossible case")
    fun testImpossibleCase() {
        val nums = intArrayOf(2, 6, 4, 8)
        val result = solution.minOperations(nums)
        assertEquals(-1, result, "Should return -1 when GCD of all elements is not 1")
    }

    @Test
    @DisplayName("Array with all even numbers - impossible")
    fun testAllEvenNumbers() {
        val nums = intArrayOf(4, 8, 12, 16)
        val result = solution.minOperations(nums)
        assertEquals(-1, result, "Should return -1 for all even numbers")
    }

    @Test
    @DisplayName("Array with GCD greater than 1 - impossible")
    fun testCommonDivisor() {
        val nums = intArrayOf(3, 9, 6, 12)
        val result = solution.minOperations(nums)
        assertEquals(-1, result, "Should return -1 when all numbers share common divisor > 1")
    }

    @Test
    @DisplayName("Single element array with 1")
    fun testSingleElementOne() {
        val nums = intArrayOf(1)
        val result = solution.minOperations(nums)
        assertEquals(0, result, "Should return 0 for single element that is 1")
    }

    @Test
    @DisplayName("Single element array not equal to 1")
    fun testSingleElementNotOne() {
        val nums = intArrayOf(5)
        val result = solution.minOperations(nums)
        assertEquals(-1, result, "Should return -1 for single element not equal to 1")
    }

    @Test
    @DisplayName("Two elements that are coprime")
    fun testTwoCoprimeElements() {
        val nums = intArrayOf(2, 3)
        val result = solution.minOperations(nums)
        assertEquals(2, result, "Should return 2 operations for two coprime numbers")
    }

    @Test
    @DisplayName("Array with multiple 1s")
    fun testMultipleOnes() {
        val nums = intArrayOf(1, 1, 2, 3)
        val result = solution.minOperations(nums)
        assertEquals(2, result, "Should count existing 1s and calculate remaining operations")
    }

    @Test
    @DisplayName("Array with 1 at the end")
    fun testOneAtEnd() {
        val nums = intArrayOf(3, 5, 1)
        val result = solution.minOperations(nums)
        assertEquals(2, result, "Should handle 1 at any position in array")
    }

    @Test
    @DisplayName("Array with adjacent coprime numbers")
    fun testAdjacentCoprime() {
        val nums = intArrayOf(3, 5, 7)
        val result = solution.minOperations(nums)
        assertEquals(3, result, "Should find minimum window for coprime adjacent pairs")
    }

    @Test
    @DisplayName("Large array with coprime elements")
    fun testLargeArrayCoprime() {
        val nums = intArrayOf(2, 3, 5, 7, 11, 13)
        val result = solution.minOperations(nums)
        assertEquals(6, result, "Should handle larger arrays with prime numbers")
    }

    @Test
    @DisplayName("Array requiring window of size 2")
    fun testWindowSize2() {
        val nums = intArrayOf(4, 6, 9)
        val result = solution.minOperations(nums)
        assertEquals(4, result, "Should find minimum window size of 2 for GCD = 1")
    }

    @Test
    @DisplayName("Array with powers of 2 and odd number")
    fun testPowersOfTwoWithOdd() {
        val nums = intArrayOf(2, 4, 8, 3)
        val result = solution.minOperations(nums)
        assertEquals(4, result, "Should handle powers of 2 with coprime odd number")
    }

    @Test
    @DisplayName("Array needing full window to achieve GCD 1")
    fun testFullWindowNeeded() {
        val nums = intArrayOf(6, 10, 15)
        val result = solution.minOperations(nums)
        assertEquals(4, result, "Should use full window when smaller windows don't yield GCD 1")
    }

    @Test
    @DisplayName("Mixed 1s and other coprime numbers")
    fun testMixedOnesAndCoprime() {
        val nums = intArrayOf(1, 2, 1, 3, 1)
        val result = solution.minOperations(nums)
        assertEquals(2, result, "Should efficiently use existing 1s")
    }

    @Test
    @DisplayName("Array with consecutive integers")
    fun testConsecutiveIntegers() {
        val nums = intArrayOf(4, 5, 6, 7)
        val result = solution.minOperations(nums)
        assertEquals(4, result, "Should handle consecutive integers (always coprime)")
    }

    @Test
    @DisplayName("Two identical coprime-to-others numbers")
    fun testIdenticalNumbers() {
        val nums = intArrayOf(5, 5, 2)
        val result = solution.minOperations(nums)
        assertEquals(3, result, "Should handle duplicate numbers correctly")
    }

    @Test
    @DisplayName("Array where first two elements are coprime")
    fun testFirstTwoCoprime() {
        val nums = intArrayOf(2, 3, 6, 12)
        val result = solution.minOperations(nums)
        assertEquals(4, result, "Should find coprime pair at start of array")
    }
}

