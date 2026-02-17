package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/champagne-tower
class ChampagneTower {
    fun champagneTower(poured: Int, query_row: Int, query_glass: Int): Double {
        val dp = Array(101) { DoubleArray(101) }
        dp[0][0] = poured.toDouble()
        for (i in 0..99) {
            for (j in 0..i) {
                if (dp[i][j] > 1) {
                    val excess = dp[i][j] - 1
                    dp[i + 1][j] += excess / 2
                    dp[i + 1][j + 1] += excess / 2
                    dp[i][j] = 1.0
                }
            }
        }
        return dp[query_row][query_glass]
    }
}
