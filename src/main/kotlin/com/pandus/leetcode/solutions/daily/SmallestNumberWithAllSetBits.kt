package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/smallest-number-with-all-set-bits
class SmallestNumberWithAllSetBits {
    fun smallestNumber(n: Int): Int {
        var x = 1
        while (x < n) {
            x = (x shl 1) or 1
        }
        return x
    }
}
