package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/find-all-possible-stable-binary-arrays-ii
class FindAllPossibleStableBinaryArraysII {
    private val MOD: Int = 1000000007
    private var memo: Array<Array<IntArray>> = arrayOf()
    private var limit: Int = 0

    fun numberOfStableArrays(zero: Int, one: Int, limit: Int): Int {
        this.memo = Array(zero + 1) { Array(one + 1) { IntArray(2) } }
        for (i in 0..zero) {
            for (j in 0..one) {
                Arrays.fill(memo[i][j], -1)
            }
        }
        this.limit = limit
        return (dp(zero, one, 0) + dp(zero, one, 1)) % MOD
    }

    fun dp(zero: Int, one: Int, lastBit: Int): Int {
        if (zero == 0) {
            return if (lastBit == 0 || one > limit) 0 else 1
        } else if (one == 0) {
            return if (lastBit == 1 || zero > limit) 0 else 1
        }

        if (memo[zero][one][lastBit] == -1) {
            var res: Int
            if (lastBit == 0) {
                res = (dp(zero - 1, one, 0) + dp(zero - 1, one, 1)) % MOD
                if (zero > limit) {
                    res = (res - dp(zero - limit - 1, one, 1) + MOD) % MOD
                }
            } else {
                res = (dp(zero, one - 1, 0) + dp(zero, one - 1, 1)) % MOD
                if (one > limit) {
                    res = (res - dp(zero, one - limit - 1, 0) + MOD) % MOD
                }
            }
            memo[zero][one][lastBit] = res % MOD
        }
        return memo[zero][one][lastBit]
    }
}
