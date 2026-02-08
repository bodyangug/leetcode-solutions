package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumRemovalsToBalanceArrayTest {
    private val solution = MinimumRemovalsToBalanceArray()

    @Test
    fun `test example 1 - remove one element`() {
        val nums = intArrayOf(2, 1, 5)
        val k = 2
        val expected = 1
        assertEquals(expected, solution.minRemoval(nums, k))
    }

    @Test
    fun `test example 2 - remove two elements`() {
        val nums = intArrayOf(1, 6, 2, 9)
        val k = 3
        val expected = 2
        assertEquals(expected, solution.minRemoval(nums, k))
    }

    @Test
    fun `test example 3 - already balanced`() {
        val nums = intArrayOf(4, 6)
        val k = 2
        val expected = 0
        assertEquals(expected, solution.minRemoval(nums, k))
    }

    @Test
    fun `test single element array`() {
        val nums = intArrayOf(5)
        val k = 1
        val expected = 0
        assertEquals(expected, solution.minRemoval(nums, k))
    }

    @Test
    fun `test all elements equal`() {
        val nums = intArrayOf(3, 3, 3, 3)
        val k = 1
        val expected = 0
        assertEquals(expected, solution.minRemoval(nums, k))
    }

    @Test
    fun `test large k value`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val k = 10
        val expected = 0
        assertEquals(expected, solution.minRemoval(nums, k))
    }

    @Test
    fun `test k equals 1 with different elements`() {
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val k = 1
        val expected = 4
        assertEquals(expected, solution.minRemoval(nums, k))
    }

    @Test
    fun `test two elements balanced`() {
        val nums = intArrayOf(1, 2)
        val k = 2
        val expected = 0
        assertEquals(expected, solution.minRemoval(nums, k))
    }

    @Test
    fun `test two elements not balanced`() {
        val nums = intArrayOf(1, 5)
        val k = 2
        val expected = 1
        assertEquals(expected, solution.minRemoval(nums, k))
    }

    @Test
    fun `test remove minimum element`() {
        val nums = intArrayOf(1, 10, 11, 12)
        val k = 2
        val expected = 1
        assertEquals(expected, solution.minRemoval(nums, k))
    }

    @Test
    fun `test remove maximum element`() {
        val nums = intArrayOf(5, 6, 7, 100)
        val k = 2
        val expected = 1
        assertEquals(expected, solution.minRemoval(nums, k))
    }

    @Test
    fun `test unsorted input array`() {
        val nums = intArrayOf(9, 1, 5, 3, 7)
        val k = 3
        val expected = 1
        assertEquals(expected, solution.minRemoval(nums, k))
    }
}
