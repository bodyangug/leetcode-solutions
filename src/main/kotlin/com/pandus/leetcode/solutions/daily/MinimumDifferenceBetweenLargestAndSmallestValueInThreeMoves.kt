package com.pandus.leetcode.solutions.daily

import kotlin.math.min

// Reference: https://leetcode.com/problems/minimum-difference-between-largest-and-smallest-value-in-three-moves
class MinimumDifferenceBetweenLargestAndSmallestValueInThreeMoves {
    fun minDifference(nums: IntArray): Int {
        val numsSize = nums.size
        if (numsSize <= 4) return 0

        nums.sort()

        var minDiff = Int.MAX_VALUE

        var left = 0
        var right = numsSize - 4
        while (left < 4) {
            minDiff = min(minDiff, (nums[right] - nums[left]))
            left++
            right++
        }

        return minDiff
    }
}
