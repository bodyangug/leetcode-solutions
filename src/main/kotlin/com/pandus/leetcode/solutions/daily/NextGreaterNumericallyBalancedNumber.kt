package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/next-greater-numerically-balanced-number
class NextGreaterNumericallyBalancedNumber {
    fun nextBeautifulNumber(n: Int): Int {
        for (i in n + 1..1224444) {
            if (isBalance(i)) {
                return i
            }
        }
        return -1
    }

    private fun isBalance(x: Int): Boolean {
        var x = x
        val count = IntArray(10)
        while (x > 0) {
            count[x % 10]++
            x /= 10
        }
        for (d in 0..9) {
            if (count[d] > 0 && count[d] != d) {
                return false
            }
        }
        return true
    }
}
