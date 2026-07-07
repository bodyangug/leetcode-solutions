package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ConcatenateNonZeroDigitsAndMultiplyBySumITest {
    private val solution = ConcatenateNonZeroDigitsAndMultiplyBySumI()

    @Test
    fun sumAndMultiply_example1_returns12340() {
        assertEquals(12340L, solution.sumAndMultiply(10203004))
    }

    @Test
    fun sumAndMultiply_example2_returns1() {
        assertEquals(1L, solution.sumAndMultiply(1000))
    }

    @Test
    fun sumAndMultiply_noZeros_returnsProduct() {
        assertEquals(1234L * 10, solution.sumAndMultiply(1234))
    }

    @Test
    fun sumAndMultiply_singleDigit_returnsSquare() {
        assertEquals(49L, solution.sumAndMultiply(7))
    }

    @Test
    fun sumAndMultiply_singleDigitOne_returns1() {
        assertEquals(1L, solution.sumAndMultiply(1))
    }

    @Test
    fun sumAndMultiply_allZerosAfterLeading_returns1() {
        assertEquals(1L, solution.sumAndMultiply(100000))
    }

    @Test
    fun sumAndMultiply_singleNonZeroDigitWithZeros_returnsSquare() {
        assertEquals(81L, solution.sumAndMultiply(90000000))
    }

    @Test
    fun sumAndMultiply_zerosInterspersed_returnsCorrectValue() {
        assertEquals(123L * 6, solution.sumAndMultiply(1002003))
    }

    @Test
    fun sumAndMultiply_leadingAndTrailingZeros_ignoresZeros() {
        assertEquals(56L * 11, solution.sumAndMultiply(500600))
    }

    @Test
    fun sumAndMultiply_zeroInput_returns0() {
        assertEquals(0L, solution.sumAndMultiply(0))
    }

    @Test
    fun sumAndMultiply_maxIntNoZeros_handlesLargeConcatenation() {
        assertEquals(2147483647L * 46, solution.sumAndMultiply(2147483647))
    }
}
