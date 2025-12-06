package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountPartitionsWithMaxMinDifferenceAtMostKTest {
    private val solution = CountPartitionsWithMaxMinDifferenceAtMostK()

    @Test
    fun `test example 1`() {
        val nums = intArrayOf(9, 4, 1, 3, 7)
        val k = 4
        val expected = 6
        assertEquals(expected, solution.countPartitions(nums, k))
    }

    @Test
    fun `test example 2`() {
        val nums = intArrayOf(3, 3, 4)
        val k = 0
        val expected = 2
        assertEquals(expected, solution.countPartitions(nums, k))
    }

    @Test
    fun `test single element`() {
        val nums = intArrayOf(5)
        val k = 0
        val expected = 1
        assertEquals(expected, solution.countPartitions(nums, k))
    }

    @Test
    fun `test all elements same`() {
        val nums = intArrayOf(2, 2, 2)
        val k = 0
        val expected = 4 // All possible partitions
        assertEquals(expected, solution.countPartitions(nums, k))
    }

    @Test
    fun `test empty array`() {
        val nums = intArrayOf()
        val k = 5
        val expected = 1 // Only one way: no partition
        assertEquals(expected, solution.countPartitions(nums, k))
    }
}