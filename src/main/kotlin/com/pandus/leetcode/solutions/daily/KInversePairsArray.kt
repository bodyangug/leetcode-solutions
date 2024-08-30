package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/k-inverse-pairs-array
class KInversePairsArray {
    private val memo = Array(1001) { arrayOfNulls<Int?>(1001) }

    fun kInversePairs(n: Int, k: Int): Int {
        if (n == 0) return 0
        if (k == 0) return 1
        if (memo[n][k] != null) return memo[n][k]!!

        var inv = 0
        for (i in 0..k.coerceAtMost(n - 1)) {
            inv = (inv + kInversePairs(n - 1, k - i)) % 1000000007
        }
        memo[n][k] = inv
        return inv
    }
}
