package com.pandus.leetcode.solutions.daily

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/minimum-total-distance-traveled
class MinimumTotalDistanceTraveled {
    fun minimumTotalDistance(robot: List<Int>, factory: Array<IntArray>): Long {
        factory.sortBy { it[0] }
        val rs = robot.sorted()
        val dp = Array(factory.size + 1) { LongArray(rs.size + 1) { Long.MAX_VALUE / 2 } }
        for ((f, fac) in factory.withIndex()) for (r in rs.indices) {
            var dist = 0L
            dp[f + 1][r] = dp[f][r]
            for (ri in r downTo max(0, r - fac[1] + 1)) {
                dist += abs(rs[ri] - fac[0])
                dp[f + 1][r] = min(dp[f + 1][r], dist + if (ri < 1) 0L else dp[f][ri - 1])
            }
        }
        return dp[factory.size][rs.size - 1]
    }
}
