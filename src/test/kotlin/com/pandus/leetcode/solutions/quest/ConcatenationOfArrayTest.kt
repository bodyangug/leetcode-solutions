package com.pandus.leetcode.solutions.quest

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ConcatenationOfArrayTest {
    private val solution = ConcatenationOfArray()

    @Test
    fun `should concatenate array with multiple elements`() {
        val result = solution.getConcatenation(intArrayOf(1, 2, 1))
        assertArrayEquals(intArrayOf(1, 2, 1, 1, 2, 1), result)
    }

    @Test
    fun `should concatenate array with single element`() {
        val result = solution.getConcatenation(intArrayOf(1))
        assertArrayEquals(intArrayOf(1, 1), result)
    }

    @Test
    fun `should concatenate array with two elements`() {
        val result = solution.getConcatenation(intArrayOf(1, 3))
        assertArrayEquals(intArrayOf(1, 3, 1, 3), result)
    }

    @Test
    fun `should handle array with larger numbers`() {
        val result = solution.getConcatenation(intArrayOf(100, 200, 300))
        assertArrayEquals(intArrayOf(100, 200, 300, 100, 200, 300), result)
    }

    @Test
    fun `should handle array with zeros`() {
        val result = solution.getConcatenation(intArrayOf(0, 0, 0))
        assertArrayEquals(intArrayOf(0, 0, 0, 0, 0, 0), result)
    }

    @Test
    fun `should handle array with negative numbers`() {
        val result = solution.getConcatenation(intArrayOf(-1, -2, -3))
        assertArrayEquals(intArrayOf(-1, -2, -3, -1, -2, -3), result)
    }

    @Test
    fun `should handle array with mixed positive and negative numbers`() {
        val result = solution.getConcatenation(intArrayOf(-5, 10, -3, 7))
        assertArrayEquals(intArrayOf(-5, 10, -3, 7, -5, 10, -3, 7), result)
    }
}
