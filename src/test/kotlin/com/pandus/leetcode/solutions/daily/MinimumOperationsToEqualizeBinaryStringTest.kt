package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumOperationsToEqualizeBinaryStringTest {
    private val solution = MinimumOperationsToEqualizeBinaryString()

    @Test
    fun `test example 1 - single zero with k equals 1`() {
        val s = "110"
        val k = 1
        val expected = 1
        assertEquals(expected, solution.minOperations(s, k))
    }

    @Test
    fun `test example 2 - multiple operations needed`() {
        val s = "0101"
        val k = 3
        val expected = 2
        assertEquals(expected, solution.minOperations(s, k))
    }

    @Test
    fun `test example 3 - impossible case`() {
        val s = "101"
        val k = 2
        val expected = -1
        assertEquals(expected, solution.minOperations(s, k))
    }

    @Test
    fun `test all ones - no operation needed`() {
        val s = "1111"
        val k = 2
        val expected = 0
        assertEquals(expected, solution.minOperations(s, k))
    }

    @Test
    fun `test single character zero`() {
        val s = "0"
        val k = 1
        val expected = 1
        assertEquals(expected, solution.minOperations(s, k))
    }

    @Test
    fun `test single character one`() {
        val s = "1"
        val k = 1
        val expected = 0
        assertEquals(expected, solution.minOperations(s, k))
    }

    @Test
    fun `test all zeros with k equals length`() {
        val s = "0000"
        val k = 4
        val expected = 1
        assertEquals(expected, solution.minOperations(s, k))
    }
}
