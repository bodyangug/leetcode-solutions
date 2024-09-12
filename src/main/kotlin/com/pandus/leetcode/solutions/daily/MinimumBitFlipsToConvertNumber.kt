package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-bit-flips-to-convert-number
class MinimumBitFlipsToConvertNumber {
    fun minBitFlips(start: Int, goal: Int): Int {
        if (start == 0 && goal == 0) return 0
        // Flip for the current least significant bit
        val flip = if ((start and 1) != (goal and 1)) 1 else 0
        // Recurse for the next bits by right-shifting both numbers
        return flip + minBitFlips(start shr 1, goal shr 1)
    }
}
