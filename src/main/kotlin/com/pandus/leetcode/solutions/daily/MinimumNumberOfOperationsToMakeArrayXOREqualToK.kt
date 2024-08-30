package com.pandus.leetcode.solutions.daily

// Reference:
class MinimumNumberOfOperationsToMakeArrayXOREqualToK {
    fun minOperations(nums: IntArray, k: Int): Int {
        var k = k
        var finalXor = 0
        // XOR of all integers in the array.
        for (n in nums) {
            finalXor = finalXor xor n
        }

        var count = 0
        // Keep iterating until any of k or finalXor becomes zero.
        while (k > 0 || finalXor > 0) {
            // k % 2 returns the rightmost bit in k,
            // finalXor % 2 returns the rightmost bit in finalXor.
            // Increment counter, if the bits don't match.
            if ((k % 2) != (finalXor % 2)) {
                count++
            }

            // Remove the last bit from both integers.
            k /= 2
            finalXor /= 2
        }
        return count
    }

    fun minOperations2(nums: IntArray, k: Int): Int {
        var finalXor = 0
        for (n in nums) {
            finalXor = finalXor xor n
        }

        return Integer.bitCount(finalXor xor k)
    }
}
