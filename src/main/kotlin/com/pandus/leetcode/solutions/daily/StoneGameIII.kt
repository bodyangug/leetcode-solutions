package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/stone-game-iii
class StoneGameIII {
    fun stoneGameIII(stoneValue: IntArray): String {
        val n = stoneValue.size
        val dp = IntArray(n + 1)
        for (i in n - 1 downTo 0) {
            dp[i] = Int.MIN_VALUE
            var take = 0
            for (j in 0..2) {
                if (i + j < n) {
                    take += stoneValue[i + j]
                    dp[i] = maxOf(dp[i], take - dp[i + j + 1])
                }
            }
        }
        return when {
            dp[0] > 0 -> "Alice"
            dp[0] < 0 -> "Bob"
            else -> "Tie"
        }
    }
}
