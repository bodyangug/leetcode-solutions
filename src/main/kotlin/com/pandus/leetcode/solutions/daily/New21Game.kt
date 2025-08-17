package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/new-21-game
class New21Game {
    fun new21Game(n: Int, k: Int, maxPts: Int): Double {
        if (k == 0 || n >= k - 1 + maxPts) return 1.0

        val dp = DoubleArray(n + 1)
        dp[0] = 1.0

        var window = 1.0 // sum of dp[i-1]..dp[i-maxPts] but only from indices < k
        var ans = 0.0

        for (i in 1..n) {
            dp[i] = window / maxPts

            if (i < k) {
                // This state can still draw; include it in the window for future states
                window += dp[i]
            } else {
                // Terminal state; contributes directly to the answer
                ans += dp[i]
            }

            // Remove the contribution that slides out of the window
            if (i - maxPts >= 0 && i - maxPts < k) {
                window -= dp[i - maxPts]
            }
        }

        return ans
    }
}
