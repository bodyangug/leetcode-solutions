package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/shortest-common-supersequence
class ShortestCommonSupersequence {
    fun shortestCommonSupersequence(str1: String, str2: String): String {
        val m = str1.length
        val n = str2.length

        // Step 1: Compute LCS using DP
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 1..m) {
            for (j in 1..n) {
                dp[i][j] = if (str1[i - 1] == str2[j - 1]) {
                    dp[i - 1][j - 1] + 1
                } else {
                    maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        // Step 2: Construct SCS using LCS table
        val sb = StringBuilder()
        var i = m
        var j = n

        while (i > 0 || j > 0) {
            when {
                i > 0 && j > 0 && str1[i - 1] == str2[j - 1] -> {
                    sb.append(str1[i - 1])
                    i--
                    j--
                }

                j == 0 || (i > 0 && dp[i - 1][j] >= dp[i][j - 1]) -> {
                    sb.append(str1[i - 1])
                    i--
                }

                else -> {
                    sb.append(str2[j - 1])
                    j--
                }
            }
        }
        return sb.reverse().toString()
    }
}
