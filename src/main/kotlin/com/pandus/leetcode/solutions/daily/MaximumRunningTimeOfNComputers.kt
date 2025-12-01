package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/maximum-running-time-of-n-computers
class MaximumRunningTimeOfNComputers {
    fun maxRunTime(n: Int, batteries: IntArray): Long {
        var sumPower: Long = 0
        for (power in batteries) sumPower += power.toLong()
        var left: Long = 1
        var right = sumPower / n

        while (left < right) {
            val target = right - (right - left) / 2
            var extra: Long = 0

            for (power in batteries) extra += min(power.toLong(), target)

            if (extra >= (n * target)) left = target
            else right = target - 1
        }
        return left
    }
}
