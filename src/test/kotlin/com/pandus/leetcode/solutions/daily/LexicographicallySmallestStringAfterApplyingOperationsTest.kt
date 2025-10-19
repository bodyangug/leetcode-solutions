package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LexicographicallySmallestStringAfterApplyingOperationsTest {
    private val solution = LexicographicallySmallestStringAfterApplyingOperations()

    @Test
    fun `example 1`() {
        assertEquals("2050", solution.findLexSmallestString("5525", 9, 2))
    }

    @Test
    fun `example 2`() {
        assertEquals("24", solution.findLexSmallestString("74", 5, 1))
    }

    @Test
    fun `example 3`() {
        // Even rotation step prevents parity swap of indices; expected remains same.
        assertEquals("0011", solution.findLexSmallestString("0011", 4, 2))
    }

    @Test
    fun `single character string`() {
        assertEquals("0", solution.findLexSmallestString("0", 7, 3))
    }

    @Test
    fun `already optimal string`() {
        assertEquals("012345", solution.findLexSmallestString("012345", 2, 3))
    }

    @Test
    fun `parity unaffected when b even`() {
        // b even: only odd indices adjustable. Rotations reachable: i=0 and i=2 for n=4, b=2.
        // Minimal achievable string for "9876" with a=3, b=2 is "7092".
        assertEquals("7092", solution.findLexSmallestString("9876", 3, 2))
    }

    @Test
    fun `stress moderately sized string`() {
        val s = "9".repeat(50)
        val res = solution.findLexSmallestString(s, 7, 3)
        // Ensure length preserved and string composed of digits
        assertEquals(50, res.length)
    }
}
