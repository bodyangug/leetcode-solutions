package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/longest-subarray-with-maximum-bitwise-and
class LongestSubarrayWithMaximumBitwiseAND {
    fun longestSubarray(nums: IntArray): Int {
        var maxVal = Int.MIN_VALUE
        var ans = 0
        var currentStreak = 0
        for (num in nums) {
            if (num > maxVal) {
                maxVal = num
                currentStreak = 1
                ans = 1
            } else if (num == maxVal) {
                currentStreak++
                ans = maxOf(ans, currentStreak)
            } else {
                currentStreak = 0
            }
        }
        return ans
    }
}
