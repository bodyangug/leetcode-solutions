package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/paths-in-matrix-whose-sum-is-divisible-by-k
class PathsInMatrixWhoseSumIsDivisibleByK {

    private val MOD: Int = 1000000007

    fun numberOfPaths(grid: Array<IntArray>, k: Int): Int {
        val m = grid.size
        val n = grid[0].size

        val dp = Array(m + 1) { Array(n + 1) { LongArray(k) } }

        for (i in 1..m) {
            for (j in 1..n) {
                if (i == 1 && j == 1) {
                    dp[i][j][grid[0][0] % k] = 1
                    continue
                }
                val value = grid[i - 1][j - 1] % k
                for (r in 0..<k) {
                    val prevMod = (r - value + k) % k
                    dp[i][j][r] =
                        (dp[i - 1][j][prevMod] + dp[i][j - 1][prevMod]) % MOD
                }
            }
        }
        return dp[m][n][0].toInt()
    }
}
