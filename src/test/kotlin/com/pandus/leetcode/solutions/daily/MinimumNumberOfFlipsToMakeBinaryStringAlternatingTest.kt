package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfFlipsToMakeBinaryStringAlternatingTest {
    private val solution = MinimumNumberOfFlipsToMakeBinaryStringAlternating()

    @Test
    fun testExample1() {
        // Input: s = "111000", Output: 2
        // Rotate to "100011" then flip to "101010" (2 flips)
        assertEquals(2, solution.minFlips("111000"))
    }

    @Test
    fun testExample2() {
        // Input: s = "010", Output: 0
        // Already alternating
        assertEquals(0, solution.minFlips("010"))
    }

    @Test
    fun testExample3() {
        // Input: s = "1110", Output: 1
        // Rotate to "0111" then flip middle '1' to '0' -> "0101"
        assertEquals(1, solution.minFlips("1110"))
    }

    @Test
    fun testAlreadyAlternatingStartWithZero() {
        // "0101" is already alternating
        assertEquals(0, solution.minFlips("0101"))
    }

    @Test
    fun testAlreadyAlternatingStartWithOne() {
        // "1010" is already alternating
        assertEquals(0, solution.minFlips("1010"))
    }

    @Test
    fun testAllZeros() {
        // "0000" needs n/2 = 2 flips to become "0101" or "1010"
        assertEquals(2, solution.minFlips("0000"))
    }

    @Test
    fun testAllOnes() {
        // "1111" needs n/2 = 2 flips to become "0101" or "1010"
        assertEquals(2, solution.minFlips("1111"))
    }

    @Test
    fun testSingleCharacterZero() {
        // Single "0" is alternating
        assertEquals(0, solution.minFlips("0"))
    }

    @Test
    fun testSingleCharacterOne() {
        // Single "1" is alternating
        assertEquals(0, solution.minFlips("1"))
    }

    @Test
    fun testTwoSameCharacters() {
        // "00" -> needs 1 flip to become "01" or "10"
        assertEquals(1, solution.minFlips("00"))
    }

    @Test
    fun testTwoDifferentCharacters() {
        // "01" is already alternating
        assertEquals(0, solution.minFlips("01"))
    }

    @Test
    fun testOddLengthAllSame() {
        // "000" -> can become "010" with 1 flip (or rotate and flip)
        assertEquals(1, solution.minFlips("000"))
    }

    @Test
    fun testOddLengthAllOnes() {
        // "111" -> "101" with 1 flip
        assertEquals(1, solution.minFlips("111"))
    }

    @Test
    fun testRotationHelps() {
        // "01001001101" - rotation can reduce flips needed
        val result = solution.minFlips("01001001101")
        assertEquals(2, result)
    }

    @Test
    fun testLongerAlternatingString() {
        // "01010101" is already alternating
        assertEquals(0, solution.minFlips("01010101"))
    }

    @Test
    fun testLongerAlternatingStringStartWithOne() {
        // "10101010" is already alternating
        assertEquals(0, solution.minFlips("10101010"))
    }
}
