package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConcatenateNonZeroDigitsAndMultiplyBySumIITest {
    private val solution = ConcatenateNonZeroDigitsAndMultiplyBySumII()

    @Test
    fun `example 1`() {
        val s = "10203004"
        val queries = arrayOf(intArrayOf(0, 7), intArrayOf(1, 3), intArrayOf(4, 6))
        val expected = intArrayOf(12340, 4, 9)
        assertArrayEquals(expected, solution.sumAndMultiply(s, queries))
    }

    @Test
    fun `example 2`() {
        val s = "1000"
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(1, 1))
        val expected = intArrayOf(1, 0)
        assertArrayEquals(expected, solution.sumAndMultiply(s, queries))
    }

    @Test
    fun `example 3 requires modulo`() {
        val s = "9876543210"
        val queries = arrayOf(intArrayOf(0, 9))
        val expected = intArrayOf(444444137)
        assertArrayEquals(expected, solution.sumAndMultiply(s, queries))
    }

    @Test
    fun `single non-zero digit`() {
        val s = "5"
        val queries = arrayOf(intArrayOf(0, 0))
        val expected = intArrayOf(25)
        assertArrayEquals(expected, solution.sumAndMultiply(s, queries))
    }

    @Test
    fun `all zeros yields zero`() {
        val s = "0000"
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(1, 2))
        val expected = intArrayOf(0, 0)
        assertArrayEquals(expected, solution.sumAndMultiply(s, queries))
    }

    @Test
    fun `overlapping queries on same string`() {
        val s = "10203004"
        val queries = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 1),
            intArrayOf(2, 7),
            intArrayOf(6, 7),
        )
        // "1"->1*1=1; "10"->1*1=1; "203004"->234*(2+3+4)=234*9=2106; "04"->4*4=16
        val expected = intArrayOf(1, 1, 2106, 16)
        assertArrayEquals(expected, solution.sumAndMultiply(s, queries))
    }

    @Test
    fun `large number overflowing long`() {
        // 40 nines: concatenation far exceeds Long range, must be handled modulo.
        val s = "9".repeat(40)
        val queries = arrayOf(intArrayOf(0, 39))
        val mod = 1_000_000_007L
        var x = 0L
        for (i in 0 until 40) x = (x * 10 + 9) % mod
        val sum = 9L * 40
        val expected = intArrayOf((x * sum % mod).toInt())
        assertArrayEquals(expected, solution.sumAndMultiply(s, queries))
    }
}
