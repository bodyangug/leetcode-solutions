package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/total-waviness-of-numbers-in-range-ii
class TotalWavinessOfNumbersInRangeII {
    fun totalWaviness(num1: Long, num2: Long): Long {
        return solve(num2) - solve(num1 - 1)
    }

    private fun solve(n: Long): Long {
        if (n < 1) return 0L
        val digits = n.toString().map { it - '0' }
        val len = digits.size
        // memo only for non-tight states. Key: pos, prev2(-1..9), prev1(-1..9), started
        val memo = HashMap<Int, LongArray>()

        fun key(pos: Int, prev2: Int, prev1: Int, started: Int): Int {
            return (((pos * 11) + (prev2 + 1)) * 11 + (prev1 + 1)) * 2 + started
        }

        // Returns [count, wavinessSum] for completions from this state.
        fun dp(pos: Int, prev2: Int, prev1: Int, tight: Boolean, started: Boolean): LongArray {
            if (pos == len) return longArrayOf(1L, 0L)
            if (!tight) {
                memo[key(pos, prev2, prev1, if (started) 1 else 0)]?.let { return it }
            }
            val limit = if (tight) digits[pos] else 9
            var cnt = 0L
            var sum = 0L
            for (d in 0..limit) {
                val newStarted = started || d > 0
                val newPrev2: Int
                val newPrev1: Int
                var add = 0L
                if (!newStarted) {
                    newPrev2 = -1
                    newPrev1 = -1
                } else if (!started) {
                    // first real digit
                    newPrev2 = -1
                    newPrev1 = d
                } else {
                    newPrev2 = prev1
                    newPrev1 = d
                    if (prev2 != -1) {
                        if ((prev2 < prev1 && prev1 > d) || (prev2 > prev1 && prev1 < d)) {
                            add = 1L
                        }
                    }
                }
                val newTight = tight && d == limit
                val sub = dp(pos + 1, newPrev2, newPrev1, newTight, newStarted)
                cnt += sub[0]
                sum += sub[1] + add * sub[0]
            }
            val res = longArrayOf(cnt, sum)
            if (!tight) memo[key(pos, prev2, prev1, if (started) 1 else 0)] = res
            return res
        }

        return dp(0, -1, -1, tight = true, started = false)[1]
    }
}
