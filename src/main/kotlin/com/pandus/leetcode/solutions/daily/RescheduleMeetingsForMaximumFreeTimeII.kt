package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-ii
class RescheduleMeetingsForMaximumFreeTimeII {
    fun maxFreeTime(eventTime: Int, startTime: IntArray, endTime: IntArray): Int {
        val n = startTime.size
        val q = BooleanArray(n)
        var gapLeft = 0
        var gapRight = 0

        for (i in 0..<n) {
            // Forward pass
            if (endTime[i] - startTime[i] <= gapLeft) {
                q[i] = true
            }
            if (i > 0) {
                gapLeft = max(gapLeft, startTime[i] - endTime[i - 1])
            } else {
                gapLeft = startTime[0]
            }

            // Backward pass
            val j = n - 1 - i
            if (endTime[j] - startTime[j] <= gapRight) {
                q[j] = true
            }
            val rightStart = if (j == n - 1) eventTime else startTime[j + 1]
            gapRight = max(gapRight, rightStart - endTime[j])
        }
        var res = 0
        for (i in 0..<n) {
            val left = if (i == 0) 0 else endTime[i - 1]
            val right = if (i == n - 1) eventTime else startTime[i + 1]
            val occupied = if (q[i]) 0 else endTime[i] - startTime[i]
            res = max(res, right - left - occupied)
        }
        return res
    }
}
