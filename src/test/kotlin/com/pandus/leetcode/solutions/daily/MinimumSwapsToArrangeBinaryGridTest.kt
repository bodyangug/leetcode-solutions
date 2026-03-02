package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MinimumSwapsToArrangeBinaryGridTest {
    private val solution = MinimumSwapsToArrangeBinaryGrid()

    @Test
    @DisplayName("Example 1: grid = [[0,0,1],[1,1,0],[1,0,0]], output = 3")
    fun testExample1() {
        val grid = arrayOf(
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 0, 0)
        )
        val result = solution.minSwaps(grid)
        assertEquals(3, result)
    }

    @Test
    @DisplayName("Example 2: grid = [[0,1,1,0],[0,1,1,0],[0,1,1,0],[0,1,1,0]], output = -1")
    fun testExample2() {
        val grid = arrayOf(
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 1, 1, 0),
            intArrayOf(0, 1, 1, 0)
        )
        val result = solution.minSwaps(grid)
        assertEquals(-1, result, "All rows are similar, swaps have no effect on the grid")
    }

    @Test
    @DisplayName("Example 3: grid = [[1,0,0],[1,1,0],[1,1,1]], output = 0")
    fun testExample3() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 1)
        )
        val result = solution.minSwaps(grid)
        assertEquals(0, result, "Grid is already valid")
    }

    @Test
    @DisplayName("Single element grid: grid = [[0]], output = 0")
    fun testSingleElement() {
        val grid = arrayOf(
            intArrayOf(0)
        )
        val result = solution.minSwaps(grid)
        assertEquals(0, result, "Single element grid is always valid")
    }

    @Test
    @DisplayName("Single element grid with 1: grid = [[1]], output = 0")
    fun testSingleElementWithOne() {
        val grid = arrayOf(
            intArrayOf(1)
        )
        val result = solution.minSwaps(grid)
        assertEquals(0, result, "Single element grid is always valid")
    }

    @Test
    @DisplayName("2x2 grid already valid: grid = [[0,0],[1,0]], output = 0")
    fun test2x2AlreadyValid() {
        val grid = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(1, 0)
        )
        val result = solution.minSwaps(grid)
        assertEquals(0, result)
    }

    @Test
    @DisplayName("2x2 grid impossible: grid = [[1,1],[1,1]], output = -1")
    fun test2x2Impossible() {
        val grid = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        val result = solution.minSwaps(grid)
        assertEquals(-1, result)
    }

    @Test
    @DisplayName("All zeros grid: grid = [[0,0,0],[0,0,0],[0,0,0]], output = 0")
    fun testAllZeros() {
        val grid = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0)
        )
        val result = solution.minSwaps(grid)
        assertEquals(0, result, "All zeros grid is always valid")
    }

    @Test
    @DisplayName("Diagonal ones grid: grid = [[1,0,0,0],[1,1,0,0],[1,1,1,0],[1,1,1,1]], output = 0")
    fun testDiagonalOnes() {
        val grid = arrayOf(
            intArrayOf(1, 0, 0, 0),
            intArrayOf(1, 1, 0, 0),
            intArrayOf(1, 1, 1, 0),
            intArrayOf(1, 1, 1, 1)
        )
        val result = solution.minSwaps(grid)
        assertEquals(0, result, "Already valid diagonal pattern")
    }

    @Test
    @DisplayName("Reverse diagonal: grid = [[1,1,1,1],[1,1,1,0],[1,1,0,0],[1,0,0,0]], output = 6")
    fun testReverseDiagonal() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 0),
            intArrayOf(1, 1, 0, 0),
            intArrayOf(1, 0, 0, 0)
        )
        val result = solution.minSwaps(grid)
        assertEquals(6, result, "Needs multiple swaps to reverse the order")
    }
}
