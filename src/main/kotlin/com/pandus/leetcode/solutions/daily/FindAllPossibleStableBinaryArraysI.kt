package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/find-all-possible-stable-binary-arrays-i
class FindAllPossibleStableBinaryArraysI {

    companion object {
        private const val MOD = 1_000_000_007L
    }

    fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
        val dp = Array(zero + 1) { Array(one + 1) { LongArray(2) } }

        initializeBaseCases(dp, zero, one, limit)
        computeTransitions(dp, zero, one, limit)

        return ((dp[zero][one][0] + dp[zero][one][1]) % MOD).toInt()
    }

    private fun initializeBaseCases(dp: Array<Array<LongArray>>, zero: Int, one: Int, limit: Int) {
        for (i in 0..min(zero, limit)) {
            dp[i][0][0] = 1
        }
        for (j in 0..min(one, limit)) {
            dp[0][j][1] = 1
        }
    }

    private fun computeTransitions(dp: Array<Array<LongArray>>, zero: Int, one: Int, limit: Int) {
        for (i in 1..zero) {
            for (j in 1..one) {
                dp[i][j][0] = computeEndingWithZero(dp, i, j, limit)
                dp[i][j][1] = computeEndingWithOne(dp, i, j, limit)
            }
        }
    }

    private fun computeEndingWithZero(dp: Array<Array<LongArray>>, i: Int, j: Int, limit: Int): Long {
        val value = if (i > limit) {
            dp[i - 1][j][0] + dp[i - 1][j][1] - dp[i - limit - 1][j][1]
        } else {
            dp[i - 1][j][0] + dp[i - 1][j][1]
        }
        return ((value % MOD) + MOD) % MOD
    }

    private fun computeEndingWithOne(dp: Array<Array<LongArray>>, i: Int, j: Int, limit: Int): Long {
        val value = if (j > limit) {
            dp[i][j - 1][1] + dp[i][j - 1][0] - dp[i][j - limit - 1][0]
        } else {
            dp[i][j - 1][1] + dp[i][j - 1][0]
        }
        return ((value % MOD) + MOD) % MOD
    }
}
