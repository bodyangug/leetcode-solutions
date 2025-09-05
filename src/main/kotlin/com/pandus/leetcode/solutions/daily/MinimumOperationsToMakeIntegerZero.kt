package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-operations-to-make-the-integer-zero
class MinimumOperationsToMakeIntegerZero {
    fun makeTheIntegerZero(num1: Int, num2: Int): Int {
        val a = num1.toLong()
        val b = num2.toLong()

        for (k in 1..60) {
            val x = a - b * k
            if (x < k) return -1
            if (k >= java.lang.Long.bitCount(x)) return k
        }
        return -1
    }
}
