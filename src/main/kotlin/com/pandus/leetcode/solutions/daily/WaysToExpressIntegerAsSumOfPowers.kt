package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/ways-to-express-an-integer-as-sum-of-powers
class WaysToExpressIntegerAsSumOfPowers {
    private val MOD: Int = 1_000_000_007

    fun numberOfWays(n: Int, x: Int): Int {
        if (n == 0) return 1

        // Build all x-th powers <= n using integer math
        val vals = ArrayList<Int>()
        var i = 1
        while (true) {
            val v = powLE(i, x, n)
            if (v > n) break
            vals.add(v)
            i++
        }

        // 1D knapsack DP
        val dp = IntArray(n + 1)
        dp[0] = 1
        for (v in vals) {
            for (s in n downTo v) {
                val sum = dp[s] + dp[s - v]
                // (a + b) <= 2*MOD fits in Int; safe to mod after addition
                dp[s] = if (sum >= MOD) sum - MOD else sum
            }
        }
        return dp[n]
    }

    // Compute i^x but stop early if it exceeds limit; returns value as Int (or > limit)
    private fun powLE(base: Int, exp: Int, limit: Int): Int {
        var result = 1L
        var b = base.toLong()
        var e = exp
        // fast exponentiation with early stopping against 'limit'
        while (e > 0) {
            if ((e and 1) == 1) {
                result *= b
                if (result > limit) return limit + 1 // sentinel > limit
            }
            e = e shr 1
            if (e > 0) {
                // square only if we’ll use it again
                b *= b
                if (b > limit) b = (limit + 1).toLong()
            }
        }
        return result.toInt()
    }
}
