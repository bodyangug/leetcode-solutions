package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-zero-filled-subarrays
class NumberOfZeroFilledSubarrays {
    fun zeroFilledSubarray(nums: IntArray): Long {
        var streak = 0L
        var res = 0L
        for (x in nums) {
            streak = if (x == 0) streak + 1 else 0L
            res += streak
        }
        return res
    }
}
