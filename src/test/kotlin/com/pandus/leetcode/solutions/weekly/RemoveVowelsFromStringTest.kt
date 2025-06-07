package com.pandus.leetcode.solutions.weekly

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveVowelsFromStringTest {
    private val solution = RemoveVowelsFromString()

    @Test
    fun `should remove all vowels from string with mixed characters`() {
        val result = solution.removeVowels("helloworld")
        assertEquals("hllwrld", result)
    }

    @Test
    fun `should return empty string when input contains only vowels`() {
        val result = solution.removeVowels("aeiou")
        assertEquals("", result)
    }

    @Test
    fun `should return same string when input contains no vowels`() {
        val result = solution.removeVowels("rhythm")
        assertEquals("rhythm", result)
    }

    @Test
    fun `should handle string with mixed case vowels`() {
        val result = solution.removeVowels("HeLLo")
        assertEquals("HLL", result)
    }

    @Test
    fun `should handle empty string`() {
        val result = solution.removeVowels("")
        assertEquals("", result)
    }

    @Test
    fun `should handle string with consecutive vowels`() {
        val result = solution.removeVowels("queue")
        assertEquals("q", result)
    }

    @Test
    fun `should handle string with vowels at start and end`() {
        val result = solution.removeVowels("apple")
        assertEquals("ppl", result)
    }
}
