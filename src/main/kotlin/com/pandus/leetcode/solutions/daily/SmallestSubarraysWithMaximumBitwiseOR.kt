package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/smallest-subarrays-with-maximum-bitwise-or
class SmallestSubarraysWithMaximumBitwiseOR {
    fun smallestSubarrays(nums: IntArray): IntArray {
        val n = nums.size
        val bitSize = Int.SIZE_BITS // usually 32
        val pos = IntArray(bitSize) { -1 }
        val result = IntArray(n)

        for (i in n - 1 downTo 0) {
            var maxPos = i
            for (bit in 0 until bitSize) {
                if ((nums[i] shr bit) and 1 == 1) {
                    pos[bit] = i
                } else if (pos[bit] != -1) {
                    maxPos = maxOf(maxPos, pos[bit])
                }
            }
            result[i] = maxPos - i + 1
        }

        return result
    }
}
