package com.pandus.leetcode.solutions.top.interview

//Reference: https://leetcode.com/problems/factorial-trailing-zeroes
class FactorialTrailingZeroes {
    fun trailingZeroes(n: Int): Int {
        var result = 0
        var divisor = 5

        while (n >= divisor) {
            result += n / divisor
            divisor *= 5
        }
        return result
    }
}