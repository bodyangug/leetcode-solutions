package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumJumpsToReachEndViaPrimeTeleportationTest {

    private val solution = MinimumJumpsToReachEndViaPrimeTeleportation()

    @Test
    fun `test example 1 - adjacent step then prime teleportation`() {
        assertEquals(2, solution.minJumps(intArrayOf(1, 2, 4, 6)))
    }

    @Test
    fun `test example 2 - adjacent step then prime teleportation via 3`() {
        assertEquals(2, solution.minJumps(intArrayOf(2, 3, 4, 7, 9)))
    }

    @Test
    fun `test example 3 - no teleportation possible`() {
        assertEquals(3, solution.minJumps(intArrayOf(4, 6, 5, 8)))
    }
}
