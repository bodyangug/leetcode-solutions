package com.pandus.leetcode.solutions.daily

import kotlin.collections.get
import kotlin.text.get

// Reference: https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings
class MinimumASCIIDeleteSumForTwoStrings {
    //    Given two strings s1 and s2, return the lowest ASCII sum of deleted characters to make two strings equal.
    fun minimumDeleteSum(s1: String, s2: String): Int {
        val m = s1.length
        val n = s2.length
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 1..m) {
            dp[i][0] = dp[i - 1][0] + s1[i - 1].code
        }

        for (j in 1..n) {
            dp[0][j] = dp[0][j - 1] + s2[j - 1].code
        }

        for (i in 1..m) {
            for (j in 1..n) {
                if (s1[i - 1] == s2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1]
                } else {
                    dp[i][j] = minOf(
                        dp[i - 1][j] + s1[i - 1].code,
                        dp[i][j - 1] + s2[j - 1].code
                    )
                }
            }
        }

        return dp[m][n]
    }
}
