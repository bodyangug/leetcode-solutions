package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

class NextGreaterNumericallyBalancedNumberTest {
    private val solver = NextGreaterNumericallyBalancedNumber()

    // Helper used only in tests to independently verify a number is numerically balanced
    private fun isBalanced(x: Int): Boolean {
        val counts = IntArray(10)
        var n = x
        while (n > 0) {
            counts[n % 10]++
            n /= 10
        }
        for (d in 0..9) {
            if (counts[d] > 0 && counts[d] != d) return false
        }
        return true
    }

    @Test
    @DisplayName("Basic known examples from problem statement")
    fun testKnownExamples() {
        assertEquals(22, solver.nextBeautifulNumber(1))
        assertEquals(1333, solver.nextBeautifulNumber(1000))
        assertEquals(3133, solver.nextBeautifulNumber(3000))
    }

    @Test
    fun testAroundSimpleBoundaries() {
        assertEquals(1, solver.nextBeautifulNumber(0))
        assertEquals(122, solver.nextBeautifulNumber(22))
        assertEquals(212, solver.nextBeautifulNumber(122))
        assertEquals(1224444, solver.nextBeautifulNumber(1224443))
        assertEquals(-1, solver.nextBeautifulNumber(1224444))
    }

    @Test
    fun testResultIsAlwaysBalancedAndGreater() {
        val samples = listOf(0, 1, 21, 999, 1000, 122, 3000, 4000, 50000, 1224443)
        for (n in samples) {
            val next = solver.nextBeautifulNumber(n)
            if (next != -1) {
                assertTrue(next > n, "Expected next ($next) to be greater than input $n")
                assertTrue(isBalanced(next), "Expected $next to be numerically balanced")
            } else {
                // Only valid case for -1 is when n is the upper limit (1224444) or above
                assertTrue(n >= 1224444, "-1 should only occur at or beyond the upper search limit; n=$n")
            }
        }
    }

    @Test
    fun testSequentialProgressionFromSample() {
        // Verify a short ascending sequence of balanced numbers
        val expectedSequence = listOf(1, 22, 122, 212, 221, 333, 1333, 3133)
        for (i in 0 until expectedSequence.size - 1) {
            val current = expectedSequence[i]
            val expectedNext = expectedSequence[i + 1]
            assertEquals(expectedNext, solver.nextBeautifulNumber(current), "Next after $current should be $expectedNext")
        }
    }
}

