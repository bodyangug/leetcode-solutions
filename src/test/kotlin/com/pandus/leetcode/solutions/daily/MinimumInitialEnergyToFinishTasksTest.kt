package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumInitialEnergyToFinishTasksTest {
    private val solution = MinimumInitialEnergyToFinishTasks()

    @Test
    fun `example 1`() {
        val tasks = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 4),
            intArrayOf(4, 8)
        )
        assertEquals(8, solution.minimumEffort(tasks))
    }

    @Test
    fun `example 2`() {
        val tasks = arrayOf(
            intArrayOf(1, 3),
            intArrayOf(2, 4),
            intArrayOf(10, 11),
            intArrayOf(10, 12),
            intArrayOf(8, 9)
        )
        assertEquals(32, solution.minimumEffort(tasks))
    }

    @Test
    fun `example 3`() {
        val tasks = arrayOf(
            intArrayOf(1, 7),
            intArrayOf(2, 8),
            intArrayOf(3, 9),
            intArrayOf(4, 10),
            intArrayOf(5, 11),
            intArrayOf(6, 12)
        )
        assertEquals(27, solution.minimumEffort(tasks))
    }
}
