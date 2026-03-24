package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ConstructProductMatrixTest {
    private val solution = ConstructProductMatrix()

    @Test
    @DisplayName("Example 1: grid=[[1,2],[3,4]] -> [[24,12],[8,6]]")
    fun testExample1() {
        val grid = arrayOf(intArrayOf(1, 2), intArrayOf(3, 4))
        val expected = arrayOf(intArrayOf(24, 12), intArrayOf(8, 6))
        val result = solution.constructProductMatrix(grid)
        assertArrayEquals(expected[0], result[0])
        assertArrayEquals(expected[1], result[1])
    }

    @Test
    @DisplayName("Example 2: grid=[[12345],[2],[1]] -> [[2],[0],[0]]")
    fun testExample2() {
        val grid = arrayOf(intArrayOf(12345), intArrayOf(2), intArrayOf(1))
        val expected = arrayOf(intArrayOf(2), intArrayOf(0), intArrayOf(0))
        val result = solution.constructProductMatrix(grid)
        assertArrayEquals(expected[0], result[0])
        assertArrayEquals(expected[1], result[1])
        assertArrayEquals(expected[2], result[2])
    }

    @Test
    @DisplayName("Single element grid [[1]] -> [[1]], product of empty set is 1")
    fun testSingleElement() {
        val grid = arrayOf(intArrayOf(1))
        val expected = arrayOf(intArrayOf(1))
        val result = solution.constructProductMatrix(grid)
        assertArrayEquals(expected[0], result[0])
    }

    @Test
    @DisplayName("All ones grid [[1,1],[1,1]] -> [[1,1],[1,1]]")
    fun testAllOnes() {
        val grid = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        val expected = arrayOf(intArrayOf(1, 1), intArrayOf(1, 1))
        val result = solution.constructProductMatrix(grid)
        assertArrayEquals(expected[0], result[0])
        assertArrayEquals(expected[1], result[1])
    }

    @Test
    @DisplayName("Grid with MOD value [[12345,1]] -> [[1,0]]")
    fun testContainsModValue() {
        val grid = arrayOf(intArrayOf(12345, 1))
        val expected = arrayOf(intArrayOf(1, 0))
        val result = solution.constructProductMatrix(grid)
        assertArrayEquals(expected[0], result[0])
    }

    @Test
    @DisplayName("Single row [[2,3,4]] -> [[12,8,6]]")
    fun testSingleRow() {
        val grid = arrayOf(intArrayOf(2, 3, 4))
        val expected = arrayOf(intArrayOf(12, 8, 6))
        val result = solution.constructProductMatrix(grid)
        assertArrayEquals(expected[0], result[0])
    }

    @Test
    @DisplayName("Single column [[2],[3],[4]] -> [[12],[8],[6]]")
    fun testSingleColumn() {
        val grid = arrayOf(intArrayOf(2), intArrayOf(3), intArrayOf(4))
        val expected = arrayOf(intArrayOf(12), intArrayOf(8), intArrayOf(6))
        val result = solution.constructProductMatrix(grid)
        assertArrayEquals(expected[0], result[0])
        assertArrayEquals(expected[1], result[1])
        assertArrayEquals(expected[2], result[2])
    }
}
