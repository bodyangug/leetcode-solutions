package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PowXNTest {
    @Test
    fun myPow_returnsCorrectPower_positiveCase() {
        val solution = PowXN()
        assertEquals(8.0, solution.myPow(2.0, 3))
    }

    @Test
    fun myPow_returnsOneForZeroPower_negativeCase() {
        val solution = PowXN()
        assertEquals(1.0, solution.myPow(2.0, 0))
    }
}
