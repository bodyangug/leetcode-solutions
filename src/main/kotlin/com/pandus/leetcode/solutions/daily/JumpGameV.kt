package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/jump-game-v
class JumpGameV {
    fun maxJumps(arr: IntArray, d: Int): Int {
        val n = arr.size
        val dp = IntArray(n)

        fun dfs(i: Int): Int {
            if (dp[i] != 0) return dp[i]
            dp[i] = 1
            // Jump right
            for (x in 1..d) {
                val j = i + x
                if (j >= n || arr[j] >= arr[i]) break
                dp[i] = maxOf(dp[i], 1 + dfs(j))
            }
            // Jump left
            for (x in 1..d) {
                val j = i - x
                if (j < 0 || arr[j] >= arr[i]) break
                dp[i] = maxOf(dp[i], 1 + dfs(j))
            }
            return dp[i]
        }

        var result = 0
        for (i in 0 until n) {
            result = maxOf(result, dfs(i))
        }
        return result
    }
}