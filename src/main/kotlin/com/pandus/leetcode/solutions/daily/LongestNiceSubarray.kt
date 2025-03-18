package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/longest-nice-subarray
class LongestNiceSubarray {
    fun longestNiceSubarray(nums: IntArray): Int {
        var usedBits = 0 // Tracks bits used in current window
        var windowStart = 0 // Start position of current window
        var maxLength = 0 // Length of longest nice subarray found

        for (windowEnd in nums.indices) {
            while ((usedBits and nums[windowEnd]) != 0) {
                usedBits = usedBits xor nums[windowStart] // Remove leftmost element's bits
                windowStart++
            }
            usedBits = usedBits or nums[windowEnd]
            maxLength = max(maxLength, (windowEnd - windowStart + 1))
        }
        return maxLength
    }
}
