package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-smooth-descent-periods-of-a-stock
class NumberOfSmoothDescentPeriodsOfStock {
    fun getDescentPeriods(prices: IntArray): Long {
        val n = prices.size
        var res: Long = 1
        var prev = 1
        for (i in 1..<n) {
            if (prices[i] == prices[i - 1] - 1) {
                ++prev
            } else {
                prev = 1
            }
            res += prev.toLong()
        }
        return res
    }
}
