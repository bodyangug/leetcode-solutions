package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/minimum-time-visiting-all-points
class MinimumTimeVisitingAllPoints {
    fun minTimeToVisitAllPoints(points: Array<IntArray>): Int {
        var totalTime = 0
        for (i in 1 until points.size) {
            val xDiff = abs(points[i][0] - points[i - 1][0])
            val yDiff = abs(points[i][1] - points[i - 1][1])
            totalTime += xDiff.coerceAtLeast(yDiff)
        }
        return totalTime
    }
}
