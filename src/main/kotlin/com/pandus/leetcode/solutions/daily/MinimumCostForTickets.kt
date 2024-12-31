package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/minimum-cost-for-tickets
class MinimumCostForTickets {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val lastDay = days[days.size - 1]
        val dp = IntArray(lastDay + 1) { 0 }
        var i = 0
        for (day in 1..lastDay) {
            if (day < days[i]) {
                dp[day] = dp[day - 1]
            } else {
                i++
                dp[day] = min(
                    (dp[day - 1] + costs[0]),
                    min(
                        (dp[max(0, (day - 7))] + costs[1]),
                        (dp[max(0, (day - 30))] + costs[2])
                    )
                )
            }
        }
        return dp[lastDay]
    }
}
