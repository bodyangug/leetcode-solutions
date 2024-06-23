package com.pandus.leetcode.solutions.daily

import java.util.*
import kotlin.math.ceil


//Reference: https://leetcode.com/problems/magnetic-force-between-two-balls
class MagneticForceBetweenTwoBalls {
    // Check if we can place 'm' balls at 'position'
    // with each ball having at least 'x' gap.
    private fun canPlaceBalls(x: Int, position: IntArray, m: Int): Boolean {
        // Place the first ball at the first position.
        var prevBallPos = position[0]
        var ballsPlaced = 1

        // Iterate on each 'position' and place a ball there if we can place it.
        var i = 1
        while (i < position.size && ballsPlaced < m) {
            val currPos = position[i]
            // Check if we can place the ball at the current position.
            if (currPos - prevBallPos >= x) {
                ballsPlaced += 1
                prevBallPos = currPos
            }
            ++i
        }
        // If all 'm' balls are placed, return 'true'.
        return ballsPlaced == m
    }

    fun maxDistance(position: IntArray, m: Int): Int {
        var answer = 0
        val n = position.size
        Arrays.sort(position)

        // Initial search space.
        var low = 1
        var high = ceil(position[n - 1] / (m - 1.0)).toInt()
        while (low <= high) {
            val mid = low + (high - low) / 2
            // If we can place all balls having a gap at least 'mid',
            if (canPlaceBalls(mid, position, m)) {
                // then 'mid' can be our answer,
                answer = mid
                // and discard the left half search space.
                low = mid + 1
            } else {
                // Discard the right half search space.
                high = mid - 1
            }
        }
        return answer
    }
}