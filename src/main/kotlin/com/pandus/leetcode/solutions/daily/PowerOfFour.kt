package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/power-of-four
class PowerOfFour {
    fun isPowerOfFour(n: Int): Boolean {
        if (n <= 0) return false
        val sqrt = kotlin.math.sqrt(n.toDouble()).toInt()
        return sqrt * sqrt == n && (sqrt and (sqrt - 1)) == 0
    }
}
