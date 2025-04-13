package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-good-numbers
class CountGoodNumbers {

    private val mod = 1_000_000_007L

    fun countGoodNumbers(n: Long): Int {
        val evenPositions = n / 2
        val oddPositions = (n + 1) / 2
        val result = modPow(5, oddPositions) * modPow(4, evenPositions) % mod
        return result.toInt()
    }

    fun modPow(base: Long, exp: Long): Long {
        var result = 1L
        var b = base % mod
        var e = exp
        while (e > 0) {
            if (e and 1L == 1L) {
                result = (result * b) % mod
            }
            b = (b * b) % mod
            e = e shr 1
        }
        return result
    }
}
