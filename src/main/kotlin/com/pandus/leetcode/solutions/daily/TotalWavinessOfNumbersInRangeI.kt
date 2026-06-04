package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/total-waviness-of-numbers-in-range-i
class TotalWavinessOfNumbersInRangeI {
    fun totalWaviness(num1: Int, num2: Int): Int {
        return solve(num2) - solve(num1 - 1)
    }

    private fun solve(num: Int): Int {
        if (num < 0) return 0
        val digits = num.toString().map { it - '0' }
        val n = digits.size
        val memo = HashMap<Long, LongArray>()

        fun dp(pos: Int, prevPrev: Int, prev: Int, tight: Boolean, started: Boolean): LongArray {
            if (pos == n) return longArrayOf(if (started) 1L else 0L, 0L)

            val key = pos.toLong() * 11 * 11 * 4 +
                    prevPrev.toLong() * 11 * 4 +
                    prev.toLong() * 4 +
                    (if (tight) 2L else 0L) +
                    (if (started) 1L else 0L)
            memo[key]?.let { return it }

            val limit = if (tight) digits[pos] else 9
            var totalCount = 0L
            var totalSum = 0L

            for (d in 0..limit) {
                val newTight = tight && (d == limit)
                val newStarted = started || (d != 0)

                var contribution = 0
                if (started && prev != 10 && prevPrev != 10) {
                    if (prev > prevPrev && prev > d) contribution = 1
                    else if (prev < prevPrev && prev < d) contribution = 1
                }

                val newPrevPrev: Int
                val newPrev: Int
                if (!newStarted) {
                    newPrevPrev = 10
                    newPrev = 10
                } else if (!started) {
                    newPrevPrev = 10
                    newPrev = d
                } else {
                    newPrevPrev = prev
                    newPrev = d
                }

                val result = dp(pos + 1, newPrevPrev, newPrev, newTight, newStarted)
                totalCount += result[0]
                totalSum += result[1] + contribution * result[0]
            }

            val res = longArrayOf(totalCount, totalSum)
            memo[key] = res
            return res
        }

        return dp(0, 10, 10, true, false)[1].toInt()
    }
}
