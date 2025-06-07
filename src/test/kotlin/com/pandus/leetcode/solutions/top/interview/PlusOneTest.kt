package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PlusOneTest {
    @Test
    fun plusOne_incrementsCorrectly_positiveCase() {
        val solution = PlusOne()
        assertArrayEquals(intArrayOf(1, 2, 4), solution.plusOne(intArrayOf(1, 2, 3)))
    }

    @Test
    fun plusOne_handlesAllNines_negativeCase() {
        val solution = PlusOne()
        assertArrayEquals(intArrayOf(1, 0, 0, 0), solution.plusOne(intArrayOf(9, 9, 9)))
    }
}
