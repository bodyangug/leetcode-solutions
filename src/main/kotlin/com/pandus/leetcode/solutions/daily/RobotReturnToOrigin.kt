package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/robot-return-to-origin
class RobotReturnToOrigin {
    fun judgeCircle(moves: String): Boolean {
        var x = 0
        var y = 0
        for (move in moves) {
            when (move) {
                'U' -> y++
                'D' -> y--
                'L' -> x--
                'R' -> x++
            }
        }
        return x == 0 && y == 0
    }
}
