package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ClosestEqualElementQueriesTest {
    private val solution = ClosestEqualElementQueries()

    @Test
    fun solveQueries_example1_returnsCorrectDistances() {
        // Input: nums = [1,3,1,4,1,3,2], queries = [0,3,5]
        // Output: [2,-1,3]
        val result = solution.solveQueries(intArrayOf(1, 3, 1, 4, 1, 3, 2), intArrayOf(0, 3, 5))
        assertEquals(listOf(2, -1, 3), result)
    }

    @Test
    fun solveQueries_example2_allUniqueValues_returnsAllMinusOne() {
        // Input: nums = [1,2,3,4], queries = [0,1,2,3]
        // Output: [-1,-1,-1,-1]
        val result = solution.solveQueries(intArrayOf(1, 2, 3, 4), intArrayOf(0, 1, 2, 3))
        assertEquals(listOf(-1, -1, -1, -1), result)
    }

    @Test
    fun solveQueries_circularDistance_usesShortestPath() {
        // nums = [1,2,1], query index 0: nearest 1 is at index 2, direct=2, circular=1 -> answer=1
        val result = solution.solveQueries(intArrayOf(1, 2, 1), intArrayOf(0))
        assertEquals(listOf(1), result)
    }

    @Test
    fun solveQueries_adjacentDuplicates_returnsOne() {
        // nums = [5,5,5], all distances between adjacent indices = 1
        val result = solution.solveQueries(intArrayOf(5, 5, 5), intArrayOf(0, 1, 2))
        assertEquals(listOf(1, 1, 1), result)
    }

    @Test
    fun solveQueries_singleElement_returnsMinusOne() {
        // Only one element, no other index to compare
        val result = solution.solveQueries(intArrayOf(7), intArrayOf(0))
        assertEquals(listOf(-1), result)
    }

    @Test
    fun solveQueries_twoIdenticalElements_returnsOne() {
        // nums = [3,3], circular distance between index 0 and 1 is min(1, 1) = 1
        val result = solution.solveQueries(intArrayOf(3, 3), intArrayOf(0, 1))
        assertEquals(listOf(1, 1), result)
    }
}
