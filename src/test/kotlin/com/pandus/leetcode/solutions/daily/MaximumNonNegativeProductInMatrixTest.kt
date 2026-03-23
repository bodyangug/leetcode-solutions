package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNonNegativeProductInMatrixTest {
    private val solution = MaximumNonNegativeProductInMatrix()

    @Test
    fun `example 1 - all negative values returns -1`() {
        val grid = arrayOf(intArrayOf(-1, -2, -3), intArrayOf(-2, -3, -3), intArrayOf(-3, -3, -2))
        assertEquals(-1, solution.maxProductPath(grid))
    }

    @Test
    fun `example 2 - path through two negatives yields positive product 8`() {
        val grid = arrayOf(intArrayOf(1, -2, 1), intArrayOf(1, -2, 1), intArrayOf(3, -4, 1))
        assertEquals(8, solution.maxProductPath(grid))
    }

    @Test
    fun `example 3 - path with zero yields product 0`() {
        val grid = arrayOf(intArrayOf(1, 3), intArrayOf(0, -4))
        assertEquals(0, solution.maxProductPath(grid))
    }

    @Test
    fun `single cell with positive value returns that value`() {
        val grid = arrayOf(intArrayOf(5))
        assertEquals(5, solution.maxProductPath(grid))
    }

    @Test
    fun `single cell with negative value returns -1`() {
        val grid = arrayOf(intArrayOf(-7))
        assertEquals(-1, solution.maxProductPath(grid))
    }

    @Test
    fun `single cell with zero returns 0`() {
        val grid = arrayOf(intArrayOf(0))
        assertEquals(0, solution.maxProductPath(grid))
    }

    @Test
    fun `all ones returns 1`() {
        val grid = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        assertEquals(1, solution.maxProductPath(grid))
    }

    @Test
    fun `result is returned modulo 1_000_000_007`() {
        // 10^9+7 = 1_000_000_007; product of large values must be taken mod
        val grid = arrayOf(intArrayOf(1000000, 1000000), intArrayOf(1000000, 1000000))
        // path: 1000000 -> 1000000 -> 1000000 (right then down) = 10^18 mod 10^9+7
        val expected = (1_000_000L * 1_000_000L * 1_000_000L % 1_000_000_007L).toInt()
        assertEquals(expected, solution.maxProductPath(grid))
    }

    @Test
    fun `single row with all positives returns product along the row`() {
        val grid = arrayOf(intArrayOf(2, 3, 4))
        assertEquals(24, solution.maxProductPath(grid))
    }

    @Test
    fun `single column with all positives returns product along the column`() {
        val grid = arrayOf(intArrayOf(2), intArrayOf(3), intArrayOf(4))
        assertEquals(24, solution.maxProductPath(grid))
    }

    @Test
    fun `two negatives on only path yields positive product`() {
        val grid = arrayOf(intArrayOf(-2), intArrayOf(-3))
        assertEquals(6, solution.maxProductPath(grid))
    }

    @Test
    fun `odd number of negatives on all paths returns -1`() {
        val grid = arrayOf(intArrayOf(-1, -1), intArrayOf(-1, -1))
        // all paths have length 3 (right-right-down or right-down-down) — product of 3 negatives = negative
        assertEquals(-1, solution.maxProductPath(grid))
    }
}
