package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Shift2DGridTest {
    private val solution = Shift2DGrid()

    @Test
    fun `test shift by one`() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        val expected = listOf(listOf(9, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8))
        assertEquals(expected, solution.shiftGrid(grid, 1))
    }

    @Test
    fun `test shift by four on rectangular grid`() {
        val grid = arrayOf(
            intArrayOf(3, 8, 1, 9),
            intArrayOf(19, 7, 2, 5),
            intArrayOf(4, 6, 11, 10),
            intArrayOf(12, 0, 21, 13)
        )
        val expected = listOf(
            listOf(12, 0, 21, 13),
            listOf(3, 8, 1, 9),
            listOf(19, 7, 2, 5),
            listOf(4, 6, 11, 10)
        )
        assertEquals(expected, solution.shiftGrid(grid, 4))
    }

    @Test
    fun `test shift by total elements returns original`() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        val expected = listOf(listOf(1, 2, 3), listOf(4, 5, 6), listOf(7, 8, 9))
        assertEquals(expected, solution.shiftGrid(grid, 9))
    }

    @Test
    fun `test shift by zero returns original`() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6))
        val expected = listOf(listOf(1, 2, 3), listOf(4, 5, 6))
        assertEquals(expected, solution.shiftGrid(grid, 0))
    }

    @Test
    fun `test shift larger than total elements wraps around`() {
        val grid = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
        val expected = listOf(listOf(9, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8))
        assertEquals(expected, solution.shiftGrid(grid, 10))
    }

    @Test
    fun `test single element grid`() {
        val grid = arrayOf(intArrayOf(42))
        val expected = listOf(listOf(42))
        assertEquals(expected, solution.shiftGrid(grid, 5))
    }

    @Test
    fun `test single row grid`() {
        val grid = arrayOf(intArrayOf(1, 2, 3, 4))
        val expected = listOf(listOf(3, 4, 1, 2))
        assertEquals(expected, solution.shiftGrid(grid, 2))
    }

    @Test
    fun `test single column grid`() {
        val grid = arrayOf(intArrayOf(1), intArrayOf(2), intArrayOf(3))
        val expected = listOf(listOf(3), listOf(1), listOf(2))
        assertEquals(expected, solution.shiftGrid(grid, 1))
    }
}
