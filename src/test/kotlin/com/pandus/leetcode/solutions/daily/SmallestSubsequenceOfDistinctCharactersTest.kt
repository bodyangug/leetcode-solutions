package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestSubsequenceOfDistinctCharactersTest {
    private val solution = SmallestSubsequenceOfDistinctCharacters()

    @Test
    fun `test example 1 - bcabc returns abc`() {
        val s = "bcabc"
        val expected = "abc"
        assertEquals(expected, solution.smallestSubsequence(s))
    }

    @Test
    fun `test example 2 - cbacdcbc returns acdb`() {
        val s = "cbacdcbc"
        val expected = "acdb"
        assertEquals(expected, solution.smallestSubsequence(s))
    }

    @Test
    fun `test empty string`() {
        val s = ""
        val expected = ""
        assertEquals(expected, solution.smallestSubsequence(s))
    }

    @Test
    fun `test single character`() {
        val s = "a"
        val expected = "a"
        assertEquals(expected, solution.smallestSubsequence(s))
    }

    @Test
    fun `test all same characters`() {
        val s = "aaaa"
        val expected = "a"
        assertEquals(expected, solution.smallestSubsequence(s))
    }

    @Test
    fun `test already distinct and sorted`() {
        val s = "abc"
        val expected = "abc"
        assertEquals(expected, solution.smallestSubsequence(s))
    }

    @Test
    fun `test distinct but reversed`() {
        val s = "cba"
        val expected = "cba"
        assertEquals(expected, solution.smallestSubsequence(s))
    }

    @Test
    fun `test two characters repeated`() {
        val s = "abab"
        val expected = "ab"
        assertEquals(expected, solution.smallestSubsequence(s))
    }

    @Test
    fun `test descending duplicates`() {
        val s = "bbcaac"
        val expected = "bac"
        assertEquals(expected, solution.smallestSubsequence(s))
    }

    @Test
    fun `test leetcode example`() {
        val s = "leetcode"
        val expected = "letcod"
        assertEquals(expected, solution.smallestSubsequence(s))
    }

    @Test
    fun `test result preserves required order`() {
        val s = "ecbacba"
        val expected = "eacb"
        assertEquals(expected, solution.smallestSubsequence(s))
    }
}
