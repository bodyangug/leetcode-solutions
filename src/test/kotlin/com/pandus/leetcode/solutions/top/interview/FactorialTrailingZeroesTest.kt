package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FactorialTrailingZeroesTest {
    @Test
    fun trailingZeroes_returnsCorrectCount_positiveCase() {
        val solution = FactorialTrailingZeroes()
        assertEquals(1, solution.trailingZeroes(5))
    }

    @Test
    fun trailingZeroes_returnsZeroForZero_negativeCase() {
        val solution = FactorialTrailingZeroes()
        assertEquals(0, solution.trailingZeroes(0))
    }
}
