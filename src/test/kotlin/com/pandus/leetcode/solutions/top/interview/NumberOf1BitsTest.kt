package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOf1BitsTest {

    private val solution = NumberOf1Bits()

    @Test
    fun testExample1() {
        assertEquals(3, solution.hammingWeight(11)) // 1011 has 3 ones
    }

    @Test
    fun testExample2() {
        assertEquals(1, solution.hammingWeight(128)) // 10000000 has 1 one
    }

    @Test
    fun testExample3() {
        assertEquals(31, solution.hammingWeight(-3)) // Two's complement representation
    }

    @Test
    fun testZero() {
        assertEquals(0, solution.hammingWeight(0))
    }

    @Test
    fun testPowerOfTwo() {
        assertEquals(1, solution.hammingWeight(1))
        assertEquals(1, solution.hammingWeight(2))
        assertEquals(1, solution.hammingWeight(4))
        assertEquals(1, solution.hammingWeight(8))
        assertEquals(1, solution.hammingWeight(16))
    }

    @Test
    fun testAllOnes() {
        assertEquals(4, solution.hammingWeight(15)) // 1111 has 4 ones
    }
}
