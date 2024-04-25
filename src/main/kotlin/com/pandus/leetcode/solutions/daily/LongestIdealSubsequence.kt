package com.pandus.leetcode.solutions.daily

import kotlin.math.abs


//Reference: https://leetcode.com/problems/longest-ideal-subsequence
class LongestIdealSubsequence {
    fun longestIdealString(s: String, k: Int): Int {
        val N = s.length

        // Initialize all dp values to -1 to indicate non-visited states
        val dp = Array(N) { IntArray(26) { -1 } }

        // Find the maximum dp[N-1][c] and return the result
        var res = 0
        (0..25).forEach { c ->
            res = maxOf(res, dfs(N - 1, c, dp, s, k))
        }
        return res
    }

    fun dfs(i: Int, c: Int, dp: Array<IntArray>, s: String, k: Int): Int {
        // Memoized value
        if (dp[i][c] != -1) {
            return dp[i][c]
        }

        // State is not visited yet
        dp[i][c] = 0
        val match = c == (s[i].code - 'a'.code)
        if (match) {
            dp[i][c] = 1
        }

        // Non base case handling
        if (i > 0) {
            dp[i][c] = dfs(i - 1, c, dp, s, k)
            if (match) {
                (0..25).forEach { p ->
                    if (abs(c - p) <= k) {
                        dp[i][c] = maxOf(dp[i][c], dfs(i - 1, p, dp, s, k) + 1)
                    }
                }
            }
        }
        return dp[i][c]
    }
}
