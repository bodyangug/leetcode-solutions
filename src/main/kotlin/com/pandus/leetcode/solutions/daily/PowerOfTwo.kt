package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/power-of-two
class PowerOfTwo {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n == 0) return false
        val x = n.toLong()
        return x and -x == x
    }
}
