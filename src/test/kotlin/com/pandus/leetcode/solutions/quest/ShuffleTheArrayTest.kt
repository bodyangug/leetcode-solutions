package com.pandus.leetcode.solutions.quest

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ShuffleTheArrayTest {
    private val solution = ShuffleTheArray()

    @Test
    fun `should shuffle array with three pairs`() {
        val result = solution.shuffle(intArrayOf(2, 5, 1, 3, 4, 7), 3)
        assertArrayEquals(intArrayOf(2, 3, 5, 4, 1, 7), result)
    }

    @Test
    fun `should shuffle array with four pairs`() {
        val result = solution.shuffle(intArrayOf(1, 2, 3, 4, 4, 3, 2, 1), 4)
        assertArrayEquals(intArrayOf(1, 4, 2, 3, 3, 2, 4, 1), result)
    }

    @Test
    fun `should shuffle array with one pair`() {
        val result = solution.shuffle(intArrayOf(1, 1), 1)
        assertArrayEquals(intArrayOf(1, 1), result)
    }

    @Test
    fun `should shuffle array with two pairs`() {
        val result = solution.shuffle(intArrayOf(1, 2, 3, 4), 2)
        assertArrayEquals(intArrayOf(1, 3, 2, 4), result)
    }

    @Test
    fun `should handle array with zeros`() {
        val result = solution.shuffle(intArrayOf(0, 0, 0, 0), 2)
        assertArrayEquals(intArrayOf(0, 0, 0, 0), result)
    }

    @Test
    fun `should handle array with negative numbers`() {
        val result = solution.shuffle(intArrayOf(-1, -2, 1, 2), 2)
        assertArrayEquals(intArrayOf(-1, 1, -2, 2), result)
    }

    @Test
    fun `should handle array with larger numbers`() {
        val result = solution.shuffle(intArrayOf(100, 200, 300, 400, 500, 600), 3)
        assertArrayEquals(intArrayOf(100, 400, 200, 500, 300, 600), result)
    }

    @Test
    fun `should shuffle array preserving element order within groups`() {
        val result = solution.shuffle(intArrayOf(5, 10, 15, 20, 25, 30), 3)
        assertArrayEquals(intArrayOf(5, 20, 10, 25, 15, 30), result)
    }

    @Test
    fun `should handle array with duplicate values`() {
        val result = solution.shuffle(intArrayOf(7, 7, 7, 7, 7, 7), 3)
        assertArrayEquals(intArrayOf(7, 7, 7, 7, 7, 7), result)
    }

    @Test
    fun `should handle array with mixed positive and negative numbers`() {
        val result = solution.shuffle(intArrayOf(-5, 10, -3, 7, 8, -1), 3)
        assertArrayEquals(intArrayOf(-5, 7, 10, 8, -3, -1), result)
    }
}
