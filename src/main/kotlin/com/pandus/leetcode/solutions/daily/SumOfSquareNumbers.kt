package com.pandus.leetcode.solutions.daily

import kotlin.math.sqrt

// Reference: https://leetcode.com/problems/sum-of-square-numbers
class SumOfSquareNumbers {
    fun judgeSquareSum(c: Int): Boolean {
        var a = 0L
        while (a * a <= c) {
            val b = sqrt((c - a * a).toDouble())
            if (b == b.toInt().toDouble()) {
                return true
            }
            a++
        }
        return false
    }
}
