package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.math.abs

class PowXNTest {

    private val solution = PowXN()
    private val epsilon = 1e-9

    @Test
    fun testExample1() {
        val result = solution.myPow(2.0, 10)
        assertTrue(abs(result - 1024.0) < epsilon)
    }

    @Test
    fun testExample2() {
        val result = solution.myPow(2.1, 3)
        assertTrue(abs(result - 9.261) < 0.001)
    }

    @Test
    fun testExample3() {
        val result = solution.myPow(2.0, -2)
        assertTrue(abs(result - 0.25) < epsilon)
    }

    @Test
    fun testPowerOfZero() {
        assertEquals(1.0, solution.myPow(5.0, 0), epsilon)
        assertEquals(1.0, solution.myPow(-3.0, 0), epsilon)
    }

    @Test
    fun testNegativeBase() {
        assertEquals(-8.0, solution.myPow(-2.0, 3), epsilon)
        assertEquals(4.0, solution.myPow(-2.0, 2), epsilon)
    }

    @Test
    fun testFractionalBase() {
        assertEquals(0.25, solution.myPow(0.5, 2), epsilon)
    }

    @Test
    fun testLargeExponent() {
        val result = solution.myPow(1.00001, 123456)
        assertTrue(result > 0)
    }
}
