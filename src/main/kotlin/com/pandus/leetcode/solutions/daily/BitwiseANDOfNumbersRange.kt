package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/bitwise-and-of-numbers-range
class BitwiseANDOfNumbersRange {
    fun rangeBitwiseAnd(left: Int, right: Int): Int {
        var left = left
        var right = right
        var shift = 0
        while (left < right) {
            left = left shr 1
            right = right shr 1
            ++shift
        }
        return left shl shift
    }
}
