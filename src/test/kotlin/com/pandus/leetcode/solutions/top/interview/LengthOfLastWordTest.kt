package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfLastWordTest {

    private val solution = LengthOfLastWord()

    @Test
    fun testExample1() {
        assertEquals(5, solution.lengthOfLastWord("Hello World"))
    }

    @Test
    fun testExample2() {
        assertEquals(4, solution.lengthOfLastWord("   fly me   to   the moon  "))
    }

    @Test
    fun testExample3() {
        assertEquals(6, solution.lengthOfLastWord("luffy is still joyboy"))
    }

    @Test
    fun testSingleWord() {
        assertEquals(5, solution.lengthOfLastWord("hello"))
    }

    @Test
    fun testTrailingSpaces() {
        assertEquals(4, solution.lengthOfLastWord("word    "))
    }

    @Test
    fun testLeadingSpaces() {
        assertEquals(4, solution.lengthOfLastWord("    word"))
    }

    @Test
    fun testMultipleSpaces() {
        assertEquals(3, solution.lengthOfLastWord("a   b   c   def"))
    }
}
