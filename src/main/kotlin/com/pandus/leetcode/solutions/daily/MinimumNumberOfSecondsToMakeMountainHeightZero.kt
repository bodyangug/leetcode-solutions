package com.pandus.leetcode.solutions.daily

import kotlin.math.sqrt

// Reference: https://leetcode.com/problems/minimum-number-of-seconds-to-make-mountain-height-zero
class MinimumNumberOfSecondsToMakeMountainHeightZero {
    private companion object {
        const val EPS = 1e-7
    }

    fun minNumberOfSeconds(mountainHeight: Int, workerTimes: IntArray): Long {
        val maxTime = workerTimes.max()
        var lo = 1L
        var hi = maxTime.toLong() * mountainHeight * (mountainHeight + 1) / 2
        var ans = 0L

        while (lo <= hi) {
            val mid = (lo + hi) / 2
            val totalReduction = workerTimes.sumOf { t ->
                val work = mid / t
                ((-1.0 + sqrt(1.0 + work * 8.0)) / 2 + EPS).toLong()
            }

            if (totalReduction >= mountainHeight) {
                ans = mid
                hi = mid - 1
            } else {
                lo = mid + 1
            }
        }
        return ans
    }
}
