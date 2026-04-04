package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecodeSlantedCiphertextTest {
    private val solution = DecodeSlantedCiphertext()

    @Test
    fun `test example 1 - cipher with 3 rows`() {
        val encodedText = "ch   ie   pr"
        val rows = 3
        val expected = "cipher"
        assertEquals(expected, solution.decodeCiphertext(encodedText, rows))
    }

    @Test
    fun `test example 2 - i love leetcode with 4 rows`() {
        val encodedText = "iveo    eed   l te   olc"
        val rows = 4
        val expected = "i love leetcode"
        assertEquals(expected, solution.decodeCiphertext(encodedText, rows))
    }

    @Test
    fun `test example 3 - single row`() {
        val encodedText = "coding"
        val rows = 1
        val expected = "coding"
        assertEquals(expected, solution.decodeCiphertext(encodedText, rows))
    }

    @Test
    fun `test empty encoded text`() {
        val encodedText = ""
        val rows = 1
        val expected = ""
        assertEquals(expected, solution.decodeCiphertext(encodedText, rows))
    }

    @Test
    fun `test single character`() {
        val encodedText = "a"
        val rows = 1
        val expected = "a"
        assertEquals(expected, solution.decodeCiphertext(encodedText, rows))
    }

    @Test
    fun `test all spaces trimmed`() {
        // If originalText is "a", rows=3:
        // Diagonal: (0,0)=a, rest spaces. Matrix 3 rows, 1 col:
        //   a
        //   ' '
        //   ' '
        // encodedText = "a  " (length 3)
        assertEquals("a", solution.decodeCiphertext("a  ", 3))
    }

    @Test
    fun `test longer text with multiple rows`() {
        // originalText = "abcde", rows = 5
        // Diagonal: (0,0)=a, (1,1)=b, (2,2)=c, (3,3)=d, (4,4)=e
        // Matrix 5 rows, 5 cols (rest are spaces)
        // Row 0: "a    "
        // Row 1: " b   "
        // Row 2: "  c  "
        // Row 3: "   d "
        // Row 4: "    e"
        // encodedText = "a     b     c     d      e"
        val encodedText = "a     b     c     d     e"
        assertEquals("abcde", solution.decodeCiphertext(encodedText, 5))
    }
}
