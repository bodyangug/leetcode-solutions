package com.pandus.leetcode.solutions.daily

import java.util.*


//Reference: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons
class MinimumNumberArrowsToBurstBalloons {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        if (points.isEmpty()) return 0
        points.sortBy { it[1] }

        var arrows = 1
        var firstEnd = points[0][1]
        for (p in points) {
            val xStart = p[0]

            if (firstEnd < xStart) {
                arrows++
                firstEnd = p[1]
            }
        }
        return arrows
    }
}