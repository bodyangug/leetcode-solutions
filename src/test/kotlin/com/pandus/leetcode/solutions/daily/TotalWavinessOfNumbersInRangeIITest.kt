package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class TotalWavinessOfNumbersInRangeIITest {
    private val solution = TotalWavinessOfNumbersInRangeII()

    @Test
    @DisplayName("Example 1: num1 = 120, num2 = 130, output = 3")
    fun testExample1() {
        val result = solution.totalWaviness(120L, 130L)
        assertEquals(3L, result)
    }

    @Test
    @DisplayName("Example 2: num1 = 198, num2 = 202, output = 3")
    fun testExample2() {
        val result = solution.totalWaviness(198L, 202L)
        assertEquals(3L, result)
    }

    @Test
    @DisplayName("Example 3: num1 = 4848, num2 = 4848, output = 2")
    fun testExample3() {
        val result = solution.totalWaviness(4848L, 4848L)
        assertEquals(2L, result)
    }

    @Test
    @DisplayName("Single digit numbers have waviness 0")
    fun testSingleDigit() {
        val result = solution.totalWaviness(1L, 9L)
        assertEquals(0L, result)
    }

    @Test
    @DisplayName("Two digit numbers have waviness 0")
    fun testTwoDigits() {
        val result = solution.totalWaviness(10L, 99L)
        assertEquals(0L, result)
    }

    @Test
    @DisplayName("Single number with strictly increasing digits has waviness 0")
    fun testStrictlyIncreasing() {
        val result = solution.totalWaviness(123L, 123L)
        assertEquals(0L, result, "123 has no peaks or valleys since digits are strictly increasing")
    }

    @Test
    @DisplayName("Single number with equal adjacent digits has waviness 0")
    fun testEqualAdjacentDigits() {
        val result = solution.totalWaviness(111L, 111L)
        assertEquals(0L, result, "111 has no peaks or valleys since digits are equal")
    }

    @Test
    @DisplayName("Single number with one peak: 132 -> waviness 1")
    fun testSinglePeak() {
        val result = solution.totalWaviness(132L, 132L)
        assertEquals(1L, result)
    }

    @Test
    @DisplayName("Single number with one valley: 213 -> waviness 1")
    fun testSingleValley() {
        val result = solution.totalWaviness(213L, 213L)
        assertEquals(1L, result)
    }

    @Test
    @DisplayName("Alternating digits 1213 -> two peaks/valleys, waviness 2")
    fun testAlternatingDigits() {
        val result = solution.totalWaviness(1213L, 1213L)
        assertEquals(2L, result)
    }

    @Test
    @DisplayName("Range starting at 1 covering small range produces same as solving num2")
    fun testFromOne() {
        val result = solution.totalWaviness(1L, 130L)
        // Numbers in [1,130] with waviness > 0 are 120, 121, 130 (each 1) plus
        // 101..109 (1 valley each = 9), 102..120 valleys etc. Verify via brute force below.
        val expected = bruteForce(1L, 130L)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Brute force comparison for small range [1, 500]")
    fun testBruteForceSmallRange() {
        val expected = bruteForce(1L, 500L)
        val result = solution.totalWaviness(1L, 500L)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Brute force comparison for range [789, 1234]")
    fun testBruteForceMidRange() {
        val expected = bruteForce(789L, 1234L)
        val result = solution.totalWaviness(789L, 1234L)
        assertEquals(expected, result)
    }

    @Test
    @DisplayName("Large bound: num2 = 10^9 returns non-negative result")
    fun testLargeBound() {
        val result = solution.totalWaviness(1L, 1_000_000_000L)
        // Sanity check: should be a large positive value, just ensure deterministic computation.
        assertEquals(result, solution.totalWaviness(1L, 1_000_000_000L))
        assert(result > 0L)
    }

    private fun bruteForce(num1: Long, num2: Long): Long {
        var total = 0L
        for (n in num1..num2) {
            val s = n.toString()
            for (i in 1 until s.length - 1) {
                val a = s[i - 1]
                val b = s[i]
                val c = s[i + 1]
                if ((b > a && b > c) || (b < a && b < c)) total++
            }
        }
        return total
    }
}
