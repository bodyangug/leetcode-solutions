package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseBitsTest {
    @Test
    fun reverseBits_reversesBits_positiveCase() {
        val solution = ReverseBits()
        assertEquals(-1073741825, solution.reverseBits(-3))
    }

    @Test
    fun reverseBits_returnsZeroForZero_negativeCase() {
        val solution = ReverseBits()
        assertEquals(0, solution.reverseBits(0))
    }
}
