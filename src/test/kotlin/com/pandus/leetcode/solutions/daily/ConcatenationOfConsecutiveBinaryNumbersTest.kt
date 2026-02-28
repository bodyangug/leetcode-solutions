package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ConcatenationOfConsecutiveBinaryNumbersTest {
    private val solution = ConcatenationOfConsecutiveBinaryNumbers()

    @Test
    @DisplayName("Example 1: n = 1, output = 1")
    fun testExample1() {
        val result = solution.concatenatedBinary(1)
        assertEquals(1, result, "\"1\" in binary corresponds to the decimal value 1")
    }

    @Test
    @DisplayName("Example 2: n = 3, output = 27")
    fun testExample2() {
        val result = solution.concatenatedBinary(3)
        assertEquals(
            27,
            result,
            "In binary, 1, 2, and 3 corresponds to \"1\", \"10\", and \"11\". " +
                    "After concatenating them, we have \"11011\", which corresponds to the decimal value 27"
        )
    }

    @Test
    @DisplayName("Example 3: n = 12, output = 505379714")
    fun testExample3() {
        val result = solution.concatenatedBinary(12)
        assertEquals(
            505379714,
            result,
            "The concatenation results in \"1101110010111011110001001101010111100\". " +
                    "The decimal value of that is 118505380540. After modulo 10^9 + 7, the result is 505379714"
        )
    }

    @Test
    @DisplayName("n = 2, output = 6")
    fun testN2() {
        val result = solution.concatenatedBinary(2)
        assertEquals(6, result, "Binary: \"1\" + \"10\" = \"110\" = 6")
    }

    @Test
    @DisplayName("n = 4, output = 27")
    fun testN4() {
        val result = solution.concatenatedBinary(4)
        assertEquals(220, result, "Binary: \"1\" + \"10\" + \"11\" + \"100\" = \"110111100\" = 220")
    }

    @Test
    @DisplayName("n = 5, output = 1765")
    fun testN5() {
        val result = solution.concatenatedBinary(5)
        assertEquals(1765, result, "Binary concatenation of 1-5")
    }

    @Test
    @DisplayName("n = 7, output = 113015")
    fun testN7() {
        val result = solution.concatenatedBinary(7)
        assertEquals(113015, result, "Binary concatenation of 1-7")
    }

    @Test
    @DisplayName("n = 10, output = 462911642")
    fun testN10() {
        val result = solution.concatenatedBinary(10)
        assertEquals(462911642, result, "Binary concatenation of 1-10 with modulo applied")
    }

    @Test
    @DisplayName("Edge case: Large n value to test modulo")
    fun testLargeN() {
        val result = solution.concatenatedBinary(100000)
        // The result should be a valid integer within modulo bounds
        assert(result >= 0 && result < 1_000_000_007) { "Result should be within modulo bounds" }
    }

    @Test
    @DisplayName("Power of 2: n = 8")
    fun testPowerOf2_8() {
        val result = solution.concatenatedBinary(8)
        assertEquals(1808248, result, "Binary concatenation of 1-8")
    }

    @Test
    @DisplayName("Power of 2: n = 16")
    fun testPowerOf2_16() {
        val result = solution.concatenatedBinary(16)
        assertEquals(129523881, result, "Binary concatenation of 1-16")
    }

    @Test
    @DisplayName("n = 6, output = 14126")
    fun testN6() {
        val result = solution.concatenatedBinary(6)
        assertEquals(14126, result, "Binary concatenation of 1-6")
    }
}
