package com.pandus.leetcode.solutions.daily

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WalkingRobotSimulationIITest {
    @Test
    @DisplayName("Example 1: step and query sequence on 6x3 grid")
    fun example1() {
        val robot = WalkingRobotSimulationII(6, 3)
        robot.step(2)
        robot.step(2)
        assertArrayEquals(intArrayOf(4, 0), robot.getPos())
        assertEquals("East", robot.getDir())
        robot.step(2)
        robot.step(1)
        robot.step(4)
        assertArrayEquals(intArrayOf(1, 2), robot.getPos())
        assertEquals("West", robot.getDir())
    }

    @Test
    @DisplayName("Initial state: position (0,0) facing East")
    fun initialState() {
        val robot = WalkingRobotSimulationII(4, 4)
        assertArrayEquals(intArrayOf(0, 0), robot.getPos())
        assertEquals("East", robot.getDir())
    }

    @Test
    @DisplayName("Full perimeter loop returns to origin facing South")
    fun fullLoop() {
        val robot = WalkingRobotSimulationII(3, 3)
        // perimeter = 2*2 + 2*2 = 8
        robot.step(8)
        assertArrayEquals(intArrayOf(0, 0), robot.getPos())
        assertEquals("South", robot.getDir())
    }

    @Test
    @DisplayName("Multiple full loops still returns South at origin")
    fun multipleFullLoops() {
        val robot = WalkingRobotSimulationII(3, 3)
        robot.step(24) // 3 full loops
        assertArrayEquals(intArrayOf(0, 0), robot.getPos())
        assertEquals("South", robot.getDir())
    }

    @Test
    @DisplayName("Robot reaches each corner with correct direction")
    fun corners() {
        val robot = WalkingRobotSimulationII(4, 3)
        // perimeter = 2*3 + 2*2 = 10
        // bottom-right corner (3,0) at idx=3 → East
        robot.step(3)
        assertArrayEquals(intArrayOf(3, 0), robot.getPos())
        assertEquals("East", robot.getDir())

        // top-right corner (3,2) at idx=5 → North
        robot.step(2)
        assertArrayEquals(intArrayOf(3, 2), robot.getPos())
        assertEquals("North", robot.getDir())

        // top-left corner (0,2) at idx=8 → West
        robot.step(3)
        assertArrayEquals(intArrayOf(0, 2), robot.getPos())
        assertEquals("West", robot.getDir())

        // back to origin (0,0) at idx=10 → South
        robot.step(2)
        assertArrayEquals(intArrayOf(0, 0), robot.getPos())
        assertEquals("South", robot.getDir())
    }

    @Test
    @DisplayName("Large step count handled via modulo")
    fun largeSteps() {
        val robot = WalkingRobotSimulationII(6, 3)
        // perimeter = 14
        robot.step(1_000_000_000)
        // 1_000_000_000 % 14 = 1_000_000_000 - 71_428_571*14 = 1_000_000_000 - 999_999_994 = 6
        assertArrayEquals(intArrayOf(5, 1), robot.getPos())
        assertEquals("North", robot.getDir())
    }

    @Test
    @DisplayName("Minimum grid 2x2")
    fun minimumGrid() {
        val robot = WalkingRobotSimulationII(2, 2)
        // perimeter = 2+2 = 4
        robot.step(1) // idx=1 → (1,0) East
        assertArrayEquals(intArrayOf(1, 0), robot.getPos())
        assertEquals("East", robot.getDir())

        robot.step(1) // idx=2 → (1,1) North
        assertArrayEquals(intArrayOf(1, 1), robot.getPos())
        assertEquals("North", robot.getDir())

        robot.step(1) // idx=3 → (0,1) West
        assertArrayEquals(intArrayOf(0, 1), robot.getPos())
        assertEquals("West", robot.getDir())

        robot.step(1) // idx=0 → (0,0) South
        assertArrayEquals(intArrayOf(0, 0), robot.getPos())
        assertEquals("South", robot.getDir())
    }

    @Test
    @DisplayName("Step zero does not change position or direction")
    fun stepZero() {
        val robot = WalkingRobotSimulationII(5, 4)
        robot.step(3)
        val posBefore = robot.getPos().clone()
        val dirBefore = robot.getDir()
        robot.step(0)
        assertArrayEquals(posBefore, robot.getPos())
        assertEquals(dirBefore, robot.getDir())
    }

    @Test
    @DisplayName("Incremental single steps match bulk step")
    fun incrementalVsBulk() {
        val robot1 = WalkingRobotSimulationII(5, 5)
        val robot2 = WalkingRobotSimulationII(5, 5)
        repeat(7) { robot1.step(1) }
        robot2.step(7)
        assertArrayEquals(robot2.getPos(), robot1.getPos())
        assertEquals(robot2.getDir(), robot1.getDir())
    }
}
