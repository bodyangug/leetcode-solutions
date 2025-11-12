package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OnesAndZeroesTest {

    private val solution = OnesAndZeroes()

    @Test
    @DisplayName("Basic case with small subset")
    fun testBasicCase() {
        val strs = arrayOf("10", "0001", "111001", "1", "0")
        val m = 5
        val n = 3
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(4, result, "Should select 4 strings: '10', '0001', '1', '0'")
    }

    @Test
    @DisplayName("Case with limited zeros")
    fun testLimitedZeros() {
        val strs = arrayOf("10", "0", "1")
        val m = 1
        val n = 1
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(2, result, "Should select 2 strings: '0' and '1'")
    }

    @Test
    @DisplayName("Single string that fits")
    fun testSingleStringFits() {
        val strs = arrayOf("0011")
        val m = 2
        val n = 2
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(1, result, "Should select the single string")
    }

    @Test
    @DisplayName("Single string that doesn't fit")
    fun testSingleStringDoesNotFit() {
        val strs = arrayOf("0011")
        val m = 1
        val n = 1
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(0, result, "Should not select any string as it exceeds limits")
    }

    @Test
    @DisplayName("Empty array")
    fun testEmptyArray() {
        val strs = arrayOf<String>()
        val m = 5
        val n = 3
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(0, result, "Should return 0 for empty array")
    }

    @Test
    @DisplayName("All strings are only zeros")
    fun testAllZeros() {
        val strs = arrayOf("0", "00", "000")
        val m = 5
        val n = 0
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(2, result, "Should select all strings with zeros only")
    }

    @Test
    @DisplayName("All strings are only ones")
    fun testAllOnes() {
        val strs = arrayOf("1", "11", "111")
        val m = 0
        val n = 6
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(3, result, "Should select all strings with ones only")
    }

    @Test
    @DisplayName("Zero capacity for both m and n")
    fun testZeroCapacity() {
        val strs = arrayOf("0", "1", "01")
        val m = 0
        val n = 0
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(0, result, "Should return 0 when no capacity available")
    }

    @Test
    @DisplayName("Large capacity allows all strings")
    fun testLargeCapacity() {
        val strs = arrayOf("10", "0001", "111001", "1", "0")
        val m = 100
        val n = 100
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(5, result, "Should select all strings when capacity is large enough")
    }

    @Test
    @DisplayName("Optimal selection requires skipping some strings")
    fun testOptimalSelection() {
        val strs = arrayOf("0", "1", "0", "1", "0", "1")
        val m = 3
        val n = 3
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(6, result, "Should select all 6 single-character strings")
    }

    @Test
    @DisplayName("Long strings vs short strings tradeoff")
    fun testLongVsShortStrings() {
        val strs = arrayOf("00000", "11111", "0", "1")
        val m = 5
        val n = 5
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(2, result, "Should select either two long strings OR multiple short strings")
    }

    @Test
    @DisplayName("Mixed length strings with tight constraints")
    fun testMixedLengthTightConstraints() {
        val strs = arrayOf("001", "110", "0101", "1100")
        val m = 3
        val n = 3
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(2, result, "Should optimally select 2 strings within constraints")
    }

    @Test
    @DisplayName("String with all zeros and limited zero capacity")
    fun testAllZerosLimitedCapacity() {
        val strs = arrayOf("00000")
        val m = 3
        val n = 10
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(0, result, "Should not select string exceeding zero capacity")
    }

    @Test
    @DisplayName("String with all ones and limited one capacity")
    fun testAllOnesLimitedCapacity() {
        val strs = arrayOf("11111")
        val m = 10
        val n = 3
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(0, result, "Should not select string exceeding one capacity")
    }

    @Test
    @DisplayName("Complex case with multiple valid combinations")
    fun testComplexCase() {
        val strs = arrayOf("10", "0001", "111001", "1", "0")
        val m = 4
        val n = 3
        val result = solution.findMaxForm(strs, m, n)
        assertEquals(3, result, "Should find optimal combination within tighter constraints")
    }
}
