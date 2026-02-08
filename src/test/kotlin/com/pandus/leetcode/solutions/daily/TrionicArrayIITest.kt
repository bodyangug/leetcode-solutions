package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TrionicArrayIITest {
    private val solution = TrionicArrayII()

    @Test
    @DisplayName("Example 1: [0,-2,-1,-3,0,2,-1] should return -4")
    fun testExample1() {
        val nums = intArrayOf(0, -2, -1, -3, 0, 2, -1)
        val result = solution.maxSumTrionic(nums)
        assertEquals(-4L, result, "Sum of trionic subarray [-2,-1,-3,0,2] should be -4")
    }

    @Test
    @DisplayName("Example 2: [1,4,2,7] should return 14")
    fun testExample2() {
        val nums = intArrayOf(1, 4, 2, 7)
        val result = solution.maxSumTrionic(nums)
        assertEquals(14L, result, "Sum of trionic subarray [1,4,2,7] should be 14")
    }

    @Test
    @DisplayName("Minimal trionic array: [1,2,1,2] should return 6")
    fun testMinimalTrionicArray() {
        val nums = intArrayOf(1, 2, 1, 2)
        val result = solution.maxSumTrionic(nums)
        assertEquals(6L, result, "Sum of minimal trionic subarray [1,2,1,2] should be 6")
    }

    @Test
    @DisplayName("All positive numbers: [1,3,5,2,4,6] should return 21")
    fun testAllPositiveNumbers() {
        val nums = intArrayOf(1, 3, 5, 2, 4, 6)
        val result = solution.maxSumTrionic(nums)
        assertEquals(21L, result, "Sum should be 1+3+5+2+4+6 = 21")
    }

    @Test
    @DisplayName("All negative numbers with valid pattern: [-5,-3,-4,-2] should return -14")
    fun testAllNegativeNumbers() {
        val nums = intArrayOf(-5, -3, -4, -2)
        val result = solution.maxSumTrionic(nums)
        assertEquals(-14L, result, "Sum of trionic subarray with negative numbers")
    }

    @Test
    @DisplayName("Large increasing segment at start: [1,2,3,4,5,2,4] should return 21")
    fun testLargeIncreasingSegmentAtStart() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 2, 4)
        val result = solution.maxSumTrionic(nums)
        assertEquals(21L, result, "Should include extended first segment")
    }

    @Test
    @DisplayName("Large increasing segment at end: [1,3,2,4,5,6,7] should return 28")
    fun testLargeIncreasingSegmentAtEnd() {
        val nums = intArrayOf(1, 3, 2, 4, 5, 6, 7)
        val result = solution.maxSumTrionic(nums)
        assertEquals(28L, result, "Should include extended third segment")
    }

    @Test
    @DisplayName("Deep valley: [1,10,1,2] should return 14")
    fun testDeepValley() {
        val nums = intArrayOf(1, 10, 1, 2)
        val result = solution.maxSumTrionic(nums)
        assertEquals(14L, result, "Sum with deep valley should be 1+10+1+2 = 14")
    }

    @Test
    @DisplayName("High peak: [1,100,50,60] should return 211")
    fun testHighPeak() {
        val nums = intArrayOf(1, 100, 50, 60)
        val result = solution.maxSumTrionic(nums)
        assertEquals(211L, result, "Sum with high peak should be 1+100+50+60 = 211")
    }

    @Test
    @DisplayName("Mixed positive and negative: [2,5,-1,3] should return 9")
    fun testMixedPositiveNegative() {
        val nums = intArrayOf(2, 5, -1, 3)
        val result = solution.maxSumTrionic(nums)
        assertEquals(9L, result, "Sum should be 2+5+(-1)+3 = 9")
    }

    @Test
    @DisplayName("Longer array with single trionic: [1,1,1,2,3,1,2,1,1,1] should return 9")
    fun testLongerArrayWithSingleTrionic() {
        val nums = intArrayOf(1, 1, 1, 2, 3, 1, 2, 1, 1, 1)
        val result = solution.maxSumTrionic(nums)
        assertEquals(9L, result, "Should find the trionic pattern in the middle")
    }

    @Test
    @DisplayName("Zero values in array: [0,1,0,1] should return 2")
    fun testZeroValuesInArray() {
        val nums = intArrayOf(0, 1, 0, 1)
        val result = solution.maxSumTrionic(nums)
        assertEquals(2L, result, "Sum with zeros should be 0+1+0+1 = 2")
    }

    @Test
    @DisplayName("Large values: [1000000,2000000,1000000,3000000] should return 7000000")
    fun testLargeValues() {
        val nums = intArrayOf(1000000, 2000000, 1000000, 3000000)
        val result = solution.maxSumTrionic(nums)
        assertEquals(7000000L, result, "Should handle large values correctly")
    }
}
