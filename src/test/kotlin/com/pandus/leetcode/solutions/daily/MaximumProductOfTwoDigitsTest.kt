package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumProductOfTwoDigitsTest {
    private val solution = MaximumProductOfTwoDigits()

    @Test
    fun `test example 1`() {
        assertEquals(3, solution.maxProduct(31))
    }

    @Test
    fun `test example 2`() {
        assertEquals(4, solution.maxProduct(22))
    }

    @Test
    fun `test example 3`() {
        assertEquals(8, solution.maxProduct(124))
    }

    @Test
    fun `test with zero digit`() {
        assertEquals(0, solution.maxProduct(105))
    }

    @Test
    fun `test all nines`() {
        assertEquals(81, solution.maxProduct(999))
    }

    @Test
    fun `test large number`() {
        assertEquals(72, solution.maxProduct(123456789))
    }

    @Test
    fun `test ascending digits`() {
        assertEquals(72, solution.maxProduct(89))
    }
}
