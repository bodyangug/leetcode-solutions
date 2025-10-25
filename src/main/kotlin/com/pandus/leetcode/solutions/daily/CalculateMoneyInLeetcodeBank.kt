package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/calculate-money-in-leetcode-bank
class CalculateMoneyInLeetcodeBank {
    fun totalMoney(n: Int): Int {
        var n = n
        var ans = 0
        var monday = 1

        while (n > 0) {
            for (day in 0..<min(n, 7)) {
                ans += monday + day
            }
            n -= 7
            monday++
        }
        return ans
    }
}
