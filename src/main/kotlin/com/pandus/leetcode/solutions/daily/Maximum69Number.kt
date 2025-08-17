package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-69-number
class Maximum69Number {
    fun maximum69Number(num: Int): Int {
        var unit = 1
        var candidate = -1
        var n = num

        while (n > 0) {
            if (n % 10 == 6) candidate = unit
            n /= 10
            unit *= 10
        }

        return if (candidate == -1) num else num + 3 * candidate
    }
}
