package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd
class FindNumberOfSubsequencesWithEqualGCD {
    fun subsequencePairCount(nums: IntArray): Int {
        val mod = 1_000_000_007L
        val maxVal = nums.maxOrNull() ?: 0

        // dp[g1][g2] = number of ways to distribute processed elements so that
        // seq1 has gcd g1 and seq2 has gcd g2 (0 means the subsequence is empty).
        var dp = Array(maxVal + 1) { LongArray(maxVal + 1) }
        dp[0][0] = 1L

        for (num in nums) {
            val next = Array(maxVal + 1) { i -> dp[i].copyOf() }
            for (g1 in 0..maxVal) {
                for (g2 in 0..maxVal) {
                    val ways = dp[g1][g2]
                    if (ways == 0L) continue
                    val ng1 = if (g1 == 0) num else gcd(g1, num)
                    next[ng1][g2] = (next[ng1][g2] + ways) % mod
                    val ng2 = if (g2 == 0) num else gcd(g2, num)
                    next[g1][ng2] = (next[g1][ng2] + ways) % mod
                }
            }
            dp = next
        }

        var answer = 0L
        for (g in 1..maxVal) {
            answer = (answer + dp[g][g]) % mod
        }
        return answer.toInt()
    }

    private fun gcd(a: Int, b: Int): Int {
        var x = a
        var y = b
        while (y != 0) {
            val t = x % y
            x = y
            y = t
        }
        return x
    }
}
