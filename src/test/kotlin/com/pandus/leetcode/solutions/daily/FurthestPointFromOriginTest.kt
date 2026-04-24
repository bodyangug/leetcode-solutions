package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FurthestPointFromOriginTest {
    private val solution = FurthestPointFromOrigin()

    @Test
    fun `test example 1 - mixed moves`() {
        assertEquals(3, solution.furthestDistanceFromOrigin("L_RL__R"))
    }

    @Test
    fun `test example 2 - more underscores and lefts`() {
        assertEquals(5, solution.furthestDistanceFromOrigin("_R__LL_"))
    }

    @Test
    fun `test example 3 - all underscores`() {
        assertEquals(7, solution.furthestDistanceFromOrigin("_______"))
    }
}
