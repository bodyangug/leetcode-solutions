package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/binary-number-with-alternating-bits
class BinaryNumberWithAlternatingBits {
    fun hasAlternatingBits(n: Int): Boolean {
        var prevBit = -1
        var num = n
        while (num > 0) {
            val currentBit = num and 1
            if (currentBit == prevBit) {
                return false
            }
            prevBit = currentBit
            num = num shr 1
        }
        return true
    }
}
