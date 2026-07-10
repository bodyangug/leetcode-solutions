package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PathExistenceQueriesInGraphITest {
    private val solution = PathExistenceQueriesInGraphI()

    @Test
    fun `example 1`() {
        val n = 2
        val nums = intArrayOf(1, 3)
        val maxDiff = 1
        val queries = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1))
        val expected = booleanArrayOf(true, false)
        assertArrayEquals(expected, solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `example 2`() {
        val n = 4
        val nums = intArrayOf(2, 5, 6, 8)
        val maxDiff = 2
        val queries = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 3),
            intArrayOf(2, 3),
        )
        val expected = booleanArrayOf(false, false, true, true)
        assertArrayEquals(expected, solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `single node self query`() {
        val n = 1
        val nums = intArrayOf(5)
        val maxDiff = 0
        val queries = arrayOf(intArrayOf(0, 0))
        val expected = booleanArrayOf(true)
        assertArrayEquals(expected, solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `all nodes connected`() {
        val n = 5
        val nums = intArrayOf(1, 2, 3, 4, 5)
        val maxDiff = 1
        val queries = arrayOf(
            intArrayOf(0, 4),
            intArrayOf(1, 3),
            intArrayOf(0, 2),
        )
        val expected = booleanArrayOf(true, true, true)
        assertArrayEquals(expected, solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `no edges when maxDiff too small`() {
        val n = 4
        val nums = intArrayOf(1, 3, 5, 7)
        val maxDiff = 1
        val queries = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(0, 3),
        )
        val expected = booleanArrayOf(false, false, false)
        assertArrayEquals(expected, solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `multiple separate components`() {
        val n = 6
        val nums = intArrayOf(1, 2, 10, 11, 20, 21)
        val maxDiff = 1
        val queries = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(2, 3),
            intArrayOf(4, 5),
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(0, 5),
        )
        val expected = booleanArrayOf(true, true, true, false, false, false)
        assertArrayEquals(expected, solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `equal values with zero maxDiff`() {
        val n = 4
        val nums = intArrayOf(3, 3, 3, 3)
        val maxDiff = 0
        val queries = arrayOf(
            intArrayOf(0, 3),
            intArrayOf(1, 2),
        )
        val expected = booleanArrayOf(true, true)
        assertArrayEquals(expected, solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }
}
