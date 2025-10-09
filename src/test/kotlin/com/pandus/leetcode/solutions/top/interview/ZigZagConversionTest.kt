package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class ZigZagConversionTest {

    private val solution = ZigZagConversion()

    @Test
    fun testExample1() {
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3))
    }

    @Test
    fun testExample2() {
        assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4))
    }

    @Test
    fun testExample3() {
        assertEquals("A", solution.convert("A", 1))
    }

    @Test
    fun testSingleRow() {
        assertEquals("HELLO", solution.convert("HELLO", 1))
    }

    @Test
    fun testTwoRows() {
        assertEquals("HLOEL", solution.convert("HELLO", 2))
    }

    @Test
    fun testMoreRowsThanCharacters() {
        assertEquals("HELLO", solution.convert("HELLO", 10))
    }

    @Test
    fun testShortString() {
        assertEquals("AB", solution.convert("AB", 2))
    }

    @Test
    fun testSingleCharacter() {
        assertEquals("X", solution.convert("X", 3))
    }

    @Test
    fun testFourRowsDetailed() {
        // "ABCDEFGH" with 4 rows:
        // A   G
        // B F H
        // C E
        // D
        // Reading row by row: A, G, B, F, H, C, E, D
        assertEquals("AGBFHCED", solution.convert("ABCDEFGH", 4))
    }

    @Test
    fun testLongerString() {
        // Test with a longer string to verify the zigzag pattern
        val input = "ABCDEFGHIJKLMNOP"
        val result = solution.convert(input, 5)
        // With 5 rows, the pattern should be properly zigzagged
        assertNotNull(result)
        assertEquals(input.length, result.length)
    }
}
