package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumChangesToMakeAlternatingBinaryStringTest {
    private val solution = MinimumChangesToMakeAlternatingBinaryString()

    @Test
    fun testExample1() {
        // Input: s = "0100", Output: 1
        // Change last character to '1' -> "0101"
        assertEquals(1, solution.minOperations("0100"))
    }

    @Test
    fun testExample2() {
        // Input: s = "10", Output: 0
        // Already alternating
        assertEquals(0, solution.minOperations("10"))
    }

    @Test
    fun testExample3() {
        // Input: s = "1111", Output: 2
        // Need two operations to reach "0101" or "1010"
        assertEquals(2, solution.minOperations("1111"))
    }

    @Test
    fun testAllZeros() {
        // "0000" -> "0101" requires 2 changes
        assertEquals(2, solution.minOperations("0000"))
    }

    @Test
    fun testAlternatingStartingWithZero() {
        // "0101" is already alternating
        assertEquals(0, solution.minOperations("0101"))
    }

    @Test
    fun testAlternatingStartingWithOne() {
        // "1010" is already alternating
        assertEquals(0, solution.minOperations("1010"))
    }

    @Test
    fun testSingleCharacterZero() {
        // Single "0" is alternating
        assertEquals(0, solution.minOperations("0"))
    }

    @Test
    fun testSingleCharacterOne() {
        // Single "1" is alternating
        assertEquals(0, solution.minOperations("1"))
    }

    @Test
    fun testTwoCharactersSame() {
        // "00" -> "01" or "10" requires 1 change
        assertEquals(1, solution.minOperations("00"))
        // "11" -> "01" or "10" requires 1 change
        assertEquals(1, solution.minOperations("11"))
    }

    @Test
    fun testLongerString() {
        // "00110011" - mixed pattern
        assertEquals(4, solution.minOperations("00110011"))
    }
}
