package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/
class AdjacentIncreasingSubarraysDetectionII {
    fun maxIncreasingSubarrays(nums: List<Int>): Int {
        var currentIncreasingLength = 1
        var previousIncreasingLength = 0
        var maxAdjacentLength = 0

        for (i in 1..<nums.size) {
            if (nums[i] > nums[i - 1]) {
                currentIncreasingLength++
            } else {
                previousIncreasingLength = currentIncreasingLength
                currentIncreasingLength = 1
            }

            // Calculate max of two scenarios:
            // 1. Two separate adjacent sequences with min length
            // 2. One sequence split in half
            maxAdjacentLength = maxOf(
                maxAdjacentLength,
                minOf(previousIncreasingLength, currentIncreasingLength),
                currentIncreasingLength / 2
            )
        }
        return maxAdjacentLength
    }
}
