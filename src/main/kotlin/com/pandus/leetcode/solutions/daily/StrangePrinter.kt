package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/strange-printer
class StrangePrinter {
    fun strangePrinter(s: String): Int {
        if (s.isEmpty()) return 0
        val len = s.length
        val dp = Array(len) { IntArray(len) }
        for (i in 0 until len) dp[i][i] = 1
        for (l in 2..len) {
            for (i in 0 until len - l + 1) {
                val j = i + l - 1
                dp[i][j] = dp[i][j - 1] + if (s[i] == s[j]) 0 else 1
                for (k in i + 1 until j) {
                    if (s[k] == s[j]) {
                        dp[i][j] = minOf(dp[i][j], dp[i][k - 1] + dp[k][j - 1])
                    }
                }
            }
        }
        return dp[0][len - 1]
    }
}
