package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximumProductOfThreeNumbersTest {
    private val solution = MaximumProductOfThreeNumbers()

    @Test
    @DisplayName("Example 1: nums = [1,2,3], output = 6")
    fun testExample1() {
        val result = solution.maximumProduct(intArrayOf(1, 2, 3))
        assertEquals(6, result)
    }

    @Test
    @DisplayName("Example 2: nums = [1,2,3,4], output = 24")
    fun testExample2() {
        val result = solution.maximumProduct(intArrayOf(1, 2, 3, 4))
        assertEquals(24, result)
    }

    @Test
    @DisplayName("Example 3: nums = [-1,-2,-3], output = -6")
    fun testExample3() {
        val result = solution.maximumProduct(intArrayOf(-1, -2, -3))
        assertEquals(-6, result)
    }

    @Test
    @DisplayName("Two negatives and one positive produce larger product")
    fun testTwoNegativesOnePositive() {
        val result = solution.maximumProduct(intArrayOf(-4, -3, 1, 2, 5))
        assertEquals(60, result)
    }

    @Test
    @DisplayName("All negative numbers")
    fun testAllNegative() {
        val result = solution.maximumProduct(intArrayOf(-5, -4, -3, -2, -1))
        assertEquals(-6, result)
    }

    @Test
    @DisplayName("Mix of negative and positive with zero")
    fun testWithZero() {
        val result = solution.maximumProduct(intArrayOf(-3, -2, 0, 1, 2))
        assertEquals(12, result)
    }

    @Test
    @DisplayName("Minimum size array of three elements")
    fun testMinimumSize() {
        val result = solution.maximumProduct(intArrayOf(5, 6, 7))
        assertEquals(210, result)
    }

    @Test
    @DisplayName("Large negative numbers with one positive")
    fun testLargeNegativesWithPositive() {
        val result = solution.maximumProduct(intArrayOf(-1000, -999, 1, 2, 3))
        assertEquals(2997000, result)
    }
}
