package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CountBinarySubstringsTest {
    private val solution = CountBinarySubstrings()

    @Test
    @DisplayName("Example 1: s = \"00110011\" - should return 6")
    fun testExample1() {
        val s = "00110011"
        val result = solution.countBinarySubstrings(s)
        assertEquals(6, result, "Should find 6 substrings: \"0011\", \"01\", \"1100\", \"10\", \"0011\", \"01\"")
    }

    @Test
    @DisplayName("Example 2: s = \"10101\" - should return 4")
    fun testExample2() {
        val s = "10101"
        val result = solution.countBinarySubstrings(s)
        assertEquals(4, result, "Should find 4 substrings: \"10\", \"01\", \"10\", \"01\"")
    }

    @Test
    @DisplayName("Single character: s = \"0\" - should return 0")
    fun testSingleCharacter() {
        val s = "0"
        val result = solution.countBinarySubstrings(s)
        assertEquals(0, result, "Single character cannot form any valid substring")
    }

    @Test
    @DisplayName("Two identical characters: s = \"00\" - should return 0")
    fun testTwoIdenticalCharacters() {
        val s = "00"
        val result = solution.countBinarySubstrings(s)
        assertEquals(0, result, "Two identical characters cannot form valid substring")
    }

    @Test
    @DisplayName("Two different characters: s = \"01\" - should return 1")
    fun testTwoDifferentCharacters() {
        val s = "01"
        val result = solution.countBinarySubstrings(s)
        assertEquals(1, result, "Should find 1 substring: \"01\"")
    }

    @Test
    @DisplayName("All zeros: s = \"0000\" - should return 0")
    fun testAllZeros() {
        val s = "0000"
        val result = solution.countBinarySubstrings(s)
        assertEquals(0, result, "All same characters cannot form valid substrings")
    }

    @Test
    @DisplayName("All ones: s = \"1111\" - should return 0")
    fun testAllOnes() {
        val s = "1111"
        val result = solution.countBinarySubstrings(s)
        assertEquals(0, result, "All same characters cannot form valid substrings")
    }

    @Test
    @DisplayName("Simple alternating: s = \"0011\" - should return 2")
    fun testSimpleAlternating() {
        val s = "0011"
        val result = solution.countBinarySubstrings(s)
        assertEquals(2, result, "Should find 2 substrings: \"0011\", \"01\"")
    }

    @Test
    @DisplayName("Asymmetric groups: s = \"000111\" - should return 3")
    fun testAsymmetricGroups() {
        val s = "000111"
        val result = solution.countBinarySubstrings(s)
        assertEquals(3, result, "Should find 3 substrings based on minimum of consecutive groups")
    }

    @Test
    @DisplayName("Multiple groups: s = \"00110\" - should return 3")
    fun testMultipleGroups() {
        val s = "00110"
        val result = solution.countBinarySubstrings(s)
        assertEquals(3, result, "Should count substrings from multiple group transitions")
    }

    @Test
    @DisplayName("Complex pattern: s = \"0001110000\" - should return 6")
    fun testComplexPattern() {
        val s = "0001110000"
        val result = solution.countBinarySubstrings(s)
        assertEquals(6, result, "Should handle multiple consecutive groups correctly")
    }

    @Test
    @DisplayName("Starting with 1: s = \"11001100\" - should return 6")
    fun testStartingWithOne() {
        val s = "11001100"
        val result = solution.countBinarySubstrings(s)
        assertEquals(6, result, "Should work regardless of starting character")
    }

    @Test
    @DisplayName("Long alternating pattern: s = \"001100110011\" - should return 10")
    fun testLongAlternatingPattern() {
        val s = "001100110011"
        val result = solution.countBinarySubstrings(s)
        assertEquals(10, result, "Should handle longer patterns with multiple groups")
    }

    @Test
    @DisplayName("Unequal group sizes: s = \"0000011\" - should return 2")
    fun testUnequalGroupSizes() {
        val s = "0000011"
        val result = solution.countBinarySubstrings(s)
        assertEquals(2, result, "Count should be limited by smaller group size")
    }

    @Test
    @DisplayName("Three character string: s = \"001\" - should return 1")
    fun testThreeCharacterString() {
        val s = "001"
        val result = solution.countBinarySubstrings(s)
        assertEquals(1, result, "Should find 1 substring: \"01\"")
    }
}
