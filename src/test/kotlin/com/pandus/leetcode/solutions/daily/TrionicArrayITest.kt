package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TrionicArrayITest {
    private val solution = TrionicArrayI()

    @Test
    @DisplayName("Example 1: [1,3,5,4,2,6] should return true")
    fun testExample1() {
        val nums = intArrayOf(1, 3, 5, 4, 2, 6)
        val result = solution.isTrionic(nums)
        assertEquals(true, result, "Should return true with p=2, q=4")
    }

    @Test
    @DisplayName("Example 2: [2,1,3] should return false")
    fun testExample2() {
        val nums = intArrayOf(2, 1, 3)
        val result = solution.isTrionic(nums)
        assertEquals(false, result, "Should return false - no valid p and q exist")
    }

    @Test
    @DisplayName("Strictly increasing only: [1,2,3,4,5] should return false")
    fun testStrictlyIncreasing() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val result = solution.isTrionic(nums)
        assertEquals(false, result, "Should return false - no decreasing segment")
    }

    @Test
    @DisplayName("Strictly decreasing only: [5,4,3,2,1] should return false")
    fun testStrictlyDecreasing() {
        val nums = intArrayOf(5, 4, 3, 2, 1)
        val result = solution.isTrionic(nums)
        assertEquals(false, result, "Should return false - no initial increasing segment")
    }

    @Test
    @DisplayName("Peak without final increase: [1,2,3,2,1] should return false")
    fun testPeakWithoutFinalIncrease() {
        val nums = intArrayOf(1, 2, 3, 2, 1)
        val result = solution.isTrionic(nums)
        assertEquals(false, result, "Should return false - no final increasing segment")
    }

    @Test
    @DisplayName("Valid trionic with minimal segments: [1,2,1,2] should return true")
    fun testMinimalTrionic() {
        val nums = intArrayOf(1, 2, 1, 2)
        val result = solution.isTrionic(nums)
        assertEquals(true, result, "Should return true - minimal valid trionic array")
    }

    @Test
    @DisplayName("Larger valid trionic: [1,2,3,4,3,2,1,2,3,4] should return true")
    fun testLargerValidTrionic() {
        val nums = intArrayOf(1, 2, 3, 4, 3, 2, 1, 2, 3, 4)
        val result = solution.isTrionic(nums)
        assertEquals(true, result, "Should return true - larger valid trionic array")
    }

    @Test
    @DisplayName("Valley pattern: [3,2,1,2,3] should return false")
    fun testValleyPattern() {
        val nums = intArrayOf(3, 2, 1, 2, 3)
        val result = solution.isTrionic(nums)
        assertEquals(false, result, "Should return false - valley pattern is not trionic")
    }

    @Test
    @DisplayName("Equal consecutive elements: [1,1,2,1,2] should return false")
    fun testEqualConsecutiveElements() {
        val nums = intArrayOf(1, 1, 2, 1, 2)
        val result = solution.isTrionic(nums)
        assertEquals(false, result, "Should return false - equal elements break strict ordering")
    }

    @Test
    @DisplayName("Two element array: [1,2] should return false")
    fun testTwoElementArray() {
        val nums = intArrayOf(1, 2)
        val result = solution.isTrionic(nums)
        assertEquals(false, result, "Should return false - too short to have all three segments")
    }

    @Test
    @DisplayName("Three element peak: [1,3,2] should return false")
    fun testThreeElementPeak() {
        val nums = intArrayOf(1, 3, 2)
        val result = solution.isTrionic(nums)
        assertEquals(false, result, "Should return false - missing final increasing segment")
    }

    @Test
    @DisplayName("Four element valid trionic: [1,3,2,4] should return true")
    fun testFourElementTrionic() {
        val nums = intArrayOf(1, 3, 2, 4)
        val result = solution.isTrionic(nums)
        assertEquals(true, result, "Should return true - valid trionic with 4 elements")
    }
}
