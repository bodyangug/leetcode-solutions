package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/furthest-point-from-origin
class FurthestPointFromOrigin {
    fun furthestDistanceFromOrigin(moves: String): Int {
        var left = 0
        var right = 0
        var neutral = 0
        for (move in moves) {
            when (move) {
                'L' -> left++
                'R' -> right++
                '_' -> {
                    neutral++
                }
            }
        }
        return abs(left - right) + neutral
    }
}
