package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfZigZagArraysIITest {
    private val solution = NumberOfZigZagArraysII()

    @Test
    fun `example 1 two values length three`() {
        assertEquals(2, solution.zigZagArrays(3, 4, 5))
    }

    @Test
    fun `example 2 three values length three`() {
        assertEquals(10, solution.zigZagArrays(3, 1, 3))
    }

    @Test
    fun `length one returns range size`() {
        assertEquals(5, solution.zigZagArrays(1, 1, 5))
    }

    @Test
    fun `length one single value`() {
        assertEquals(1, solution.zigZagArrays(1, 7, 7))
    }

    @Test
    fun `length two counts all unequal pairs`() {
        // k*(k-1) = 3*2 = 6
        assertEquals(6, solution.zigZagArrays(2, 1, 3))
    }

    @Test
    fun `length two with single value gives zero`() {
        assertEquals(0, solution.zigZagArrays(2, 4, 4))
    }

    @Test
    fun `length three with single value gives zero`() {
        assertEquals(0, solution.zigZagArrays(3, 2, 2))
    }

    @Test
    fun `length four three values`() {
        // Hand-computed via DP: answer = 16
        assertEquals(16, solution.zigZagArrays(4, 1, 3))
    }

    @Test
    fun `shifted range produces same count`() {
        // Only depends on range size, not on absolute values.
        assertEquals(
            solution.zigZagArrays(5, 1, 4),
            solution.zigZagArrays(5, 100, 103),
        )
    }

    @Test
    fun `length five two values`() {
        // [1,2,1,2,1] and [2,1,2,1,2] -> 2
        assertEquals(2, solution.zigZagArrays(5, 1, 2))
    }

    @Test
    fun `large length stays within int range and is modded`() {
        // Smoke test that matrix exponentiation handles a large n quickly.
        val result = solution.zigZagArrays(1_000_000_000, 1, 5)
        // Just ensure it's a valid non-negative result less than the modulus.
        val mod = 1_000_000_007
        assert(result in 0 until mod)
    }
}
