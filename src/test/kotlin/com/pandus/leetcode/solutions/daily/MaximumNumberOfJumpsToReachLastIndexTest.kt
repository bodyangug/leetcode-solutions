package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfJumpsToReachLastIndexTest {
    private val solution = MaximumNumberOfJumpsToReachLastIndex()

    @Test
    fun `target 2 returns 3`() {
        assertEquals(3, solution.maximumJumps(intArrayOf(1, 3, 6, 4, 1, 2), 2))
    }

    @Test
    fun `target 3 returns 5`() {
        assertEquals(5, solution.maximumJumps(intArrayOf(1, 3, 6, 4, 1, 2), 3))
    }

    @Test
    fun `target 0 returns -1`() {
        assertEquals(-1, solution.maximumJumps(intArrayOf(1, 3, 6, 4, 1, 2), 0))
    }
}
