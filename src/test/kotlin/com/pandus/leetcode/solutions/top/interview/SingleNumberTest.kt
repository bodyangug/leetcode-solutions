package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingleNumberTest {
    @Test
    fun singleNumber_returnsSingle_positiveCase() {
        val solution = SingleNumber()
        assertEquals(1, solution.singleNumber(intArrayOf(2, 2, 1)))
    }

    @Test
    fun singleNumber_returnsMinusOneForNoSingle_negativeCase() {
        val solution = SingleNumber()
        assertEquals(-1, solution.singleNumber(intArrayOf(2, 2)))
    }
}
