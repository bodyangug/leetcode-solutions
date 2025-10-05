package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

class PacificAtlanticWaterFlowTest {

    private val solution = PacificAtlanticWaterFlow()

    @Test
    fun testExample1() {
        val heights = arrayOf(
            intArrayOf(1, 2, 2, 3, 5),
            intArrayOf(3, 2, 3, 4, 4),
            intArrayOf(2, 4, 5, 3, 1),
            intArrayOf(6, 7, 1, 4, 5),
            intArrayOf(5, 1, 1, 2, 4)
        )

        val expected = listOf(
            listOf(0, 4), listOf(1, 3), listOf(1, 4),
            listOf(2, 2), listOf(3, 0), listOf(3, 1), listOf(4, 0)
        )

        val result = solution.pacificAtlantic(heights)
        assertEquals(expected.size, result.size)
        assertTrue(result.containsAll(expected))
    }

    @Test
    fun testExample2() {
        val heights = arrayOf(
            intArrayOf(1)
        )

        val expected = listOf(listOf(0, 0))
        val result = solution.pacificAtlantic(heights)
        assertEquals(expected, result)
    }

    @Test
    fun testEmptyGrid() {
        val heights = arrayOf<IntArray>()
        val result = solution.pacificAtlantic(heights)
        assertTrue(result.isEmpty())
    }
}
