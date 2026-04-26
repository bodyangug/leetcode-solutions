package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DetectCyclesIn2DGridTest {
    private val solution = DetectCyclesIn2DGrid()

    @Test
    fun containsCycleRing() {
        val grid = arrayOf(
            charArrayOf('a', 'a', 'a', 'a'),
            charArrayOf('a', 'b', 'b', 'a'),
            charArrayOf('a', 'b', 'b', 'a'),
            charArrayOf('a', 'a', 'a', 'a'),
        )
        assertEquals(true, solution.containsCycle(grid))
    }

    @Test
    fun containsCycleSpiral() {
        val grid = arrayOf(
            charArrayOf('c', 'c', 'c', 'a'),
            charArrayOf('c', 'd', 'c', 'c'),
            charArrayOf('c', 'c', 'e', 'c'),
            charArrayOf('f', 'c', 'c', 'c'),
        )
        assertEquals(true, solution.containsCycle(grid))
    }

    @Test
    fun noCycle() {
        val grid = arrayOf(
            charArrayOf('a', 'b', 'b'),
            charArrayOf('b', 'z', 'b'),
            charArrayOf('b', 'b', 'a'),
        )
        assertEquals(false, solution.containsCycle(grid))
    }
}
