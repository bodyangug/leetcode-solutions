package com.pandus.leetcode.solutions.daily

import java.util.*

// Reference: https://leetcode.com/problems/count-number-of-balanced-permutations
class CountNumberOfBalancedPermutations {
    val MOD = 1_000_000_007L
    private lateinit var memo: Array<Array<LongArray>>
    private lateinit var cnt: IntArray
    private lateinit var psum: IntArray
    private lateinit var comb: Array<LongArray>
    private var target = 0

    fun countBalancedPermutations(num: String): Int {
        val n = num.length
        var tot = 0
        cnt = IntArray(10)
        for (ch in num) {
            val d = ch - '0'
            cnt[d]++
            tot += d
        }
        if (tot % 2 != 0) return 0
        target = tot / 2
        val maxOdd = (n + 1) / 2

        // Precompute combinations
        comb = Array(maxOdd + 1) { LongArray(maxOdd + 1) }
        for (i in 0..maxOdd) {
            comb[i][0] = 1
            comb[i][i] = 1
            for (j in 1 until i) {
                comb[i][j] = (comb[i - 1][j] + comb[i - 1][j - 1]) % MOD
            }
        }

        psum = IntArray(11)
        for (i in 9 downTo 0) {
            psum[i] = psum[i + 1] + cnt[i]
        }

        memo = Array(10) { Array(target + 1) { LongArray(maxOdd + 1) { -1L } } }
        return dfs(0, 0, maxOdd).toInt()
    }

    private fun dfs(pos: Int, curr: Int, oddCnt: Int): Long {
        if (oddCnt < 0 || psum[pos] < oddCnt || curr > target) return 0
        if (pos > 9) return if (curr == target && oddCnt == 0) 1L else 0L
        if (memo[pos][curr][oddCnt] != -1L) return memo[pos][curr][oddCnt]

        val evenCnt = psum[pos] - oddCnt
        var res = 0L
        val minI = maxOf(0, cnt[pos] - evenCnt)
        val maxI = minOf(cnt[pos], oddCnt)
        for (i in minI..maxI) {
            val ways = (comb[oddCnt][i] * comb[evenCnt][cnt[pos] - i]) % MOD
            val next = dfs(pos + 1, curr + i * pos, oddCnt - i)
            res = (res + (ways * next) % MOD) % MOD
        }
        memo[pos][curr][oddCnt] = res
        return res
    }
}
