package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TotalWavinessOfNumbersInRangeITest {
    private val solution = TotalWavinessOfNumbersInRangeI()

    @Test
    @DisplayName("Example 1: num1 = 120, num2 = 130, output = 3")
    fun testExample1() {
        val result = solution.totalWaviness(120, 130)
        assertEquals(3, result)
    }

    @Test
    @DisplayName("Example 2: num1 = 198, num2 = 202, output = 3")
    fun testExample2() {
        val result = solution.totalWaviness(198, 202)
        assertEquals(3, result)
    }

    @Test
    @DisplayName("Example 3: num1 = 4848, num2 = 4848, output = 2")
    fun testExample3() {
        val result = solution.totalWaviness(4848, 4848)
        assertEquals(2, result)
    }

    @Test
    @DisplayName("Single digit numbers have waviness 0")
    fun testSingleDigit() {
        val result = solution.totalWaviness(1, 9)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("Two digit numbers have waviness 0")
    fun testTwoDigits() {
        val result = solution.totalWaviness(10, 99)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("Single number with no waviness")
    fun testSingleNumberNoWaviness() {
        val result = solution.totalWaviness(123, 123)
        assertEquals(0, result, "123 has no peaks or valleys since digits are strictly increasing")
    }

    @Test
    @DisplayName("Single number with equal adjacent digits")
    fun testEqualAdjacentDigits() {
        val result = solution.totalWaviness(111, 111)
        assertEquals(0, result, "111 has no peaks or valleys since digits are equal")
    }
}
