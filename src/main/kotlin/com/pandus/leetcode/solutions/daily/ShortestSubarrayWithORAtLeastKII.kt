package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/shortest-subarray-with-or-at-least-k-ii
class ShortestSubarrayWithORAtLeastKII {
    fun minimumSubarrayLength(nums: IntArray, k: Int): Int {
        var minLength = Int.MAX_VALUE
        var windowStart = 0
        var windowEnd = 0
        val bitCounts = IntArray(32)

        while (windowEnd < nums.size) {
            // Add current number to window
            updateBitCounts(bitCounts, nums[windowEnd], 1)

            // Contract window while OR value is valid
            while (windowStart <= windowEnd &&
                convertBitCountsToNumber(bitCounts) >= k
            ) {
                // Update minimum length found so far
                minLength = min(minLength.toDouble(), (windowEnd - windowStart + 1).toDouble()).toInt()

                // Remove leftmost number and shrink window
                updateBitCounts(bitCounts, nums[windowStart], -1)
                windowStart++
            }

            windowEnd++
        }

        return if (minLength == Int.MAX_VALUE) -1 else minLength
    }

    private fun updateBitCounts(bitCounts: IntArray, number: Int, delta: Int) {
        for (bitPosition in 0..31) {
            // Check if bit is set at current position
            if (((number shr bitPosition) and 1) != 0) {
                bitCounts[bitPosition] += delta
            }
        }
    }

    private fun convertBitCountsToNumber(bitCounts: IntArray): Int {
        var result = 0
        for (bitPosition in 0..31) {
            if (bitCounts[bitPosition] != 0) {
                result = result or (1 shl bitPosition)
            }
        }
        return result
    }
}
