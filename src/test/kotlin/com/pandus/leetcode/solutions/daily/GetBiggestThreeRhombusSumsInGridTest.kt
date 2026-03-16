package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class GetBiggestThreeRhombusSumsInGridTest {
    private val solution = GetBiggestThreeRhombusSumsInGrid()

    @Test
    fun getBiggestThree_example1_returns228_216_211() {
        val grid = arrayOf(
            intArrayOf(3, 4, 5, 1, 3),
            intArrayOf(3, 3, 4, 2, 3),
            intArrayOf(20, 30, 200, 40, 10),
            intArrayOf(1, 5, 5, 4, 1),
            intArrayOf(4, 3, 2, 2, 5)
        )
        assertArrayEquals(intArrayOf(228, 216, 211), solution.getBiggestThree(grid))
    }

    @Test
    fun getBiggestThree_example2_returns20_9_8() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )
        assertArrayEquals(intArrayOf(20, 9, 8), solution.getBiggestThree(grid))
    }

    @Test
    fun getBiggestThree_example3_allSameValues_returns7() {
        val grid = arrayOf(
            intArrayOf(7, 7, 7)
        )
        assertArrayEquals(intArrayOf(7), solution.getBiggestThree(grid))
    }

    @Test
    fun getBiggestThree_singleCell_returnsSingleValue() {
        val grid = arrayOf(
            intArrayOf(42)
        )
        assertArrayEquals(intArrayOf(42), solution.getBiggestThree(grid))
    }

    @Test
    fun getBiggestThree_singleColumn_returnsTopThree() {
        val grid = arrayOf(
            intArrayOf(10),
            intArrayOf(20),
            intArrayOf(30)
        )
        assertArrayEquals(intArrayOf(30, 20, 10), solution.getBiggestThree(grid))
    }
}
