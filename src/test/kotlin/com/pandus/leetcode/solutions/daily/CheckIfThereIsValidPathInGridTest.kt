package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CheckIfThereIsValidPathInGridTest {
    private val solution = CheckIfThereIsValidPathInGrid()

    @Test
    fun validPath() {
        val grid = arrayOf(
            intArrayOf(2, 4, 3),
            intArrayOf(6, 5, 2),
        )
        assertEquals(true, solution.hasValidPath(grid))
    }

    @Test
    fun disconnectedStart() {
        val grid = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(1, 2, 1),
        )
        assertEquals(false, solution.hasValidPath(grid))
    }

    @Test
    fun stuckInMiddle() {
        val grid = arrayOf(
            intArrayOf(1, 1, 2),
        )
        assertEquals(false, solution.hasValidPath(grid))
    }
}
