package com.pandus.leetcode.solutions.daily

//Reference:https://leetcode.com/problems/minimum-falling-path-sum
class MinimumFallingPathSum {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        val n = matrix.size
        var dp = IntArray(n) { 0 }

        for (col in matrix.indices) {
            dp[col] = matrix[n - 1][col]
        }

        for (row in n - 2 downTo 0) {
            val newDp = IntArray(n)
            for (col in matrix.indices) {
                val left = if (col > 0) dp[col - 1] else Int.MAX_VALUE
                val right = if (col < n - 1) dp[col + 1] else Int.MAX_VALUE
                newDp[col] = matrix[row][col] + minOf(dp[col], left, right)
            }
            dp = newDp
        }
        return dp.minOrNull() ?: Int.MAX_VALUE
    }
}