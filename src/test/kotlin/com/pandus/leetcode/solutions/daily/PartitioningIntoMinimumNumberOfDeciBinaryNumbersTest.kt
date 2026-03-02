package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class PartitioningIntoMinimumNumberOfDeciBinaryNumbersTest {
    private val solution = PartitioningIntoMinimumNumberOfDeciBinaryNumbers()

    @Test
    @DisplayName("Example 1: n = \"32\", output = 3")
    fun testExample1() {
        val result = solution.minPartitions("32")
        assertEquals(3, result, "32 can be formed by 10 + 11 + 11, requiring minimum 3 deci-binary numbers")
    }

    @Test
    @DisplayName("Example 2: n = \"82734\", output = 8")
    fun testExample2() {
        val result = solution.minPartitions("82734")
        assertEquals(8, result, "The maximum digit is 8, so we need minimum 8 deci-binary numbers")
    }

    @Test
    @DisplayName("Example 3: n = \"27346209830709182346\", output = 9")
    fun testExample3() {
        val result = solution.minPartitions("27346209830709182346")
        assertEquals(9, result, "The maximum digit is 9, so we need minimum 9 deci-binary numbers")
    }

    @Test
    @DisplayName("Single digit: n = \"1\", output = 1")
    fun testSingleDigitOne() {
        val result = solution.minPartitions("1")
        assertEquals(1, result, "Single digit 1 requires 1 deci-binary number")
    }

    @Test
    @DisplayName("Single digit: n = \"5\", output = 5")
    fun testSingleDigitFive() {
        val result = solution.minPartitions("5")
        assertEquals(5, result, "Single digit 5 requires 5 deci-binary numbers")
    }

    @Test
    @DisplayName("Single digit: n = \"9\", output = 9")
    fun testSingleDigitNine() {
        val result = solution.minPartitions("9")
        assertEquals(9, result, "Single digit 9 requires 9 deci-binary numbers (maximum possible)")
    }

    @Test
    @DisplayName("All zeros except one: n = \"10000\", output = 1")
    fun testTrailingZeros() {
        val result = solution.minPartitions("10000")
        assertEquals(1, result, "Maximum digit is 1, so we need minimum 1 deci-binary number")
    }

    @Test
    @DisplayName("Two digits: n = \"11\", output = 1")
    fun testTwoOnes() {
        val result = solution.minPartitions("11")
        assertEquals(1, result, "11 = 11 (one deci-binary number)")
    }

    @Test
    @DisplayName("Two digits: n = \"99\", output = 9")
    fun testTwoNines() {
        val result = solution.minPartitions("99")
        assertEquals(9, result, "Maximum digit is 9, so we need minimum 9 deci-binary numbers")
    }

    @Test
    @DisplayName("Increasing digits: n = \"123456789\", output = 9")
    fun testIncreasingDigits() {
        val result = solution.minPartitions("123456789")
        assertEquals(9, result, "Maximum digit is 9, so we need minimum 9 deci-binary numbers")
    }

    @Test
    @DisplayName("Decreasing digits: n = \"987654321\", output = 9")
    fun testDecreasingDigits() {
        val result = solution.minPartitions("987654321")
        assertEquals(9, result, "Maximum digit is 9, so we need minimum 9 deci-binary numbers")
    }

    @Test
    @DisplayName("Maximum at the beginning: n = \"9111\", output = 9")
    fun testMaxAtBeginning() {
        val result = solution.minPartitions("9111")
        assertEquals(9, result, "Maximum digit is 9 at the beginning")
    }

    @Test
    @DisplayName("Maximum at the end: n = \"1119\", output = 9")
    fun testMaxAtEnd() {
        val result = solution.minPartitions("1119")
        assertEquals(9, result, "Maximum digit is 9 at the end")
    }

    @Test
    @DisplayName("Maximum in the middle: n = \"11911\", output = 9")
    fun testMaxInMiddle() {
        val result = solution.minPartitions("11911")
        assertEquals(9, result, "Maximum digit is 9 in the middle")
    }

    @Test
    @DisplayName("All same digits: n = \"7777\", output = 7")
    fun testAllSameDigits() {
        val result = solution.minPartitions("7777")
        assertEquals(7, result, "All digits are 7, so we need minimum 7 deci-binary numbers")
    }

    @Test
    @DisplayName("Small number: n = \"100\", output = 1")
    fun testSmallNumberWithZeros() {
        val result = solution.minPartitions("100")
        assertEquals(1, result, "Maximum digit is 1")
    }

    @Test
    @DisplayName("Large number with max digit 6: n = \"654321\", output = 6")
    fun testLargeNumberMaxSix() {
        val result = solution.minPartitions("654321")
        assertEquals(6, result, "Maximum digit is 6")
    }

    @Test
    @DisplayName("Long number with small digits: n = \"1111111111111111\", output = 1")
    fun testLongNumberSmallDigits() {
        val result = solution.minPartitions("1111111111111111")
        assertEquals(1, result, "Even though it's a long number, maximum digit is only 1")
    }

    @Test
    @DisplayName("Number with leading digit less than max: n = \"12345678901234567890\", output = 9")
    fun testVeryLongNumber() {
        val result = solution.minPartitions("12345678901234567890")
        assertEquals(9, result, "Very long number with maximum digit 9")
    }
}
