package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestBalancedSubstringITest {
    private val solution = LongestBalancedSubstringI()

    @Test
    fun `test example 1 - abbac returns 4`() {
        val s = "abbac"
        val expected = 4
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test example 2 - zzabccy returns 4`() {
        val s = "zzabccy"
        val expected = 4
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test example 3 - aba returns 2`() {
        val s = "aba"
        val expected = 2
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test single character`() {
        val s = "a"
        val expected = 1
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test empty string`() {
        val s = ""
        val expected = 0
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test two same characters`() {
        val s = "aa"
        val expected = 2
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test two different characters`() {
        val s = "ab"
        val expected = 2
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test all same characters`() {
        val s = "aaaa"
        val expected = 4
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test balanced in middle`() {
        val s = "xaabby"
        val expected = 4
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test alternating characters`() {
        val s = "ababab"
        val expected = 6
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test three distinct characters each appearing twice`() {
        val s = "aabbcc"
        val expected = 6
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test long balanced substring`() {
        val s = "abcabc"
        val expected = 6
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test multiple possible balanced substrings`() {
        val s = "aabbccdd"
        val expected = 8
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test entire alphabet once`() {
        val s = "abcdefghijklmnopqrstuvwxyz"
        val expected = 26
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test repeated pattern`() {
        val s = "abab"
        val expected = 4
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test single character repeated many times`() {
        val s = "zzzzzz"
        val expected = 6
        assertEquals(expected, solution.longestBalanced(s))
    }

    @Test
    fun `test complex case with multiple balanced options`() {
        val s = "aabbc"
        val expected = 4
        assertEquals(expected, solution.longestBalanced(s))
    }
}
