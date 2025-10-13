package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindResultantArrayAfterRemovingAnagramsTest {
    private val solution = FindResultantArrayAfterRemovingAnagrams()

    @Test
    fun `test basic case with anagrams`() {
        val words = arrayOf("abba", "baba", "bbaa", "cd", "cd")
        val expected = listOf("abba", "cd")
        assertEquals(expected, solution.removeAnagrams(words))
    }

    @Test
    fun `test no anagrams`() {
        val words = arrayOf("a", "b", "c", "d", "e")
        val expected = listOf("a", "b", "c", "d", "e")
        assertEquals(expected, solution.removeAnagrams(words))
    }

    @Test
    fun `test all anagrams`() {
        val words = arrayOf("abc", "bca", "cab", "acb")
        val expected = listOf("abc")
        assertEquals(expected, solution.removeAnagrams(words))
    }

    @Test
    fun `test single word`() {
        val words = arrayOf("hello")
        val expected = listOf("hello")
        assertEquals(expected, solution.removeAnagrams(words))
    }

    @Test
    fun `test anagrams separated by non-anagram`() {
        val words = arrayOf("abc", "bca", "xyz", "abc", "bca")
        val expected = listOf("abc", "xyz", "abc")
        assertEquals(expected, solution.removeAnagrams(words))
    }

    @Test
    fun `test consecutive anagrams followed by different words`() {
        val words = arrayOf("abba", "baba", "bbaa", "cd", "dc", "ef")
        val expected = listOf("abba", "cd", "ef")
        assertEquals(expected, solution.removeAnagrams(words))
    }

    @Test
    fun `test with repeated non-anagram words`() {
        val words = arrayOf("a", "b", "a")
        val expected = listOf("a", "b", "a")
        assertEquals(expected, solution.removeAnagrams(words))
    }

    @Test
    fun `test with same word repeated`() {
        val words = arrayOf("abc", "abc", "abc")
        val expected = listOf("abc")
        assertEquals(expected, solution.removeAnagrams(words))
    }

    @Test
    fun `test with different lengths`() {
        val words = arrayOf("abc", "ab", "ba", "abc")
        val expected = listOf("abc", "ab", "abc")
        assertEquals(expected, solution.removeAnagrams(words))
    }

    @Test
    fun `test with empty strings`() {
        val words = arrayOf("", "", "a")
        val expected = listOf("", "a")
        assertEquals(expected, solution.removeAnagrams(words))
    }
}
