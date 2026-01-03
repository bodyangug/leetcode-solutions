package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-ways-to-paint-n-3-grid
class NumberOfWaysToPaintN3Grid {
    fun numOfWays(n: Int): Int {
        val MOD = 1_000_000_007L
        var sameColorPatterns = 6L
        var diffColorPatterns = 6L
        for (i in 2..n) {
            val newSameColorPatterns = (3 * sameColorPatterns + 2 * diffColorPatterns) % MOD
            val newDiffColorPatterns = (2 * sameColorPatterns + 2 * diffColorPatterns) % MOD

            sameColorPatterns = newSameColorPatterns
            diffColorPatterns = newDiffColorPatterns
        }

        return ((sameColorPatterns + diffColorPatterns) % MOD).toInt()
    }
}
