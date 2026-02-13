package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestBalancedSubstringIITest {
    private val solution = LongestBalancedSubstringII()

    @Test
    fun `example 1 - abbac returns 4`() {
        assertEquals(4, solution.longestBalanced("abbac"))
    }

    @Test
    fun `example 2 - aabcc returns 3`() {
        assertEquals(3, solution.longestBalanced("aabcc"))
    }

    @Test
    fun `example 3 - aba returns 2`() {
        assertEquals(2, solution.longestBalanced("aba"))
    }

    @Test
    fun `single character returns 1`() {
        assertEquals(1, solution.longestBalanced("a"))
    }

    @Test
    fun `two same characters returns 2`() {
        assertEquals(2, solution.longestBalanced("aa"))
    }

    @Test
    fun `two different characters returns 2`() {
        assertEquals(2, solution.longestBalanced("ab"))
    }

    @Test
    fun `three same characters returns 3`() {
        assertEquals(3, solution.longestBalanced("aaa"))
    }

    @Test
    fun `all three characters once returns 3`() {
        assertEquals(3, solution.longestBalanced("abc"))
    }

    @Test
    fun `all three characters twice returns 6`() {
        assertEquals(6, solution.longestBalanced("aabbcc"))
    }

    @Test
    fun `unbalanced string returns longest balanced substring`() {
        assertEquals(4, solution.longestBalanced("aaabbc"))
    }

    @Test
    fun `complex balanced string with all characters`() {
        assertEquals(6, solution.longestBalanced("abcabc"))
    }

    @Test
    fun `string with only two character types`() {
        assertEquals(4, solution.longestBalanced("aabb"))
    }

    @Test
    fun `longer string with multiple balanced substrings`() {
        assertEquals(6, solution.longestBalanced("aabbccaa"))
    }

    @Test
    fun `interleaved characters`() {
        assertEquals(6, solution.longestBalanced("ababab"))
    }

    @Test
    fun `entire string is balanced`() {
        assertEquals(9, solution.longestBalanced("aaabbbccc"))
    }

    @Test
    fun `complex pattern with different counts`() {
        assertEquals(6, solution.longestBalanced("abccba"))
    }

    @Test
    fun `repeating pattern`() {
        assertEquals(12, solution.longestBalanced("abcabcabcabc"))
    }
}
