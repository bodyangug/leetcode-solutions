package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/predict-the-winner
class PredictWinner {
    fun predictTheWinner(nums: IntArray): Boolean {
        val n = nums.size
        val dp = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            dp[i][i] = nums[i]
        }
        for (len in 2..n) {
            for (i in 0..n - len) {
                val j = i + len - 1
                dp[i][j] = maxOf(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1])
            }
        }
        return dp[0][n - 1] >= 0
    }
}
