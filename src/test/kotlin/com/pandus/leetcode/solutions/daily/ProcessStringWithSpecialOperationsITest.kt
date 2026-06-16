package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProcessStringWithSpecialOperationsITest {
    private val solution = ProcessStringWithSpecialOperationsI()

    @Test
    fun `test example 1 with duplicate reverse and delete`() {
        assertEquals("ba", solution.processStr("a#b%*"))
    }

    @Test
    fun `test example 2 with delete then duplicate empty`() {
        assertEquals("", solution.processStr("z*#"))
    }

    @Test
    fun `test only letters`() {
        assertEquals("abc", solution.processStr("abc"))
    }

    @Test
    fun `test delete on empty string is a no-op`() {
        assertEquals("a", solution.processStr("**a"))
    }

    @Test
    fun `test duplicate on empty string`() {
        assertEquals("a", solution.processStr("#a"))
    }

    @Test
    fun `test reverse on empty string`() {
        assertEquals("a", solution.processStr("%a"))
    }

    @Test
    fun `test single character`() {
        assertEquals("x", solution.processStr("x"))
    }

    @Test
    fun `test duplicate operation`() {
        assertEquals("abab", solution.processStr("ab#"))
    }

    @Test
    fun `test reverse operation`() {
        assertEquals("cba", solution.processStr("abc%"))
    }

    @Test
    fun `test delete last character`() {
        assertEquals("ab", solution.processStr("abc*"))
    }

    @Test
    fun `test multiple duplicates`() {
        assertEquals("aaaa", solution.processStr("a##"))
    }

    @Test
    fun `test combined operations`() {
        // a -> "a", b -> "ab", # -> "abab", % -> "baba", * -> "bab", c -> "babc"
        assertEquals("babc", solution.processStr("ab#%*c"))
    }

    @Test
    fun `test all operations leading to empty result`() {
        // a -> "a", * -> "", % -> "", # -> "", * -> ""
        assertEquals("", solution.processStr("a*%#*"))
    }
}
