package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-path-score-in-a-grid
class MaximumPathScoreInGrid {
    fun maxPathScore(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size
        val dp = Array(m) { Array(n) { IntArray(k + 1) { -1 } } }
        dp[0][0][grid[0][0]] = grid[0][0]
        for (i in 0 until m) {
            for (j in 0 until n) {
                for (cost in 0..k) {
                    if (dp[i][j][cost] == -1) continue
                    val score = dp[i][j][cost]
                    if (i + 1 < m) {
                        val newCost = cost + if (grid[i + 1][j] == 0) 0 else 1
                        if (newCost <= k) {
                            dp[i + 1][j][newCost] = maxOf(dp[i + 1][j][newCost], score + grid[i + 1][j])
                        }
                    }
                    if (j + 1 < n) {
                        val newCost = cost + if (grid[i][j + 1] == 0) 0 else 1
                        if (newCost <= k) {
                            dp[i][j + 1][newCost] = maxOf(dp[i][j + 1][newCost], score + grid[i][j + 1])
                        }
                    }
                }
            }
        }
        return dp[m - 1][n - 1].maxOrNull() ?: -1
    }
}
