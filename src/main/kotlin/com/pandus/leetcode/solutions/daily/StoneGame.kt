package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/stone-game
class StoneGame {
    fun stoneGame(piles: IntArray): Boolean {
        val n = piles.size
        val dp = Array(n) { IntArray(n) }
        for (i in 0 until n) {
            dp[i][i] = piles[i]
        }
        for (len in 2..n) {
            for (i in 0..n - len) {
                val j = i + len - 1
                dp[i][j] = maxOf(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1])
            }
        }
        return dp[0][n - 1] > 0
    }
}
