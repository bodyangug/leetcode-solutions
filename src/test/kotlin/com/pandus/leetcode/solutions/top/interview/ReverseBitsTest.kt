package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseBitsTest {

    private val solution = ReverseBits()

    @Test
    fun testExample1() {
        // 00000010100101000001111010011100 -> 00111001011110000010100101000000
        assertEquals(964176192, solution.reverseBits(43261596))
    }

    @Test
    fun testExample2() {
        // 11111111111111111111111111111101 -> 10111111111111111111111111111111
        assertEquals(-1073741825, solution.reverseBits(-3))
    }

    @Test
    fun testZero() {
        assertEquals(0, solution.reverseBits(0))
    }

    @Test
    fun testOne() {
        // 00000000000000000000000000000001 -> 10000000000000000000000000000000
        assertEquals(-2147483648, solution.reverseBits(1))
    }

    @Test
    fun testAllOnes() {
        assertEquals(-1, solution.reverseBits(-1)) // All 1s reversed is still all 1s
    }

    @Test
    fun testPowerOfTwo() {
        // 00000000000000000000000000000010 -> 01000000000000000000000000000000
        assertEquals(1073741824, solution.reverseBits(2))
    }
}
