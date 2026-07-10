package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class PathExistenceQueriesInGraphIITest {
    private val solution = PathExistenceQueriesInGraphII()

    @Test
    fun `example 1`() {
        val n = 5
        val nums = intArrayOf(1, 8, 3, 4, 2)
        val maxDiff = 3
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(2, 4))
        assertArrayEquals(intArrayOf(1, 1), solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `example 2`() {
        val n = 5
        val nums = intArrayOf(5, 3, 1, 9, 10)
        val maxDiff = 2
        val queries = arrayOf(intArrayOf(0, 1), intArrayOf(0, 2), intArrayOf(2, 3), intArrayOf(4, 3))
        assertArrayEquals(intArrayOf(1, 2, -1, 1), solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `example 3`() {
        val n = 3
        val nums = intArrayOf(3, 6, 1)
        val maxDiff = 1
        val queries = arrayOf(intArrayOf(0, 0), intArrayOf(0, 1), intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(0, -1, -1), solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `same node query returns zero`() {
        val n = 4
        val nums = intArrayOf(1, 2, 3, 4)
        val maxDiff = 1
        val queries = arrayOf(intArrayOf(2, 2))
        assertArrayEquals(intArrayOf(0), solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `single node graph`() {
        val n = 1
        val nums = intArrayOf(42)
        val maxDiff = 5
        val queries = arrayOf(intArrayOf(0, 0))
        assertArrayEquals(intArrayOf(0), solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `fully connected chain via consecutive values`() {
        val n = 5
        val nums = intArrayOf(10, 11, 12, 13, 14)
        val maxDiff = 1
        val queries = arrayOf(intArrayOf(0, 4), intArrayOf(1, 3), intArrayOf(0, 1))
        assertArrayEquals(intArrayOf(4, 2, 1), solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `no edges when maxDiff is zero and values distinct`() {
        val n = 4
        val nums = intArrayOf(1, 2, 3, 4)
        val maxDiff = 0
        val queries = arrayOf(intArrayOf(0, 1), intArrayOf(2, 3), intArrayOf(0, 3))
        assertArrayEquals(intArrayOf(-1, -1, -1), solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `duplicate values connect with distance one`() {
        val n = 4
        val nums = intArrayOf(7, 7, 7, 7)
        val maxDiff = 0
        val queries = arrayOf(intArrayOf(0, 3), intArrayOf(1, 2))
        assertArrayEquals(intArrayOf(1, 1), solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `two separate components`() {
        val n = 6
        val nums = intArrayOf(1, 2, 3, 100, 101, 102)
        val maxDiff = 1
        val queries = arrayOf(
            intArrayOf(0, 2),
            intArrayOf(3, 5),
            intArrayOf(0, 3),
            intArrayOf(2, 4),
        )
        assertArrayEquals(intArrayOf(2, 2, -1, -1), solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `query order independent of node ordering`() {
        val n = 5
        val nums = intArrayOf(1, 8, 3, 4, 2)
        val maxDiff = 3
        val queries = arrayOf(intArrayOf(3, 0), intArrayOf(4, 2))
        assertArrayEquals(intArrayOf(1, 1), solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }

    @Test
    fun `large gap prevents connection but larger maxDiff connects`() {
        val n = 3
        val nums = intArrayOf(0, 5, 10)
        val queriesConnected = arrayOf(intArrayOf(0, 2))
        assertArrayEquals(intArrayOf(2), solution.pathExistenceQueries(n, nums, 5, queriesConnected))
        assertArrayEquals(intArrayOf(-1), solution.pathExistenceQueries(n, nums, 4, queriesConnected))
    }

    @Test
    fun `empty queries returns empty array`() {
        val n = 3
        val nums = intArrayOf(1, 2, 3)
        val maxDiff = 1
        val queries = arrayOf<IntArray>()
        assertArrayEquals(intArrayOf(), solution.pathExistenceQueries(n, nums, maxDiff, queries))
    }
}
