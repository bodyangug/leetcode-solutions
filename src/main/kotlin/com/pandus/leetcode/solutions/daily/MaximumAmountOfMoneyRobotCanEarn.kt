package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-amount-of-money-robot-can-earn
class MaximumAmountOfMoneyRobotCanEarn {
    fun maximumAmount(coins: Array<IntArray>): Int {
        val m = coins.size
        val n = coins[0].size
        val dp = Array(m) { Array(n) { IntArray(3) { Int.MIN_VALUE } } }

        dp[0][0][0] = coins[0][0]
        if (coins[0][0] < 0) dp[0][0][1] = 0

        for (i in 0 until m) {
            for (j in 0 until n) {
                for (k in 0..2) {
                    if (dp[i][j][k] == Int.MIN_VALUE) continue
                    val cur = dp[i][j][k]
                    for ((di, dj) in arrayOf(0 to 1, 1 to 0)) {
                        val ni = i + di
                        val nj = j + dj
                        if (ni >= m || nj >= n) continue
                        val v = coins[ni][nj]
                        dp[ni][nj][k] = maxOf(dp[ni][nj][k], cur + v)
                        if (v < 0 && k < 2) {
                            dp[ni][nj][k + 1] = maxOf(dp[ni][nj][k + 1], cur)
                        }
                    }
                }
            }
        }
        return maxOf(dp[m - 1][n - 1][0], dp[m - 1][n - 1][1], dp[m - 1][n - 1][2])
    }
}
