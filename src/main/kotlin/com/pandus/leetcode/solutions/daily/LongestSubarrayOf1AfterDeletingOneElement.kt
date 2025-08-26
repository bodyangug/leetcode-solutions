package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element
class LongestSubarrayOf1AfterDeletingOneElement {
    fun longestSubarray(nums: IntArray): Int {
        var zeroCount = 0
        var start = 0
        var best = 0

        for (end in nums.indices) {
            if (nums[end] == 0) zeroCount++

            while (zeroCount > 1) {
                if (nums[start] == 0) zeroCount--
                start++
            }
            best = max(best, end - start)
        }
        return best
    }
}
