package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/walking-robot-simulation-ii
class WalkingRobotSimulationII(private val width: Int, private val height: Int) {
    private val perimeter = 2 * (width - 1) + 2 * (height - 1)
    private var idx = 0
    private var hasMoved = false

    fun step(num: Int) {
        hasMoved = true
        idx = (idx + num) % perimeter
    }

    fun getPos(): IntArray = when {
        idx <= width - 1 -> intArrayOf(idx, 0)
        idx <= width + height - 2 -> intArrayOf(width - 1, idx - (width - 1))
        idx <= 2 * (width - 1) + height - 1 -> intArrayOf(2 * (width - 1) + height - 1 - idx, height - 1)
        else -> intArrayOf(0, perimeter - idx)
    }

    fun getDir(): String = when {
        idx == 0 && hasMoved -> "South"
        idx <= width - 1 -> "East"
        idx <= width + height - 2 -> "North"
        idx <= 2 * (width - 1) + height - 1 -> "West"
        else -> "South"
    }
}
