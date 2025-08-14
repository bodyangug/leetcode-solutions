package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/largest-3-same-digit-number-in-string
class Largest3SameDigitNumberInString {
    fun largestGoodInteger(num: String): String {
        if (num.length < 3) return ""
        var best = Char.MIN_VALUE
        var runChar = num[0]
        var runLen = 1

        for (i in 1 until num.length) {
            val c = num[i]
            if (c == runChar) {
                runLen++
            } else {
                runChar = c
                runLen = 1
            }
            if (runLen >= 3 && c > best) best = c
        }

        return if (best == Char.MIN_VALUE) "" else "$best$best$best"
    }
}
