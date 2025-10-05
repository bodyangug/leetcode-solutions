package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SetMatrixZeroesTest {

    private val solution = SetMatrixZeroes()

    @Test
    fun testExample1() {
        val matrix = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )
        solution.setZeroes(matrix)
        val expected = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1)
        )
        assertArrayEquals(expected, matrix)
    }

    @Test
    fun testExample2() {
        val matrix = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5)
        )
        solution.setZeroes(matrix)
        val expected = arrayOf(
            intArrayOf(0, 0, 0, 0),
            intArrayOf(0, 4, 5, 0),
            intArrayOf(0, 3, 1, 0)
        )
        assertArrayEquals(expected, matrix)
    }

    @Test
    fun testSingleCell() {
        val matrix = arrayOf(intArrayOf(0))
        solution.setZeroes(matrix)
        val expected = arrayOf(intArrayOf(0))
        assertArrayEquals(expected, matrix)
    }

    @Test
    fun testSingleCellNonZero() {
        val matrix = arrayOf(intArrayOf(1))
        solution.setZeroes(matrix)
        val expected = arrayOf(intArrayOf(1))
        assertArrayEquals(expected, matrix)
    }

    @Test
    fun testNoZeros() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )
        val original = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6)
        )
        solution.setZeroes(matrix)
        assertArrayEquals(original, matrix)
    }

    @Test
    fun testFirstRowZero() {
        val matrix = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5)
        )
        solution.setZeroes(matrix)
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 4, 5)
        )
        assertArrayEquals(expected, matrix)
    }

    @Test
    fun testFirstColumnZero() {
        val matrix = arrayOf(
            intArrayOf(0, 1, 2),
            intArrayOf(3, 4, 5),
            intArrayOf(6, 7, 8)
        )
        solution.setZeroes(matrix)
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 4, 5),
            intArrayOf(0, 7, 8)
        )
        assertArrayEquals(expected, matrix)
    }

    @Test
    fun testMultipleZeros() {
        val matrix = arrayOf(
            intArrayOf(1, 0, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 0)
        )
        solution.setZeroes(matrix)
        val expected = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(4, 0, 0),
            intArrayOf(0, 0, 0)
        )
        assertArrayEquals(expected, matrix)
    }

    @Test
    fun testSingleRow() {
        val matrix = arrayOf(intArrayOf(1, 0, 3, 4))
        solution.setZeroes(matrix)
        val expected = arrayOf(intArrayOf(0, 0, 0, 0))
        assertArrayEquals(expected, matrix)
    }

    @Test
    fun testSingleColumn() {
        val matrix = arrayOf(
            intArrayOf(1),
            intArrayOf(0),
            intArrayOf(3)
        )
        solution.setZeroes(matrix)
        val expected = arrayOf(
            intArrayOf(0),
            intArrayOf(0),
            intArrayOf(0)
        )
        assertArrayEquals(expected, matrix)
    }

    @Test
    fun testLargerMatrix() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 0, 7, 8),
            intArrayOf(9, 10, 11, 12),
            intArrayOf(13, 14, 0, 16)
        )
        solution.setZeroes(matrix)
        val expected = arrayOf(
            intArrayOf(1, 0, 0, 4),
            intArrayOf(0, 0, 0, 0),
            intArrayOf(9, 0, 0, 12),
            intArrayOf(0, 0, 0, 0)
        )
        assertArrayEquals(expected, matrix)
    }
}
