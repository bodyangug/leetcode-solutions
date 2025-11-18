package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/1-bit-and-2-bit-characters
class OneBitAndTwoBitCharacters {
    fun isOneBitCharacter(bits: IntArray): Boolean {
        var i = 0
        while (i < bits.size - 1) {
            i += bits[i] + 1
        }
        return i == bits.size - 1
    }
}
