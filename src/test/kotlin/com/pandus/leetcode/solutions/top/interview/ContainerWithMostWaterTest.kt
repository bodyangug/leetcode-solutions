package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContainerWithMostWaterTest {
    @Test
    fun maxArea_returnsCorrectArea_positiveCase() {
        val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        val solution = ContainerWithMostWater()
        assertEquals(49, solution.maxArea(height))
    }

    @Test
    fun maxArea_returnsZeroForEmptyArray_negativeCase() {
        val height = intArrayOf()
        val solution = ContainerWithMostWater()
        assertEquals(0, solution.maxArea(height))
    }
}
