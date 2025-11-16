package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NumberOfSubstringsWithOnly1sTest {

    private val solution = NumberOfSubstringsWithOnly1s()

    @Test
    @DisplayName("Example 1: s = '0110111'")
    fun testExample1() {
        val s = "0110111"
        val result = solution.numSub(s)
        assertEquals(9, result, "Should return 9 substrings with only 1s")
        // Substrings: "1" (index 1), "1" (index 2), "11", "1" (index 4), "1" (index 5), "11", "111", "1" (index 6), "11"
        // Count: 2 (from "11") + 3 (from "111") + 1 (from "1") + 1 (from "1") + 2 (from "11") = 9
    }

    @Test
    @DisplayName("Example 2: s = '101'")
    fun testExample2() {
        val s = "101"
        val result = solution.numSub(s)
        assertEquals(2, result, "Should return 2 substrings with only 1s")
        // Substrings: "1" at index 0, "1" at index 2
    }

    @Test
    @DisplayName("Example 3: s = '111111'")
    fun testExample3() {
        val s = "111111"
        val result = solution.numSub(s)
        assertEquals(21, result, "Should return 21 substrings with only 1s")
        // n = 6, count = 6 * 7 / 2 = 21
    }

    @Test
    @DisplayName("All zeros: s = '0000'")
    fun testAllZeros() {
        val s = "0000"
        val result = solution.numSub(s)
        assertEquals(0, result, "No substrings with only 1s")
    }

    @Test
    @DisplayName("Single one: s = '1'")
    fun testSingleOne() {
        val s = "1"
        val result = solution.numSub(s)
        assertEquals(1, result, "Single '1' substring")
    }

    @Test
    @DisplayName("Single zero: s = '0'")
    fun testSingleZero() {
        val s = "0"
        val result = solution.numSub(s)
        assertEquals(0, result, "No substrings with only 1s")
    }

    @Test
    @DisplayName("Alternating pattern: s = '10101'")
    fun testAlternatingPattern() {
        val s = "10101"
        val result = solution.numSub(s)
        assertEquals(3, result, "Three separate single '1' substrings")
    }

    @Test
    @DisplayName("Trailing ones: s = '00111'")
    fun testTrailingOnes() {
        val s = "00111"
        val result = solution.numSub(s)
        assertEquals(6, result, "Should count substrings from trailing group of 1s")
        // Group "111": 3*4/2 = 6 substrings
    }

    @Test
    @DisplayName("Leading ones: s = '11100'")
    fun testLeadingOnes() {
        val s = "11100"
        val result = solution.numSub(s)
        assertEquals(6, result, "Should count substrings from leading group of 1s")
        // Group "111": 3*4/2 = 6 substrings
    }

    @Test
    @DisplayName("Mixed pattern with multiple groups: s = '1101101110'")
    fun testMixedPattern() {
        val s = "1101101110"
        val result = solution.numSub(s)
        // Groups: "11" (3), "11" (3), "111" (6), "0"
        // Total: 3 + 3 + 6 = 12
        assertEquals(12, result, "Should count all groups correctly")
    }

    @Test
    @DisplayName("Edge case: very long string with modulo")
    fun testModuloEdgeCase() {
        // Create a string with groups that will test modulo operations
        val s = "1".repeat(50000) + "0" + "1".repeat(50000)
        val result = solution.numSub(s)
        // Each group: 50000 * 50001 / 2 = 1250025000
        // Two groups: 2 * 1250025000 = 2500050000
        // 2500050000 % 1000000007 = 500049986
        assertEquals(500049986, result, "Should handle multiple large groups with modulo")
    }
}
