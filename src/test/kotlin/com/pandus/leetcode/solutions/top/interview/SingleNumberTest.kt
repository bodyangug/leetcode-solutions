package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingleNumberTest {

    private val solution = SingleNumber()

    @Test
    fun testExample1() {
        val nums = intArrayOf(2, 2, 1)
        assertEquals(1, solution.singleNumber(nums))
    }

    @Test
    fun testExample2() {
        val nums = intArrayOf(4, 1, 2, 1, 2)
        assertEquals(4, solution.singleNumber(nums))
    }

    @Test
    fun testExample3() {
        val nums = intArrayOf(1)
        assertEquals(1, solution.singleNumber(nums))
    }

    @Test
    fun testNegativeNumbers() {
        val nums = intArrayOf(-1, -1, -2)
        assertEquals(-2, solution.singleNumber(nums))
    }

    @Test
    fun testLargerArray() {
        val nums = intArrayOf(1, 1, 2, 2, 3, 3, 4, 4, 5)
        assertEquals(5, solution.singleNumber(nums))
    }

    @Test
    fun testZeroInArray() {
        val nums = intArrayOf(0, 1, 1)
        assertEquals(0, solution.singleNumber(nums))
    }
}
