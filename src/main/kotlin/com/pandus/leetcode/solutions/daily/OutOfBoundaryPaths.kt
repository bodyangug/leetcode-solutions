package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/out-of-boundary-paths
class OutOfBoundaryPaths {
    fun findPaths(m: Int, n: Int, maxMove: Int, startRow: Int, startColumn: Int): Int {
        val mod = 1_000_000_007
        var dp = Array(m) { IntArray(n) }
        dp[startRow][startColumn] = 1
        var count = 0

        fun addToCount(value: Int) {
            count = (count + value) % mod
        }

        for (moves in 1..maxMove) {
            val temp = Array(m) { IntArray(n) }
            for (i in 0 until m) {
                for (j in 0 until n) {
                    if (i == m - 1) addToCount(dp[i][j])
                    if (j == n - 1) addToCount(dp[i][j])
                    if (i == 0) addToCount(dp[i][j])
                    if (j == 0) addToCount(dp[i][j])
                    val up = if (i > 0) dp[i - 1][j] else 0
                    val down = if (i < m - 1) dp[i + 1][j] else 0
                    val left = if (j > 0) dp[i][j - 1] else 0
                    val right = if (j < n - 1) dp[i][j + 1] else 0
                    temp[i][j] = ((up + down) % mod + (left + right) % mod) % mod
                }
            }
            dp = temp
        }
        return count
    }
}
