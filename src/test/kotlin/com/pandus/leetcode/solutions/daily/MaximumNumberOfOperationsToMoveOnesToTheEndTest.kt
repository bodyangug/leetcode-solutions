package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximumNumberOfOperationsToMoveOnesToTheEndTest {

    private val solution = MaximumNumberOfOperationsToMoveOnesToTheEnd()

    @Test
    @DisplayName("Example 1: s = '1001101'")
    fun testExample1() {
        val s = "1001101"
        val result = solution.maxOperations(s)
        assertEquals(4, result, "Should return 4 operations")
        // Explanation: Moving ones past zeros:
        // - "1001101" -> first '1' needs to move past 2 zeros (but counted per group)
        // - Count of ones before first zero group: 1, operations: 1
        // - Count of ones before second zero: 3, operations: 3
        // Total: 1 + 3 = 4
    }

    @Test
    @DisplayName("Example 2: s = '00111'")
    fun testExample2() {
        val s = "00111"
        val result = solution.maxOperations(s)
        assertEquals(0, result, "Should return 0 operations (all ones already at the end)")
    }

    @Test
    @DisplayName("Simple case: s = '10'")
    fun testSimpleCase() {
        val s = "10"
        val result = solution.maxOperations(s)
        assertEquals(1, result, "Should return 1 operation (one '1' moves past one '0')")
    }

    @Test
    @DisplayName("Multiple ones before single zero: s = '1110'")
    fun testMultipleOnesBeforeSingleZero() {
        val s = "1110"
        val result = solution.maxOperations(s)
        assertEquals(3, result, "Should return 3 operations (three '1's move past one '0')")
    }

    @Test
    @DisplayName("Alternating ones and zeros: s = '10101'")
    fun testAlternatingOnesAndZeros() {
        val s = "10101"
        val result = solution.maxOperations(s)
        assertEquals(3, result, "Should return 3 operations")
        // Step by step: 1 one before first zero (1 op), 2 ones before second zero (2 ops), total: 3
    }

    @Test
    @DisplayName("All ones: s = '1111'")
    fun testAllOnes() {
        val s = "1111"
        val result = solution.maxOperations(s)
        assertEquals(0, result, "Should return 0 operations (no zeros to move past)")
    }

    @Test
    @DisplayName("All zeros: s = '0000'")
    fun testAllZeros() {
        val s = "0000"
        val result = solution.maxOperations(s)
        assertEquals(0, result, "Should return 0 operations (no ones to move)")
    }

    @Test
    @DisplayName("Single character - one: s = '1'")
    fun testSingleOne() {
        val s = "1"
        val result = solution.maxOperations(s)
        assertEquals(0, result, "Should return 0 operations (single character)")
    }

    @Test
    @DisplayName("Single character - zero: s = '0'")
    fun testSingleZero() {
        val s = "0"
        val result = solution.maxOperations(s)
        assertEquals(0, result, "Should return 0 operations (single character)")
    }

    @Test
    @DisplayName("Ones at start, zeros at end: s = '111000'")
    fun testOnesAtStartZerosAtEnd() {
        val s = "111000"
        val result = solution.maxOperations(s)
        assertEquals(3, result, "Should return 3 operations (three ones move past zero group)")
    }

    @Test
    @DisplayName("Pattern with trailing one: s = '100101'")
    fun testPatternWithTrailingOne() {
        val s = "100101"
        val result = solution.maxOperations(s)
        assertEquals(3, result, "Should return 3 operations")
    }

    @Test
    @DisplayName("Two ones separated by zeros: s = '1000001'")
    fun testTwoOnesSeparatedByZeros() {
        val s = "1000001"
        val result = solution.maxOperations(s)
        assertEquals(1, result, "Should return 1 operation")
        // 1 one before zeros: 1 op, then another one at the end (no more zeros after)
    }

    @Test
    @DisplayName("Edge case: Long string with pattern: s = '10101010'")
    fun testLongAlternatingPattern() {
        val s = "10101010"
        val result = solution.maxOperations(s)
        assertEquals(10, result, "Should return 10 operations")
        // 1+2+3+4 = 10 operations
    }
}
