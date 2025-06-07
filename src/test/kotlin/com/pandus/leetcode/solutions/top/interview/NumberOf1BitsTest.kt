package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOf1BitsTest {
    @Test
    fun hammingWeight_returnsCorrectCount_positiveCase() {
        val solution = NumberOf1Bits()
        assertEquals(3, solution.hammingWeight(11)) // 1011
    }

    @Test
    fun hammingWeight_returnsZeroForZero_negativeCase() {
        val solution = NumberOf1Bits()
        assertEquals(0, solution.hammingWeight(0))
    }
}
