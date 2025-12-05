package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountPartitionsWithEvenSumDifferenceTest {
    private val solver = CountPartitionsWithEvenSumDifference()

    // ==================== Example test cases ====================

    @Test
    @DisplayName("Example 1: nums = [10,10,3,7,6] -> 4 partitions")
    fun countPartitions_example1() {
        val nums = intArrayOf(10, 10, 3, 7, 6)
        val result = solver.countPartitions(nums)
        assertEquals(4, result)
        // Total sum = 36 (even), so all partitions have even difference
        // Partitions:
        // [10] | [10,3,7,6]: 10 - 26 = -16 (even)
        // [10,10] | [3,7,6]: 20 - 16 = 4 (even)
        // [10,10,3] | [7,6]: 23 - 13 = 10 (even)
        // [10,10,3,7] | [6]: 30 - 6 = 24 (even)
    }

    @Test
    @DisplayName("Example 2: nums = [1,2,2] -> 0 partitions")
    fun countPartitions_example2() {
        val nums = intArrayOf(1, 2, 2)
        val result = solver.countPartitions(nums)
        assertEquals(0, result)
        // Total sum = 5 (odd), no partition has even difference
    }

    @Test
    @DisplayName("Example 3: nums = [2,4,6,8] -> 3 partitions")
    fun countPartitions_example3() {
        val nums = intArrayOf(2, 4, 6, 8)
        val result = solver.countPartitions(nums)
        assertEquals(3, result)
        // Total sum = 20 (even), all partitions have even difference
        // Partitions:
        // [2] | [4,6,8]: 2 - 18 = -16 (even)
        // [2,4] | [6,8]: 6 - 14 = -8 (even)
        // [2,4,6] | [8]: 12 - 8 = 4 (even)
    }

    // ==================== Edge cases ====================

    @Test
    @DisplayName("Edge case: Single element array")
    fun countPartitions_singleElement() {
        val nums = intArrayOf(5)
        val result = solver.countPartitions(nums)
        assertEquals(0, result)
        // Can't partition a single element (n-1 = 0)
    }

    @Test
    @DisplayName("Edge case: Two elements with even sum")
    fun countPartitions_twoElements_evenSum() {
        val nums = intArrayOf(2, 4)
        val result = solver.countPartitions(nums)
        assertEquals(1, result)
        // Total sum = 6 (even), only 1 partition: [2] | [4]
    }

    @Test
    @DisplayName("Edge case: Two elements with odd sum")
    fun countPartitions_twoElements_oddSum() {
        val nums = intArrayOf(1, 4)
        val result = solver.countPartitions(nums)
        assertEquals(0, result)
        // Total sum = 5 (odd), no valid partitions
    }

    @Test
    @DisplayName("Edge case: All zeros")
    fun countPartitions_allZeros() {
        val nums = intArrayOf(0, 0, 0, 0)
        val result = solver.countPartitions(nums)
        assertEquals(3, result)
        // Total sum = 0 (even), all partitions valid
    }

    @Test
    @DisplayName("Edge case: All same even numbers")
    fun countPartitions_allSameEven() {
        val nums = intArrayOf(4, 4, 4, 4)
        val result = solver.countPartitions(nums)
        assertEquals(3, result)
        // Total sum = 16 (even), all partitions valid
    }

    @Test
    @DisplayName("Edge case: All same odd numbers")
    fun countPartitions_allSameOdd() {
        val nums = intArrayOf(3, 3, 3)
        val result = solver.countPartitions(nums)
        assertEquals(0, result)
        // Total sum = 9 (odd), no valid partitions
    }

    // ==================== Total sum even cases ====================

    @Test
    @DisplayName("Even sum: All even numbers")
    fun countPartitions_evenSum_allEvenNumbers() {
        val nums = intArrayOf(2, 4, 6, 8, 10)
        val result = solver.countPartitions(nums)
        assertEquals(4, result)
        // Total sum = 30 (even), all 4 partitions valid
    }

    @Test
    @DisplayName("Even sum: Mix of even and odd numbers (even count of odds)")
    fun countPartitions_evenSum_evenCountOfOdds() {
        val nums = intArrayOf(1, 3, 2, 4)
        val result = solver.countPartitions(nums)
        assertEquals(3, result)
        // Total sum = 10 (even), all 3 partitions valid
    }

    @Test
    @DisplayName("Even sum: Large array")
    fun countPartitions_evenSum_largeArray() {
        val nums = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)
        val result = solver.countPartitions(nums)
        assertEquals(7, result)
        // Total sum = 8 (even), all 7 partitions valid
    }

    // ==================== Total sum odd cases ====================

    @Test
    @DisplayName("Odd sum: All odd numbers (odd count)")
    fun countPartitions_oddSum_allOddNumbers() {
        val nums = intArrayOf(1, 3, 5)
        val result = solver.countPartitions(nums)
        assertEquals(0, result)
        // Total sum = 9 (odd), no valid partitions
    }

    @Test
    @DisplayName("Odd sum: Mix of even and odd numbers (odd count of odds)")
    fun countPartitions_oddSum_oddCountOfOdds() {
        val nums = intArrayOf(1, 2, 4)
        val result = solver.countPartitions(nums)
        assertEquals(0, result)
        // Total sum = 7 (odd), no valid partitions
    }

    @Test
    @DisplayName("Odd sum: Single odd with evens")
    fun countPartitions_oddSum_singleOdd() {
        val nums = intArrayOf(2, 4, 6, 1)
        val result = solver.countPartitions(nums)
        assertEquals(0, result)
        // Total sum = 13 (odd), no valid partitions
    }

    // ==================== Mathematical verification ====================

    @Test
    @DisplayName("Verify: Left sum even, right sum even -> difference even")
    fun countPartitions_bothSumsEven() {
        val nums = intArrayOf(4, 6, 8, 2)
        val result = solver.countPartitions(nums)
        assertEquals(3, result)
        // Total = 20 (even)
        // For any partition: left + right = 20 (even)
        // If left is even, then right must be even (even - even = even)
    }

    @Test
    @DisplayName("Verify: Left sum odd, right sum odd -> difference even")
    fun countPartitions_bothSumsOdd() {
        val nums = intArrayOf(3, 5, 2, 4)
        val result = solver.countPartitions(nums)
        assertEquals(3, result)
        // Total = 14 (even)
        // For any partition: left + right = 14 (even)
        // If left is odd, then right must be odd (odd - odd = even)
    }

    // ==================== Boundary cases ====================

    @Test
    @DisplayName("Boundary: Maximum size array with even sum")
    fun countPartitions_maxSize_evenSum() {
        val nums = IntArray(100) { 2 }
        val result = solver.countPartitions(nums)
        assertEquals(99, result)
        // Total sum = 200 (even), all 99 partitions valid
    }

    @Test
    @DisplayName("Boundary: Maximum size array with odd sum")
    fun countPartitions_maxSize_oddSum() {
        val nums = IntArray(100) { if (it == 0) 1 else 2 }
        val result = solver.countPartitions(nums)
        assertEquals(0, result)
        // Total sum = 1 + 198 = 199 (odd), no valid partitions
    }

    @Test
    @DisplayName("Boundary: Large values with even sum")
    fun countPartitions_largeValues_evenSum() {
        val nums = intArrayOf(1000, 2000, 3000)
        val result = solver.countPartitions(nums)
        assertEquals(2, result)
        // Total sum = 6000 (even), all 2 partitions valid
    }

    @Test
    @DisplayName("Boundary: Large values with odd sum")
    fun countPartitions_largeValues_oddSum() {
        val nums = intArrayOf(1000, 2000, 3001)
        val result = solver.countPartitions(nums)
        assertEquals(0, result)
        // Total sum = 6001 (odd), no valid partitions
    }

    // ==================== Pattern verification ====================

    @Test
    @DisplayName("Pattern: Result is always 0 or n-1")
    fun countPartitions_verifyPattern_case1() {
        val nums = intArrayOf(5, 7, 9, 11)
        val result = solver.countPartitions(nums)
        // Total sum = 32 (even), expected n-1 = 3
        assertEquals(3, result)
    }

    @Test
    @DisplayName("Pattern: Result is always 0 or n-1")
    fun countPartitions_verifyPattern_case2() {
        val nums = intArrayOf(5, 7, 9)
        val result = solver.countPartitions(nums)
        // Total sum = 21 (odd), expected 0
        assertEquals(0, result)
    }

    @Test
    @DisplayName("Pattern: Negative numbers with even sum")
    fun countPartitions_negativeNumbers_evenSum() {
        val nums = intArrayOf(-2, 4, 6)
        val result = solver.countPartitions(nums)
        assertEquals(2, result)
        // Total sum = 8 (even), all 2 partitions valid
    }

    @Test
    @DisplayName("Pattern: Negative numbers with odd sum")
    fun countPartitions_negativeNumbers_oddSum() {
        val nums = intArrayOf(-1, 4, 6)
        val result = solver.countPartitions(nums)
        assertEquals(0, result)
        // Total sum = 9 (odd), no valid partitions
    }

    @Test
    @DisplayName("Pattern: Mixed positive and negative with even sum")
    fun countPartitions_mixedSigns_evenSum() {
        val nums = intArrayOf(-5, 3, 8, -2)
        val result = solver.countPartitions(nums)
        assertEquals(3, result)
        // Total sum = 4 (even), all 3 partitions valid
    }

    @Test
    @DisplayName("Pattern: Mixed positive and negative with odd sum")
    fun countPartitions_mixedSigns_oddSum() {
        val nums = intArrayOf(-5, 3, 8, -1)
        val result = solver.countPartitions(nums)
        assertEquals(0, result)
        // Total sum = 5 (odd), no valid partitions
    }
}
