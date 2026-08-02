package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestPalindromicRearrangementITest {
    private val solution = SmallestPalindromicRearrangementI()

    @Test
    fun `test single character`() {
        assertEquals("z", solution.smallestPalindrome("z"))
    }

    @Test
    fun `test all same characters`() {
        assertEquals("aaaa", solution.smallestPalindrome("aaaa"))
    }

    @Test
    fun `test two character palindrome`() {
        assertEquals("aa", solution.smallestPalindrome("aa"))
    }
}
