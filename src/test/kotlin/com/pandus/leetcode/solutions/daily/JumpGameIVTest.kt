package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JumpGameIVTest {
    private val solution = JumpGameIV()

    @Test
    fun `example 1 - mixed values array`() {
        assertEquals(3, solution.minJumps(intArrayOf(100, -23, -23, 404, 100, 23, 23, 23, 3, 404)))
    }

    @Test
    fun `example 2 - single element`() {
        assertEquals(0, solution.minJumps(intArrayOf(7)))
    }

    @Test
    fun `example 3 - jump directly to last index`() {
        assertEquals(1, solution.minJumps(intArrayOf(7, 6, 9, 6, 9, 6, 9, 7)))
    }
}
