package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/make-the-string-great
class MakeTheStringGreat {
    fun makeGood(s: String): String {
        for (i in 0 until s.length - 1) {
            if (abs(s[i].code - s[i + 1].code) == 32) return makeGood(
                s.substring(
                    0,
                    i
                ) + s.substring(i + 2)
            )
        }
        return s
    }
}
