package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindStringWithLCPTest {
    private val solution = FindStringWithLCP()

    @Test
    fun `test alternating letters`() {
        val lcp = arrayOf(
            intArrayOf(4, 0, 2, 0),
            intArrayOf(0, 3, 0, 1),
            intArrayOf(2, 0, 2, 0),
            intArrayOf(0, 1, 0, 1)
        )
        assertEquals("abab", solution.findTheString(lcp))
    }

    @Test
    fun `test single distinct letter`() {
        val lcp = arrayOf(
            intArrayOf(4, 3, 2, 1),
            intArrayOf(3, 3, 2, 1),
            intArrayOf(2, 2, 2, 1),
            intArrayOf(1, 1, 1, 1)
        )
        assertEquals("aaaa", solution.findTheString(lcp))
    }

    @Test
    fun `test invalid lcp matrix`() {
        val lcp = arrayOf(
            intArrayOf(4, 3, 2, 1),
            intArrayOf(3, 3, 2, 1),
            intArrayOf(2, 2, 2, 1),
            intArrayOf(1, 1, 1, 3)
        )
        assertEquals("", solution.findTheString(lcp))
    }

    @Test
    fun `test single character`() {
        val lcp = arrayOf(intArrayOf(1))
        assertEquals("a", solution.findTheString(lcp))
    }

    @Test
    fun `test two same characters`() {
        val lcp = arrayOf(
            intArrayOf(2, 1),
            intArrayOf(1, 1)
        )
        assertEquals("aa", solution.findTheString(lcp))
    }

    @Test
    fun `test two different characters`() {
        val lcp = arrayOf(
            intArrayOf(2, 0),
            intArrayOf(0, 1)
        )
        assertEquals("ab", solution.findTheString(lcp))
    }

    @Test
    fun `test asymmetric lcp returns empty`() {
        val lcp = arrayOf(
            intArrayOf(2, 1),
            intArrayOf(0, 1)
        )
        assertEquals("", solution.findTheString(lcp))
    }

    @Test
    fun `test three characters abc`() {
        val lcp = arrayOf(
            intArrayOf(3, 0, 0),
            intArrayOf(0, 2, 0),
            intArrayOf(0, 0, 1)
        )
        assertEquals("abc", solution.findTheString(lcp))
    }
}
