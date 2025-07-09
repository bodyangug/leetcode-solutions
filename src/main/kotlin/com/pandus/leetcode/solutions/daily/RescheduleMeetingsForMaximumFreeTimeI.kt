package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/reschedule-meetings-for-maximum-free-time-i
class RescheduleMeetingsForMaximumFreeTimeI {
    fun maxFreeTime(
        eventTime: Int,
        k: Int,
        startTime: IntArray,
        endTime: IntArray
    ): Int {
        val n = startTime.size
        if (k > n) return 0

        // Precompute total busy time up to each event
        val prefixBusyTime = IntArray(n + 1)
        for (i in 0 until n) {
            prefixBusyTime[i + 1] = prefixBusyTime[i] + (endTime[i] - startTime[i])
        }

        var maxFree = 0
        for (end in k - 1 until n) {
            val start = end - k + 1

            val windowStart = if (start == 0) 0 else endTime[start - 1]
            val windowEnd = if (end == n - 1) eventTime else startTime[end + 1]

            val busyTime = prefixBusyTime[end + 1] - prefixBusyTime[start]
            val freeTime = windowEnd - windowStart - busyTime

            maxFree = max(maxFree, freeTime)
        }
        return maxFree
    }
}
