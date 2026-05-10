package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/maximum-number-of-jumps-to-reach-the-last-index
class MaximumNumberOfJumpsToReachLastIndex {
    fun maximumJumps(nums: IntArray, target: Int): Int {
        val n = nums.size
        val dp = IntArray(n) { -1 }
        dp[0] = 0
        for (i in 1 until n) {
            for (j in 0 until i) {
                if (dp[j] != -1 && abs(nums[i] - nums[j]) <= target) {
                    dp[i] = dp[i].coerceAtLeast(dp[j] + 1)
                }
            }
        }
        return dp[n - 1]
    }
}
