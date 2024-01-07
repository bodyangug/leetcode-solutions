package com.pandus.leetcode.solutions.top.interview

import kotlin.math.abs

//Reference: https://leetcode.com/problems/sqrtx/
class SqrtX {
    fun mySqrt(x: Int): Int {
        var t = x.toDouble()
        val epsilon = 1e-15
        while (abs(t - x / t) > epsilon * t) {
            t = (x / t + t) / 2.0
        }
        return t.toInt()
    }
}