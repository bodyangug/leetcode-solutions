package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TwoFurthestHousesWithDifferentColorsTest {
    private val solution = TwoFurthestHousesWithDifferentColors()

    @Test
    fun `test example 1 - single different color in middle`() {
        val colors = intArrayOf(1, 1, 1, 6, 1, 1, 1)
        assertEquals(3, solution.maxDistance(colors))
    }

    @Test
    fun `test example 2 - different colors at both ends`() {
        val colors = intArrayOf(1, 8, 3, 8, 3)
        assertEquals(4, solution.maxDistance(colors))
    }

    @Test
    fun `test example 3 - two houses with different colors`() {
        val colors = intArrayOf(0, 1)
        assertEquals(1, solution.maxDistance(colors))
    }

    @Test
    fun `test first and last house have different colors`() {
        val colors = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(4, solution.maxDistance(colors))
    }

    @Test
    fun `test all same color except last`() {
        val colors = intArrayOf(3, 3, 3, 3, 7)
        assertEquals(4, solution.maxDistance(colors))
    }

    @Test
    fun `test all same color except first`() {
        val colors = intArrayOf(7, 3, 3, 3, 3)
        assertEquals(4, solution.maxDistance(colors))
    }

    @Test
    fun `test two houses with different colors - minimal input`() {
        val colors = intArrayOf(0, 1)
        assertEquals(1, solution.maxDistance(colors))
    }

    @Test
    fun `test alternating colors - max distance is n-1`() {
        val colors = intArrayOf(1, 2, 1, 2, 1, 2)
        assertEquals(5, solution.maxDistance(colors))
    }

    @Test
    fun `test single unique color at index 1`() {
        val colors = intArrayOf(1, 2, 1, 1, 1)
        assertEquals(3, solution.maxDistance(colors))
    }

    @Test
    fun `test large array with different colors at both ends`() {
        val colors = IntArray(100) { if (it == 0) 1 else 2 }
        assertEquals(99, solution.maxDistance(colors))
    }
}
