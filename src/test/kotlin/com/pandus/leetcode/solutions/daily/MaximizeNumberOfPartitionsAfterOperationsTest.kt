package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximizeNumberOfPartitionsAfterOperationsTest {

    private val solution = MaximizeNumberOfPartitionsAfterOperations()

    @Test
    fun testSingleCharacter() {
        // Single character
        val result = solution.maxPartitionsAfterOperations("a", 1)
        assertEquals(1, result)
    }

    @Test
    fun testTwoCharactersKOne() {
        // Two different characters with k=1
        val result = solution.maxPartitionsAfterOperations("ab", 1)
        assertEquals(2, result)
    }

    @Test
    fun testTwoCharactersKTwo() {
        // Two different characters with k=2
        val result = solution.maxPartitionsAfterOperations("ab", 2)
        assertEquals(1, result)
    }

    @Test
    fun testRepeatingPattern() {
        // Repeating pattern "abab"
        val result = solution.maxPartitionsAfterOperations("abab", 2)
        assertEquals(2, result)
    }

    @Test
    fun testLargeK() {
        // k is larger than number of distinct characters
        val result = solution.maxPartitionsAfterOperations("aabbcc", 5)
        assertEquals(1, result)
    }

    @Test
    fun testKEquals26() {
        // k equals 26 (all lowercase letters)
        val result = solution.maxPartitionsAfterOperations("abcdefghijklmnopqrstuvwxyz", 26)
        assertEquals(1, result)
    }

    @Test
    fun testMixedCharactersKThree() {
        // Mixed characters with k=3
        val result = solution.maxPartitionsAfterOperations("abcabc", 3)
        assertEquals(2, result)
    }

    @Test
    fun testAlternatingCharacters() {
        // Alternating characters with k=1
        val result = solution.maxPartitionsAfterOperations("ababab", 1)
        assertEquals(6, result)
    }

    @Test
    fun testComplexPattern() {
        // Complex pattern with k=3
        val result = solution.maxPartitionsAfterOperations("abcdefabc", 3)
        assertEquals(3, result)
    }

    @Test
    fun testRepeatingBlocksKFour() {
        // Repeating blocks with k=4
        val result = solution.maxPartitionsAfterOperations("abcdabcd", 4)
        assertEquals(2, result)
    }

    @Test
    fun testSingleCharacterRepeatedKFive() {
        // Single character repeated many times with k=5
        val result = solution.maxPartitionsAfterOperations("aaaaaaaaaa", 5)
        assertEquals(1, result)
    }

    @Test
    fun testLongMixedStringKFive() {
        // Longer mixed string with k=5
        val result = solution.maxPartitionsAfterOperations("abcdeabcdeabcde", 5)
        assertEquals(3, result)
    }

    @Test
    fun testEdgeCaseOneChangeHelps() {
        // Edge case where one character change helps
        val result = solution.maxPartitionsAfterOperations("accca", 2)
        assertEquals(3, result)
    }
}
