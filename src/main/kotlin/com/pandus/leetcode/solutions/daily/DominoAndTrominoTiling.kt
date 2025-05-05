package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/domino-and-tromino-tiling
class DominoAndTrominoTiling {
    fun numTilings(n: Int): Int {
        val MOD = 1_000_000_007
        if (n == 1) return 1
        if (n == 2) return 2

        val dp = LongArray(n + 1)
        val dp2 = LongArray(n + 1)

        dp[0] = 1
        dp[1] = 1
        dp[2] = 2
        dp2[2] = 1

        for (i in 3..n) {
            dp2[i] = (dp2[i - 1] + dp[i - 2]) % MOD
            dp[i] = (dp[i - 1] + dp[i - 2] + 2 * dp2[i - 1]) % MOD
        }

        return dp[n].toInt()
    }
}
