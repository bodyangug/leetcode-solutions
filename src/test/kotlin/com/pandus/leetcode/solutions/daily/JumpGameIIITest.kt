package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JumpGameIIITest {
    private val solution = JumpGameIII()

    @Test
    fun `example 1 - start 5 can reach zero`() {
        assertEquals(true, solution.canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 5))
    }

    @Test
    fun `example 2 - start 0 can reach zero`() {
        assertEquals(true, solution.canReach(intArrayOf(4, 2, 3, 0, 3, 1, 2), 0))
    }

    @Test
    fun `example 3 - start 2 cannot reach zero`() {
        assertEquals(false, solution.canReach(intArrayOf(3, 0, 2, 1, 2), 2))
    }
}
