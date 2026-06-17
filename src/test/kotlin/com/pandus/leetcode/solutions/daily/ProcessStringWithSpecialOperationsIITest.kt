package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ProcessStringWithSpecialOperationsIITest {
    private val solution = ProcessStringWithSpecialOperationsII()

    @Test
    fun `example 1 - duplicate, reverse, and remove`() {
        // Final result: "ba", k = 1 -> 'a'
        assertEquals('a', solution.processStr("a#b%*", 1L))
    }

    @Test
    fun `example 2 - reverse then duplicates`() {
        // Final result: "dcddcd", k = 3 -> 'd'
        assertEquals('d', solution.processStr("cd%#*#", 3L))
    }

    @Test
    fun `example 3 - k out of bounds returns dot`() {
        // Final result: "", k = 0 -> '.'
        assertEquals('.', solution.processStr("z*#", 0L))
    }

    @Test
    fun `single letter at index 0`() {
        assertEquals('a', solution.processStr("a", 0L))
    }

    @Test
    fun `single letter k out of bounds`() {
        assertEquals('.', solution.processStr("a", 1L))
    }

    @Test
    fun `star on empty string is no-op`() {
        // "*a" -> "a"
        assertEquals('a', solution.processStr("*a", 0L))
        assertEquals('.', solution.processStr("*a", 1L))
    }

    @Test
    fun `hash on empty string stays empty`() {
        // "#a" -> "a"
        assertEquals('a', solution.processStr("#a", 0L))
        assertEquals('.', solution.processStr("#a", 1L))
    }

    @Test
    fun `percent on empty string stays empty`() {
        // "%a" -> "a"
        assertEquals('a', solution.processStr("%a", 0L))
    }

    @Test
    fun `reverse simple`() {
        // "abc%" -> "cba"
        assertEquals('c', solution.processStr("abc%", 0L))
        assertEquals('b', solution.processStr("abc%", 1L))
        assertEquals('a', solution.processStr("abc%", 2L))
    }

    @Test
    fun `duplicate simple`() {
        // "ab#" -> "abab"
        assertEquals('a', solution.processStr("ab#", 0L))
        assertEquals('b', solution.processStr("ab#", 1L))
        assertEquals('a', solution.processStr("ab#", 2L))
        assertEquals('b', solution.processStr("ab#", 3L))
        assertEquals('.', solution.processStr("ab#", 4L))
    }

    @Test
    fun `multiple stars all empty`() {
        // "ab**" -> ""
        assertEquals('.', solution.processStr("ab**", 0L))
    }

    @Test
    fun `large duplications still resolve correctly`() {
        // "a" then 60 '#' yields length 2^60. Index 0 is always 'a'.
        val s = "a" + "#".repeat(60)
        assertEquals('a', solution.processStr(s, 0L))
        assertEquals('a', solution.processStr(s, (1L shl 59) + 12345L))
    }

    @Test
    fun `large duplications with reverse`() {
        // "ab#" -> "abab", then many '#' duplicates that pattern; even index = 'a', odd = 'b'.
        val s = "ab#" + "#".repeat(40)
        assertEquals('a', solution.processStr(s, 0L))
        assertEquals('b', solution.processStr(s, 1L))
        assertEquals('a', solution.processStr(s, 1_000_000L))
        assertEquals('b', solution.processStr(s, 1_000_001L))
    }

    @Test
    fun `mixed operations`() {
        // "ab#%" -> "abab" -> reverse -> "baba"
        assertEquals('b', solution.processStr("ab#%", 0L))
        assertEquals('a', solution.processStr("ab#%", 1L))
        assertEquals('b', solution.processStr("ab#%", 2L))
        assertEquals('a', solution.processStr("ab#%", 3L))
    }
}
