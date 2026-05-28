package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LongestCommonSuffixQueriesTest {
    private val solution = LongestCommonSuffixQueries()

    @Test
    @DisplayName("Example 1: wordsContainer=[abcd,bcd,xbcd], wordsQuery=[cd,bcd,xyz]")
    fun testExample1() {
        val container = arrayOf("abcd", "bcd", "xbcd")
        val query = arrayOf("cd", "bcd", "xyz")
        assertArrayEquals(intArrayOf(1, 1, 1), solution.stringIndices(container, query))
    }

    @Test
    @DisplayName("Example 2: wordsContainer=[abcdefgh,poiuygh,ghghgh], wordsQuery=[gh,acbfgh,acbfegh]")
    fun testExample2() {
        val container = arrayOf("abcdefgh", "poiuygh", "ghghgh")
        val query = arrayOf("gh", "acbfgh", "acbfegh")
        assertArrayEquals(intArrayOf(2, 0, 2), solution.stringIndices(container, query))
    }

    @Test
    @DisplayName("No common suffix: should return shortest word index")
    fun testNoCommonSuffix() {
        val container = arrayOf("abc", "de", "fgh")
        val query = arrayOf("xyz")
        assertArrayEquals(intArrayOf(1), solution.stringIndices(container, query))
    }

    @Test
    @DisplayName("Single element container")
    fun testSingleContainer() {
        val container = arrayOf("hello")
        val query = arrayOf("lo", "world", "hello")
        assertArrayEquals(intArrayOf(0, 0, 0), solution.stringIndices(container, query))
    }

    @Test
    @DisplayName("Tie-breaking: same suffix length, pick shorter word, then earlier index")
    fun testTieBreaking() {
        val container = arrayOf("aaa", "bba", "ca")
        val query = arrayOf("a")
        // All end with 'a', shortest is "ca" (length 2) at index 2
        assertArrayEquals(intArrayOf(2), solution.stringIndices(container, query))
    }
}
