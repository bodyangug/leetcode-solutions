package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/longest-common-subsequence
class LongestCommonSubsequence {
    fun longestCommonSubsequence(str1: String, str2: String): Int {
        val dp = Array(str1.length + 1) { IntArray(str2.length + 1) }

        for (i in str1.length - 1 downTo 0) {
            for (j in str2.length - 1 downTo 0) {
                if (str1[i] == str2[j])
                    dp[i][j] = 1 + dp[i + 1][j + 1]
                else
                    dp[i][j] = maxOf(dp[i][j + 1], dp[i + 1][j])
            }
        }
        return dp[0][0]
    }
}
