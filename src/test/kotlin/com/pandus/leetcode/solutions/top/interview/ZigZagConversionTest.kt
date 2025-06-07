package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ZigZagConversionTest {
    @Test
    fun convert_returnsCorrectZigZag_positiveCase() {
        val solution = ZigZagConversion()
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3))
    }

    @Test
    fun convert_returnsInputForSingleRow_negativeCase() {
        val solution = ZigZagConversion()
        assertEquals("ABC", solution.convert("ABC", 1))
    }
}
