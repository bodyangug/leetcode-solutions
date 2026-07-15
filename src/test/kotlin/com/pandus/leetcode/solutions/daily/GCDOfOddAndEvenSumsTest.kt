package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GCDOfOddAndEvenSumsTest {
    private val solution = GCDOfOddAndEvenSums()

    @Test
    fun `test n equals 4`() {
        assertEquals(4, solution.gcdOfOddEvenSums(4))
    }

    @Test
    fun `test n equals 5`() {
        assertEquals(5, solution.gcdOfOddEvenSums(5))
    }

    @Test
    fun `test n equals 1`() {
        assertEquals(1, solution.gcdOfOddEvenSums(1))
    }

    @Test
    fun `test n equals 2`() {
        assertEquals(2, solution.gcdOfOddEvenSums(2))
    }

    @Test
    fun `test larger n`() {
        assertEquals(1000, solution.gcdOfOddEvenSums(1000))
    }
}
