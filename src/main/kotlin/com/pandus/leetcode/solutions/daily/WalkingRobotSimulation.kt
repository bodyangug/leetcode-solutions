package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/walking-robot-simulation
class WalkingRobotSimulation {

    private val directions = arrayOf(
        intArrayOf(0, 1), // North
        intArrayOf(1, 0), // East
        intArrayOf(0, -1), // South
        intArrayOf(-1, 0) // West
    )

    fun robotSim(commands: IntArray, obstacles: Array<IntArray>): Int {
        var (x, y) = 0 to 0
        var currentDirection = 0
        var maxDistanceSquared = 0

        val obstacleSet = obstacles.map { it[0] to it[1] }.toSet()

        for (command in commands) {
            when (command) {
                -1 -> currentDirection = (currentDirection + 1) % 4  // turn right
                -2 -> currentDirection = (currentDirection + 3) % 4 // turn left
                else -> { // move forward
                    val direction = directions[currentDirection]
                    for (step in 0..<command) {
                        val nextX = x + direction[0]
                        val nextY = y + direction[1]

                        if (nextX to nextY in obstacleSet) break
                        x = nextX
                        y = nextY
                    }
                    maxDistanceSquared = max(maxDistanceSquared, x * x + y * y)
                }
            }
        }
        return maxDistanceSquared
    }
}
