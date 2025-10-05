package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SqrtXTest {

    private val solution = SqrtX()

    @Test
    fun testExample1() {
        assertEquals(2, solution.mySqrt(4))
    }

    @Test
    fun testExample2() {
        assertEquals(2, solution.mySqrt(8)) // sqrt(8) = 2.828..., truncated to 2
    }

    @Test
    fun testPerfectSquares() {
        assertEquals(0, solution.mySqrt(0))
        assertEquals(1, solution.mySqrt(1))
        assertEquals(3, solution.mySqrt(9))
        assertEquals(4, solution.mySqrt(16))
        assertEquals(5, solution.mySqrt(25))
        assertEquals(10, solution.mySqrt(100))
    }

    @Test
    fun testNonPerfectSquares() {
        assertEquals(1, solution.mySqrt(2))
        assertEquals(1, solution.mySqrt(3))
        assertEquals(2, solution.mySqrt(5))
        assertEquals(2, solution.mySqrt(6))
        assertEquals(2, solution.mySqrt(7))
        assertEquals(3, solution.mySqrt(10))
    }

    @Test
    fun testLargeNumbers() {
        assertEquals(46340, solution.mySqrt(2147395600)) // Large number test
    }
}
