package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-difference-between-highest-and-lowest-of-k-scores
class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    fun minimumDifference(nums: IntArray, k: Int): Int {
        if (k <= 1) return 0
        nums.sort()
        var minDiff = Int.MAX_VALUE

        for (i in 0..nums.size - k) {
            val diff = nums[i + k - 1] - nums[i]
            minDiff = minOf(minDiff, diff)
        }

        return minDiff
    }
}
