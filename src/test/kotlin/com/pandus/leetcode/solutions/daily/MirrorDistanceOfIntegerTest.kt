package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MirrorDistanceOfIntegerTest {
    private val solution = MirrorDistanceOfInteger()

    @Test
    fun `example 1 - n is 25`() {
        assertEquals(27, solution.mirrorDistance(25))
    }

    @Test
    fun `example 2 - n is 10`() {
        assertEquals(9, solution.mirrorDistance(10))
    }

    @Test
    fun `example 3 - n is 7`() {
        assertEquals(0, solution.mirrorDistance(7))
    }
}
