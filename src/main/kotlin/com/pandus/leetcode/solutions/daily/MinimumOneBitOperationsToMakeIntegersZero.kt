package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-one-bit-operations-to-make-integers-zero
class MinimumOneBitOperationsToMakeIntegersZero {
    fun minimumOneBitOperations(n: Int): Int = when {
        n == 0 -> 0
        else -> {
            val highestBitPosition = findHighestBitPosition(n)
            val highestBitValue = 1 shl highestBitPosition
            (1 shl (highestBitPosition + 1)) - 1 - minimumOneBitOperations(n xor highestBitValue)
        }
    }

    private fun findHighestBitPosition(n: Int): Int {
        var position = 0
        var value = 1
        while (value shl 1 <= n) {
            value = value shl 1
            position++
        }
        return position
    }
}
