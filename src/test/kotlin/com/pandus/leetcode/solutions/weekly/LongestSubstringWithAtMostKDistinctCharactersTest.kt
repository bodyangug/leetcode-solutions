package com.pandus.leetcode.solutions.weekly

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestSubstringWithAtMostKDistinctCharactersTest {
    private val solution = LongestSubstringWithAtMostKDistinctCharacters()

    @Test
    fun `should return 3 for string 'eceba' with k=2`() {
        val result = solution.lengthOfLongestSubstringKDistinct("eceba", 2)
        assertEquals(3, result)
    }

    @Test
    fun `should return 0 for empty string`() {
        val result = solution.lengthOfLongestSubstringKDistinct("", 2)
        assertEquals(0, result)
    }

    @Test
    fun `should return length of string when k is greater than unique characters`() {
        val result = solution.lengthOfLongestSubstringKDistinct("aaabb", 3)
        assertEquals(5, result)
    }

    @Test
    fun `should return k when string has exactly k distinct characters`() {
        val result = solution.lengthOfLongestSubstringKDistinct("abc", 3)
        assertEquals(3, result)
    }

    @Test
    fun `should handle string with repeating characters`() {
        val result = solution.lengthOfLongestSubstringKDistinct("aaaaa", 1)
        assertEquals(5, result)
    }

    @Test
    fun `should handle string with all unique characters`() {
        val result = solution.lengthOfLongestSubstringKDistinct("abcdef", 3)
        assertEquals(3, result)
    }

    @Test
    fun `should handle string with k=0`() {
        val result = solution.lengthOfLongestSubstringKDistinct("abc", 0)
        assertEquals(0, result)
    }

    @Test
    fun `should handle string with alternating characters`() {
        val result = solution.lengthOfLongestSubstringKDistinct("ababab", 2)
        assertEquals(6, result)
    }
}
