package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers
class ConcatenationOfConsecutiveBinaryNumbers {
    fun concatenatedBinary(n: Int): Int {
        val mod = 1_000_000_007
        var result: Long = 0
        var length = 0

        for (i in 1..n) {
            if (i and (i - 1) == 0) {
                length++
            }
            result = ((result shl length) + i) % mod
        }
        return result.toInt()
    }
}
