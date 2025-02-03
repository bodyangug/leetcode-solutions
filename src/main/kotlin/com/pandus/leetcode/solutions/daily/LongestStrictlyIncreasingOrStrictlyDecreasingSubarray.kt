package com.pandus.leetcode.solutions.daily

import kotlin.math.max

// Reference: https://leetcode.com/problems/longest-strictly-increasing-or-strictly-decreasing-subarray
class LongestStrictlyIncreasingOrStrictlyDecreasingSubarray {
    fun longestMonotonicSubarray(nums: IntArray) =
        nums.indices.maxOf { i ->
            var a = i + 1
            var b = a
            while (a < nums.size && nums[a - 1] > nums[a]) a++
            while (b < nums.size && nums[b - 1] < nums[b]) b++
            max(b - i, a - i)
        }
}
