package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SpecialPositionsInBinaryMatrixTest {
    private val solution = SpecialPositionsInBinaryMatrix()

    @Test
    @DisplayName("Example 1: mat = [[1,0,0],[0,0,1],[1,0,0]], output = 1")
    fun testExample1() {
        val mat = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 0, 0)
        )
        val result = solution.numSpecial(mat)
        assertEquals(1, result, "(1, 2) is a special position because mat[1][2] == 1 and all other elements in row 1 and column 2 are 0")
    }

    @Test
    @DisplayName("Example 2: mat = [[1,0,0],[0,1,0],[0,0,1]], output = 3")
    fun testExample2() {
        val mat = arrayOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1)
        )
        val result = solution.numSpecial(mat)
        assertEquals(3, result, "(0, 0), (1, 1) and (2, 2) are special positions")
    }

    @Test
    @DisplayName("Single element matrix with 1: mat = [[1]], output = 1")
    fun testSingleElementOne() {
        val mat = arrayOf(intArrayOf(1))
        val result = solution.numSpecial(mat)
        assertEquals(1, result, "Single element 1 is special")
    }

    @Test
    @DisplayName("Single element matrix with 0: mat = [[0]], output = 0")
    fun testSingleElementZero() {
        val mat = arrayOf(intArrayOf(0))
        val result = solution.numSpecial(mat)
        assertEquals(0, result, "Single element 0 has no special positions")
    }

    @Test
    @DisplayName("All zeros matrix: mat = [[0,0],[0,0]], output = 0")
    fun testAllZeros() {
        val mat = arrayOf(
            intArrayOf(0, 0),
            intArrayOf(0, 0)
        )
        val result = solution.numSpecial(mat)
        assertEquals(0, result, "No 1s means no special positions")
    }

    @Test
    @DisplayName("All ones matrix: mat = [[1,1],[1,1]], output = 0")
    fun testAllOnes() {
        val mat = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 1)
        )
        val result = solution.numSpecial(mat)
        assertEquals(0, result, "Every 1 has other 1s in its row and column")
    }

    @Test
    @DisplayName("Single row matrix: mat = [[0,1,0]], output = 1")
    fun testSingleRow() {
        val mat = arrayOf(intArrayOf(0, 1, 0))
        val result = solution.numSpecial(mat)
        assertEquals(1, result, "Single 1 in a single row matrix is special")
    }

    @Test
    @DisplayName("Single column matrix: mat = [[0],[1],[0]], output = 1")
    fun testSingleColumn() {
        val mat = arrayOf(
            intArrayOf(0),
            intArrayOf(1),
            intArrayOf(0)
        )
        val result = solution.numSpecial(mat)
        assertEquals(1, result, "Single 1 in a single column matrix is special")
    }

    @Test
    @DisplayName("Multiple 1s in same row: mat = [[1,1,0],[0,0,1],[0,0,0]], output = 1")
    fun testMultipleOnesInSameRow() {
        val mat = arrayOf(
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(0, 0, 0)
        )
        val result = solution.numSpecial(mat)
        assertEquals(1, result, "Only (1, 2) is special; (0,0) and (0,1) share the same row")
    }

    @Test
    @DisplayName("Multiple 1s in same column: mat = [[1,0],[1,0],[0,1]], output = 1")
    fun testMultipleOnesInSameColumn() {
        val mat = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(1, 0),
            intArrayOf(0, 1)
        )
        val result = solution.numSpecial(mat)
        assertEquals(1, result, "Only (2, 1) is special; (0,0) and (1,0) share the same column")
    }

    @Test
    @DisplayName("Large sparse matrix with one special position")
    fun testLargeSparseMatrix() {
        val mat = arrayOf(
            intArrayOf(0, 0, 0, 0, 1),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0),
            intArrayOf(0, 0, 0, 0, 0)
        )
        val result = solution.numSpecial(mat)
        assertEquals(1, result, "Single 1 in sparse matrix is special")
    }
}

