package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountNumberOfSpecialCharactersITest {
    private val solution = CountNumberOfSpecialCharactersI()

    @Test
    fun `example 1 - aaAbcBC returns 3`() {
        assertEquals(3, solution.numberOfSpecialChars("aaAbcBC"))
    }

    @Test
    fun `example 2 - abc returns 0`() {
        assertEquals(0, solution.numberOfSpecialChars("abc"))
    }

    @Test
    fun `example 3 - abBCab returns 1`() {
        assertEquals(1, solution.numberOfSpecialChars("abBCab"))
    }

    @Test
    fun `all uppercase only returns 0`() {
        assertEquals(0, solution.numberOfSpecialChars("ABC"))
    }

    @Test
    fun `single lowercase and uppercase pair`() {
        assertEquals(1, solution.numberOfSpecialChars("aA"))
    }

    @Test
    fun `no matching pairs`() {
        assertEquals(0, solution.numberOfSpecialChars("aBC"))
    }

    @Test
    fun `all 26 letters both cases`() {
        val word = ('a'..'z').joinToString("") + ('A'..'Z').joinToString("")
        assertEquals(26, solution.numberOfSpecialChars(word))
    }

    @Test
    fun `repeated characters count once`() {
        assertEquals(1, solution.numberOfSpecialChars("aaaAAA"))
    }
}
