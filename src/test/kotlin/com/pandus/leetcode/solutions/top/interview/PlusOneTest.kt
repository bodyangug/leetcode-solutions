package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PlusOneTest {

    private val solution = PlusOne()

    @Test
    fun testExample1() {
        val digits = intArrayOf(1, 2, 3)
        val result = solution.plusOne(digits)
        assertArrayEquals(intArrayOf(1, 2, 4), result)
    }

    @Test
    fun testExample2() {
        val digits = intArrayOf(4, 3, 2, 1)
        val result = solution.plusOne(digits)
        assertArrayEquals(intArrayOf(4, 3, 2, 2), result)
    }

    @Test
    fun testExample3() {
        val digits = intArrayOf(9)
        val result = solution.plusOne(digits)
        assertArrayEquals(intArrayOf(1, 0), result)
    }

    @Test
    fun testCarryOver() {
        val digits = intArrayOf(9, 9, 9)
        val result = solution.plusOne(digits)
        assertArrayEquals(intArrayOf(1, 0, 0, 0), result)
    }

    @Test
    fun testNoCarry() {
        val digits = intArrayOf(1, 2, 3, 4)
        val result = solution.plusOne(digits)
        assertArrayEquals(intArrayOf(1, 2, 3, 5), result)
    }

    @Test
    fun testPartialCarry() {
        val digits = intArrayOf(1, 9, 9)
        val result = solution.plusOne(digits)
        assertArrayEquals(intArrayOf(2, 0, 0), result)
    }
}
