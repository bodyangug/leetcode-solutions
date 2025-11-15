package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountTheNumberOfSubstringsWithDominantOnesTest {

    private val solution = CountTheNumberOfSubstringsWithDominantOnes()

    @Test
    @DisplayName("Example 1: s = '00011'")
    fun testExample1() {
        val s = "00011"
        val result = solution.numberOfSubstrings(s)
        assertEquals(5, result, "Should return 5 substrings with dominant ones")
        // Substrings with dominant ones (cnt1 >= cnt0 * cnt0):
        // "1" at index 3, "1" at index 4, "11", "011", "0011"
    }

    @Test
    @DisplayName("Example 2: s = '101101'")
    fun testExample2() {
        val s = "101101"
        val result = solution.numberOfSubstrings(s)
        assertEquals(16, result, "Should return 16 substrings with dominant ones")
    }

    @Test
    @DisplayName("All ones: s = '1111'")
    fun testAllOnes() {
        val s = "1111"
        val result = solution.numberOfSubstrings(s)
        assertEquals(10, result, "All substrings should have dominant ones")
        // All possible substrings of length 1, 2, 3, 4 = 4+3+2+1 = 10
    }

    @Test
    @DisplayName("All zeros: s = '0000'")
    fun testAllZeros() {
        val s = "0000"
        val result = solution.numberOfSubstrings(s)
        assertEquals(0, result, "No substrings should have dominant ones (no ones at all)")
    }

    @Test
    @DisplayName("Single one: s = '1'")
    fun testSingleOne() {
        val s = "1"
        val result = solution.numberOfSubstrings(s)
        assertEquals(1, result, "Single '1' substring has dominant ones")
    }

    @Test
    @DisplayName("Single zero: s = '0'")
    fun testSingleZero() {
        val s = "0"
        val result = solution.numberOfSubstrings(s)
        assertEquals(0, result, "Single '0' substring does not have dominant ones")
    }

    @Test
    @DisplayName("Complex case: s = '11100'")
    fun testComplexCase1() {
        val s = "11100"
        val result = solution.numberOfSubstrings(s)
        assertEquals(9, result, "Multiple substrings with dominant ones")
        // All single '1's (3), all pairs "11" (2), all triples "111" (1),
        // "1110" (2 cnt0, 3 cnt1: 3 >= 4? No), "11100" (2 cnt0, 3 cnt1: No)
        // "110" (1 cnt0, 2 cnt1: 2 >= 1? Yes), "1100" (2 cnt0, 2 cnt1: 2 >= 4? No)
        // Need to verify: 3 + 2 + 1 + 2 (from "110" starting at different positions) + 1 = 9
    }

    @Test
    @DisplayName("Edge case: Long string of ones with one zero: s = '1111101111'")
    fun testLongOnesWithOneZero() {
        val s = "1111101111"
        val result = solution.numberOfSubstrings(s)
        // Most substrings will have dominant ones due to high ratio of ones
        assertEquals(54, result, "Many substrings with dominant ones")
    }
}
