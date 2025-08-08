package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/soup-servings
class SoupServings {
    fun soupServings(n: Int): Double {
        if (n >= 4800) return 1.0
        val m = (n + 24) / 25

        val dp = Array(m + 1) { DoubleArray(m + 1) }

        // Base initialization
        dp[0][0] = 0.5
        for (k in 1..m) {
            dp[0][k] = 1.0
            dp[k][0] = 0.0
        }

        // Fill table
        for (i in 1..m) {
            for (j in 1..m) {
                dp[i][j] = 0.25 * (
                        dp[max(0, i - 4)][j] +
                                dp[max(0, i - 3)][max(0, j - 1)] +
                                dp[max(0, i - 2)][max(0, j - 2)] +
                                dp[max(0, i - 1)][max(0, j - 3)]
                        )
            }
        }
        return dp[m][m]
    }
}
