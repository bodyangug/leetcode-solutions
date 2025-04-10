package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-the-number-of-powerful-integers
class CountNumberOfPowerfulIntegers {
    data class State(val i: Int, val tightLow: Boolean, val tightHigh: Boolean)

    fun numberOfPowerfulInt(
        start: Long,
        finish: Long,
        limit: Int,
        s: String
    ): Long {
        val high = finish.toString()
        val n = high.length
        val low = start.toString().padStart(n, '0')
        val preLen = n - s.length

        val memo = mutableMapOf<State, Long>()

        return dfs(0, true, true, low, high, limit, s, preLen, memo)
    }

    fun dfs(
        i: Int,
        tightLow: Boolean,
        tightHigh: Boolean,
        low: String,
        high: String,
        limit: Int,
        s: String,
        preLen: Int,
        memo: MutableMap<State, Long>
    ): Long {
        if (i == high.length) return 1

        val state = State(i, tightLow, tightHigh)
        if (!tightLow && !tightHigh && memo.containsKey(state)) {
            return memo[state]!!
        }

        val lo = if (tightLow) low[i] - '0' else 0
        val hi = if (tightHigh) high[i] - '0' else 9
        var res = 0L

        if (i < preLen) {
            for (digit in lo..minOf(hi, limit)) {
                res += dfs(
                    i + 1,
                    tightLow && digit == lo,
                    tightHigh && digit == hi,
                    low,
                    high,
                    limit,
                    s,
                    preLen,
                    memo
                )
            }
        } else {
            val x = s[i - preLen] - '0'
            if (x in lo..minOf(hi, limit)) {
                res = dfs(
                    i + 1,
                    tightLow && x == lo,
                    tightHigh && x == hi,
                    low,
                    high,
                    limit,
                    s,
                    preLen,
                    memo
                )
            }
        }

        if (!tightLow && !tightHigh) {
            memo[state] = res
        }
        return res
    }
}
