package com.pandus.leetcode.solutions.top.interview

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContainerWithMostWaterTest {

    private val solution = ContainerWithMostWater()

    @Test
    fun testExample1() {
        val height = intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)
        assertEquals(49, solution.maxArea(height))
        assertEquals(49, solution.maxArea1(height))
    }

    @Test
    fun testExample2() {
        val height = intArrayOf(1, 1)
        assertEquals(1, solution.maxArea(height))
        assertEquals(1, solution.maxArea1(height))
    }

    @Test
    fun testIncreasingHeight() {
        val height = intArrayOf(1, 2, 3, 4, 5)
        assertEquals(6, solution.maxArea(height)) // height[0]=1, height[4]=5, width=4, area=1*4=4
        assertEquals(6, solution.maxArea1(height))
    }

    @Test
    fun testDecreasingHeight() {
        val height = intArrayOf(5, 4, 3, 2, 1)
        assertEquals(6, solution.maxArea(height))
        assertEquals(6, solution.maxArea1(height))
    }

    @Test
    fun testSameHeights() {
        val height = intArrayOf(3, 3, 3, 3)
        assertEquals(9, solution.maxArea(height)) // width=3, height=3, area=9
        assertEquals(9, solution.maxArea1(height))
    }

    @Test
    fun testTallWalls() {
        val height = intArrayOf(2, 1, 2)
        assertEquals(4, solution.maxArea(height)) // Use first and last walls
        assertEquals(4, solution.maxArea1(height))
    }
}
