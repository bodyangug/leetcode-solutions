package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MaximumWallsDestroyedByRobotsTest {
    private val solver = MaximumWallsDestroyedByRobots()

    @Test
    @DisplayName("Example 1: robots=[1,5,3], distance=[2,1,2], walls=[2,4]")
    fun maxWalls_example1() {
        assertEquals(
            2,
            solver.maxWalls(intArrayOf(1, 5, 3), intArrayOf(2, 1, 2), intArrayOf(2, 4))
        )
    }

    @Test
    @DisplayName("Example 2: robots=[1,3], distance=[1,1], walls=[2]")
    fun maxWalls_example2() {
        assertEquals(
            1,
            solver.maxWalls(intArrayOf(1, 3), intArrayOf(1, 1), intArrayOf(2))
        )
    }

    @Test
    @DisplayName("Example 3: robots=[1], distance=[5], walls=[3,4,5]")
    fun maxWalls_example3() {
        assertEquals(
            3,
            solver.maxWalls(intArrayOf(1), intArrayOf(5), intArrayOf(3, 4, 5))
        )
    }

    @Test
    @DisplayName("Edge case: no robots")
    fun maxWalls_noRobots() {
        assertEquals(0, solver.maxWalls(intArrayOf(), intArrayOf(), intArrayOf(1, 2, 3)))
    }

    @Test
    @DisplayName("Edge case: no walls")
    fun maxWalls_noWalls() {
        assertEquals(0, solver.maxWalls(intArrayOf(1, 2), intArrayOf(5, 5), intArrayOf()))
    }

    @Test
    @DisplayName("Single robot, single wall within range")
    fun maxWalls_singleRobotSingleWall() {
        assertEquals(1, solver.maxWalls(intArrayOf(5), intArrayOf(3), intArrayOf(7)))
    }

    @Test
    @DisplayName("Single robot, wall out of range")
    fun maxWalls_singleRobotWallOutOfRange() {
        assertEquals(0, solver.maxWalls(intArrayOf(5), intArrayOf(1), intArrayOf(7)))
    }

    @Test
    @DisplayName("Wall at robot position")
    fun maxWalls_wallAtRobotPosition() {
        assertEquals(1, solver.maxWalls(intArrayOf(5), intArrayOf(0), intArrayOf(5)))
    }
}
