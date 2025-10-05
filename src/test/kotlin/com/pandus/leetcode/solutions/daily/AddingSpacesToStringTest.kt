package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class AddingSpacesToStringTest {
    private val solution = AddingSpacesToString()

    @Test
    fun `test basic case`() {
        val s = "LeetcodeHelpsMeLearn"
        val spaces = intArrayOf(8, 13, 15)
        val expected = "Leetcode Helps Me Learn"
        assertEquals(expected, solution.addSpaces(s, spaces))
    }

    @Test
    fun `test empty string`() {
        val s = ""
        val spaces = intArrayOf()
        val expected = ""
        assertEquals(expected, solution.addSpaces(s, spaces))
    }

    @Test
    fun `test string with no spaces`() {
        val s = "Hello"
        val spaces = intArrayOf()
        val expected = "Hello"
        assertEquals(expected, solution.addSpaces(s, spaces))
    }

    @Test
    fun `test string with consecutive spaces`() {
        val s = "Hello"
        val spaces = intArrayOf(1, 2, 3)
        val expected = "H e l lo"
        assertEquals(expected, solution.addSpaces(s, spaces))
    }
}
