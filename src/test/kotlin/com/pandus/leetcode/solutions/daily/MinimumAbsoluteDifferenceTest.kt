package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumAbsoluteDifferenceTest {
    private val solution = MinimumAbsoluteDifference()

    @Test
    fun `test example 1 - unsorted array with multiple pairs having min difference 1`() {
        val arr = intArrayOf(4, 2, 1, 3)
        val expected = listOf(listOf(1, 2), listOf(2, 3), listOf(3, 4))
        assertEquals(expected, solution.minimumAbsDifference(arr))
    }

    @Test
    fun `test example 2 - single pair with minimum difference`() {
        val arr = intArrayOf(1, 3, 6, 10, 15)
        val expected = listOf(listOf(1, 3))
        assertEquals(expected, solution.minimumAbsDifference(arr))
    }

    @Test
    fun `test example 3 - mixed positive and negative numbers`() {
        val arr = intArrayOf(3, 8, -10, 23, 19, -4, -14, 27)
        val expected = listOf(listOf(-14, -10), listOf(19, 23), listOf(23, 27))
        assertEquals(expected, solution.minimumAbsDifference(arr))
    }

    @Test
    fun `test two elements - minimum possible array`() {
        val arr = intArrayOf(5, 10)
        val expected = listOf(listOf(5, 10))
        assertEquals(expected, solution.minimumAbsDifference(arr))
    }

    @Test
    fun `test consecutive numbers`() {
        val arr = intArrayOf(1, 2, 3, 4, 5)
        val expected = listOf(listOf(1, 2), listOf(2, 3), listOf(3, 4), listOf(4, 5))
        assertEquals(expected, solution.minimumAbsDifference(arr))
    }

    @Test
    fun `test all negative numbers`() {
        val arr = intArrayOf(-5, -3, -8, -1)
        val expected = listOf(listOf(-5, -3), listOf(-3, -1))
        assertEquals(expected, solution.minimumAbsDifference(arr))
    }

    @Test
    fun `test large gaps with one minimum pair`() {
        val arr = intArrayOf(1, 100, 200, 201)
        val expected = listOf(listOf(200, 201))
        assertEquals(expected, solution.minimumAbsDifference(arr))
    }

    @Test
    fun `test already sorted array`() {
        val arr = intArrayOf(-10, -5, 0, 5, 10)
        val expected = listOf(listOf(-10, -5), listOf(-5, 0), listOf(0, 5), listOf(5, 10))
        assertEquals(expected, solution.minimumAbsDifference(arr))
    }

    @Test
    fun `test reverse sorted array`() {
        val arr = intArrayOf(10, 8, 6, 4, 2)
        val expected = listOf(listOf(2, 4), listOf(4, 6), listOf(6, 8), listOf(8, 10))
        assertEquals(expected, solution.minimumAbsDifference(arr))
    }

    @Test
    fun `test with duplicates at edges`() {
        val arr = intArrayOf(1, 5, 3, 7)
        val expected = listOf(listOf(1, 3), listOf(3, 5), listOf(5, 7))
        assertEquals(expected, solution.minimumAbsDifference(arr))
    }

    @Test
    fun `test with zero`() {
        val arr = intArrayOf(-2, 0, 2, 4)
        val expected = listOf(listOf(-2, 0), listOf(0, 2), listOf(2, 4))
        assertEquals(expected, solution.minimumAbsDifference(arr))
    }

    @Test
    fun `test large difference between pairs`() {
        val arr = intArrayOf(1, 1000, 2000, 2001, 3000)
        val expected = listOf(listOf(2000, 2001))
        assertEquals(expected, solution.minimumAbsDifference(arr))
    }
}
