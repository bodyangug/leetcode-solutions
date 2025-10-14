package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i
class AdjacentIncreasingSubarraysDetectionI {
    fun hasIncreasingSubarrays(nums: List<Int>, k: Int): Boolean {
        var currentIncreasingLength = 1
        var previousIncreasingLength = 0
        for (i in 1 until nums.size) {
            if (nums[i] > nums[i - 1]) {
                currentIncreasingLength++
            } else {
                previousIncreasingLength = currentIncreasingLength
                currentIncreasingLength = 1
            }
            val currentSplit = currentIncreasingLength / 2
            val adjacentPair = minOf(previousIncreasingLength, currentIncreasingLength)
            val maxPossibleK = maxOf(currentSplit, adjacentPair)
            if (maxPossibleK >= k) return true
        }
        return false
    }
}
