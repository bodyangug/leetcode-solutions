package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-ways-to-build-good-strings
class CountWaysToBuildGoodStrings {
    fun countGoodStrings(low: Int, high: Int, zero: Int, one: Int): Int {
        val dp = IntArray(high + 1)
        dp[0] = 1
        val mod = 1000000007

        for (end in 1..high) {
            if (end >= zero) {
                dp[end] += dp[end - zero]
            }
            if (end >= one) {
                dp[end] += dp[end - one]
            }
            dp[end] %= mod
        }

        var answer = 0
        for (i in low..high) {
            answer += dp[i]
            answer %= mod
        }
        return answer
    }
}
