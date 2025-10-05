package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingleNumberIITest {

    private val solution = SingleNumberII()

    @Test
    fun testExample1() {
        val nums = intArrayOf(2, 2, 3, 2)
        assertEquals(3, solution.singleNumber(nums))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(0, 1, 0, 1, 0, 1, 99)
        assertEquals(99, solution.singleNumber(nums))
    }

    @Test
    fun testSingleElement() {
        val nums = intArrayOf(5)
        assertEquals(5, solution.singleNumber(nums))
    }

    @Test
    fun testNegativeNumbers() {
        val nums = intArrayOf(-1, -1, -1, -2)
        assertEquals(-2, solution.singleNumber(nums))
    }

    @Test
    fun testLargerArray() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 2, 3, 3, 3, 4)
        assertEquals(4, solution.singleNumber(nums))
    }

    @Test
    fun testZeroInArray() {
        val nums = intArrayOf(0, 0, 0, 1)
        assertEquals(1, solution.singleNumber(nums))
    }
}
