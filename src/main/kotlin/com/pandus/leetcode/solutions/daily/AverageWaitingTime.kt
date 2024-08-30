package com.pandus.leetcode.solutions.daily

import java.lang.Integer.max

// Reference: https://leetcode.com/problems/average-waiting-time
class AverageWaitingTime {
    fun averageWaitingTime(customers: Array<IntArray>): Double {
        var nextIdleTime = 0
        var netWaitTime: Long = 0

        for (i in customers.indices) {
            nextIdleTime = max(customers[i][0], nextIdleTime) + customers[i][1]
            netWaitTime += (nextIdleTime - customers[i][0])
        }
        val averageWaitTime = netWaitTime.toDouble() / customers.size
        return averageWaitTime
    }
}
