package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SqrtXTest {
    @Test
    fun mySqrt_returnsCorrectSqrt_positiveCase() {
        val solution = SqrtX()
        assertEquals(2, solution.mySqrt(4))
    }

    @Test
    fun mySqrt_returnsZeroForZero_negativeCase() {
        val solution = SqrtX()
        assertEquals(0, solution.mySqrt(0))
    }
}
