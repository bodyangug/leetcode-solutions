package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RotateFunctionTest {
    private val solution = RotateFunction()

    @Test
    fun `example 1 - nums 4,3,2,6 returns 26`() {
        assertEquals(26, solution.maxRotateFunction(intArrayOf(4, 3, 2, 6)))
    }

    @Test
    fun `example 2 - single element returns 0`() {
        assertEquals(0, solution.maxRotateFunction(intArrayOf(100)))
    }

    @Test
    fun `all zeros returns 0`() {
        assertEquals(0, solution.maxRotateFunction(intArrayOf(0, 0, 0)))
    }

    @Test
    fun `two elements`() {
        assertEquals(3, solution.maxRotateFunction(intArrayOf(1, 3)))
    }
}

