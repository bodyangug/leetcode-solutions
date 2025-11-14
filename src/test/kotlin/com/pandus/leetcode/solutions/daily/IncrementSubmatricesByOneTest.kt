package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class IncrementSubmatricesByOneTest {

    private val solution = IncrementSubmatricesByOne()

    @Test
    @DisplayName("Example 1: n=3 with single query")
    fun testExample1() {
        val n = 3
        val queries = arrayOf(intArrayOf(1, 1, 2, 2))
        val result = solution.rangeAddQueries(n, queries)
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 1, 1),
            intArrayOf(0, 1, 1)
        )
        assertMatricesEqual(expected, result, "Single query should increment submatrix from (1,1) to (2,2)")
    }

    @Test
    @DisplayName("Example 2: n=2 with multiple overlapping queries")
    fun testExample2() {
        val n = 2
        val queries = arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(0, 0, 1, 1)
        )
        val result = solution.rangeAddQueries(n, queries)
        val expected = arrayOf(
            intArrayOf(2, 2),
            intArrayOf(2, 2)
        )
        assertMatricesEqual(expected, result, "Overlapping queries should add up")
    }

    @Test
    @DisplayName("n=1 with single cell query")
    fun testSingleCell() {
        val n = 1
        val queries = arrayOf(intArrayOf(0, 0, 0, 0))
        val result = solution.rangeAddQueries(n, queries)
        val expected = arrayOf(intArrayOf(1))
        assertMatricesEqual(expected, result, "Single cell should be incremented")
    }

    @Test
    @DisplayName("Empty queries - all zeros")
    fun testEmptyQueries() {
        val n = 3
        val queries = arrayOf<IntArray>()
        val result = solution.rangeAddQueries(n, queries)
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertMatricesEqual(expected, result, "No queries should result in all zeros")
    }

    @Test
    @DisplayName("Full matrix query")
    fun testFullMatrixQuery() {
        val n = 3
        val queries = arrayOf(intArrayOf(0, 0, 2, 2))
        val result = solution.rangeAddQueries(n, queries)
        val expected = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(1, 1, 1)
        )
        assertMatricesEqual(expected, result, "Full matrix query should increment all cells")
    }

    @Test
    @DisplayName("Non-overlapping queries")
    fun testNonOverlappingQueries() {
        val n = 4
        val queries = arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(2, 2, 3, 3)
        )
        val result = solution.rangeAddQueries(n, queries)
        val expected = arrayOf(
            intArrayOf(1, 1, 0, 0),
            intArrayOf(1, 1, 0, 0),
            intArrayOf(0, 0, 1, 1),
            intArrayOf(0, 0, 1, 1)
        )
        assertMatricesEqual(expected, result, "Non-overlapping queries should create separate regions")
    }

    @Test
    @DisplayName("Partially overlapping queries")
    fun testPartiallyOverlappingQueries() {
        val n = 3
        val queries = arrayOf(
            intArrayOf(0, 0, 1, 1),
            intArrayOf(1, 1, 2, 2)
        )
        val result = solution.rangeAddQueries(n, queries)
        val expected = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 2, 1),
            intArrayOf(0, 1, 1)
        )
        assertMatricesEqual(expected, result, "Overlapping region should have sum of increments")
    }

    @Test
    @DisplayName("Single row query")
    fun testSingleRowQuery() {
        val n = 3
        val queries = arrayOf(intArrayOf(1, 0, 1, 2))
        val result = solution.rangeAddQueries(n, queries)
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0)
        )
        assertMatricesEqual(expected, result, "Single row should be incremented")
    }

    @Test
    @DisplayName("Single column query")
    fun testSingleColumnQuery() {
        val n = 3
        val queries = arrayOf(intArrayOf(0, 1, 2, 1))
        val result = solution.rangeAddQueries(n, queries)
        val expected = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 1, 0)
        )
        assertMatricesEqual(expected, result, "Single column should be incremented")
    }

    @Test
    @DisplayName("Multiple queries with complex overlaps")
    fun testComplexOverlaps() {
        val n = 3
        val queries = arrayOf(
            intArrayOf(0, 0, 2, 2),
            intArrayOf(1, 1, 2, 2),
            intArrayOf(0, 0, 0, 0)
        )
        val result = solution.rangeAddQueries(n, queries)
        val expected = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(1, 2, 2),
            intArrayOf(1, 2, 2)
        )
        assertMatricesEqual(expected, result, "Complex overlapping queries should calculate correctly")
    }

    @Test
    @DisplayName("Corner cell queries")
    fun testCornerCells() {
        val n = 3
        val queries = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 2, 0, 2),
            intArrayOf(2, 0, 2, 0),
            intArrayOf(2, 2, 2, 2)
        )
        val result = solution.rangeAddQueries(n, queries)
        val expected = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1)
        )
        assertMatricesEqual(expected, result, "All four corners should be incremented")
    }

    private fun assertMatricesEqual(expected: Array<IntArray>, actual: Array<IntArray?>, message: String) {
        assert(expected.size == actual.size) { "$message - Matrix sizes don't match" }
        for (i in expected.indices) {
            assertArrayEquals(expected[i], actual[i], "$message - Row $i doesn't match")
        }
    }
}
