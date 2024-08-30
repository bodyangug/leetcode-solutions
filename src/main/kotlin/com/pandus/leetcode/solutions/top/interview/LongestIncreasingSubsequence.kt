package com.pandus.leetcode.solutions.top.interview

import kotlin.math.max

// Reference: https://leetcode.com/problems/longest-increasing-subsequence
class LongestIncreasingSubsequence {
    fun lengthOfLIS(nums: IntArray): Int {
        val dp = IntArray(nums.size) { 1 }

        for (curIdx in 1..<nums.size) {
            for (prevIdx in 0..<curIdx) {
                if (nums[prevIdx] < nums[curIdx]) {
                    dp[curIdx] = max(dp[curIdx], dp[prevIdx] + 1)
                }
            }
        }
        return dp.max()
    }
}
