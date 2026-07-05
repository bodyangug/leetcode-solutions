package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfStringsThatAppearAsSubstringsInWordTest {
    private val solution = NumberOfStringsThatAppearAsSubstringsInWord()

    @Test
    fun testExample1() {
        val patterns = arrayOf("a", "abc", "bc", "d")
        val word = "abc"
        assertEquals(3, solution.numOfStrings(patterns, word))
    }

    @Test
    fun testExample2() {
        val patterns = arrayOf("a", "b", "c")
        val word = "aaaaabbbbb"
        assertEquals(2, solution.numOfStrings(patterns, word))
    }

    @Test
    fun testExample3() {
        val patterns = arrayOf("a", "a", "a")
        val word = "ab"
        assertEquals(3, solution.numOfStrings(patterns, word))
    }

    @Test
    fun testNoPatternsMatch() {
        val patterns = arrayOf("x", "y", "z")
        val word = "abc"
        assertEquals(0, solution.numOfStrings(patterns, word))
    }

    @Test
    fun testAllPatternsMatch() {
        val patterns = arrayOf("hello", "world", "lo wo", "o w")
        val word = "hello world"
        assertEquals(4, solution.numOfStrings(patterns, word))
    }

    @Test
    fun testEmptyPatternsArray() {
        val patterns = emptyArray<String>()
        val word = "abc"
        assertEquals(0, solution.numOfStrings(patterns, word))
    }

    @Test
    fun testEmptyStringPatternAlwaysMatches() {
        val patterns = arrayOf("", "", "a")
        val word = "abc"
        assertEquals(3, solution.numOfStrings(patterns, word))
    }

    @Test
    fun testPatternEqualsWord() {
        val patterns = arrayOf("abc")
        val word = "abc"
        assertEquals(1, solution.numOfStrings(patterns, word))
    }

    @Test
    fun testPatternLongerThanWord() {
        val patterns = arrayOf("abcd", "abcde")
        val word = "abc"
        assertEquals(0, solution.numOfStrings(patterns, word))
    }

    @Test
    fun testCaseSensitivity() {
        val patterns = arrayOf("A", "a", "Bc", "bc")
        val word = "abc"
        assertEquals(2, solution.numOfStrings(patterns, word))
    }
}
