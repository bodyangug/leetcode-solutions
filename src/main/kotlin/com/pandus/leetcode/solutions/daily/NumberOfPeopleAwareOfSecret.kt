package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-people-aware-of-a-secret
class NumberOfPeopleAwareOfSecret {
    fun peopleAwareOfSecret(n: Int, delay: Int, forget: Int): Int {
        val MOD = 1_000_000_007
        val dp = IntArray(n + 1)
        dp[1] = 1

        var sharers = 0L

        for (day in 2..n) {
            if (day - delay >= 1) {
                sharers = (sharers + dp[day - delay]) % MOD
            }
            if (day - forget >= 1) {
                sharers = (sharers - dp[day - forget]) % MOD
                if (sharers < 0) sharers += MOD
            }
            dp[day] = sharers.toInt()
        }

        var result = 0L
        val start = maxOf(1, n - forget + 1)
        for (day in start..n) {
            result = (result + dp[day]) % MOD
        }
        return result.toInt()
    }
}
