package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumPairRemovalToSortArrayITest {
    private val solution = MinimumPairRemovalToSortArrayI()

    @Test
    fun `test example 1 - requires two operations`() {
        val nums = intArrayOf(5, 2, 3, 1)
        val expected = 2
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test example 2 - already sorted array`() {
        val nums = intArrayOf(1, 2, 2)
        val expected = 0
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test single element array`() {
        val nums = intArrayOf(5)
        val expected = 0
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test two elements ascending`() {
        val nums = intArrayOf(1, 2)
        val expected = 0
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test two elements descending`() {
        val nums = intArrayOf(2, 1)
        val expected = 1
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test all equal elements`() {
        val nums = intArrayOf(5, 5, 5, 5)
        val expected = 0
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test strictly increasing array`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val expected = 0
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test strictly decreasing array`() {
        val nums = intArrayOf(5, 4, 3, 2, 1)
        val expected = 4
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test array with large numbers`() {
        val nums = intArrayOf(1000, 500, 750)
        val expected = 1
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test array with zeros`() {
        val nums = intArrayOf(0, 0, 0)
        val expected = 0
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test array with mixed positive and zero`() {
        val nums = intArrayOf(5, 0, 3, 1)
        val expected = 3
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test array partially sorted at beginning`() {
        val nums = intArrayOf(1, 2, 3, 1, 2)
        val expected = 2
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test array partially sorted at end`() {
        val nums = intArrayOf(5, 3, 1, 2, 3)
        val expected = 3
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test array with alternating high and low values`() {
        val nums = intArrayOf(10, 1, 10, 1, 10)
        val expected = 3
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }

    @Test
    fun `test long sorted array`() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val expected = 0
        assertEquals(expected, solution.minimumPairRemoval(nums))
    }
}
