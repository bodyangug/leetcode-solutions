package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SortedGCDPairQueriesTest {
    private val solution = SortedGCDPairQueries()

    @Test
    fun `example 1`() {
        val nums = intArrayOf(2, 3, 4)
        val queries = longArrayOf(0, 2, 2)
        val expected = intArrayOf(1, 2, 2)
        assertArrayEquals(expected, solution.gcdValues(nums, queries))
    }
 
    @Test
    fun `example 2`() {
        val nums = intArrayOf(4, 4, 2, 1)
        val queries = longArrayOf(5, 3, 1, 0)
        val expected = intArrayOf(4, 2, 1, 1)
        assertArrayEquals(expected, solution.gcdValues(nums, queries))
    }

    @Test
    fun `example 3`() {
        val nums = intArrayOf(2, 2)
        val queries = longArrayOf(0, 0)
        val expected = intArrayOf(2, 2)
        assertArrayEquals(expected, solution.gcdValues(nums, queries))
    }
}
