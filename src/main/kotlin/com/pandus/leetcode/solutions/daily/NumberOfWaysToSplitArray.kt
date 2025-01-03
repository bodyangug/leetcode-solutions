package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/number-of-ways-to-split-array
class NumberOfWaysToSplitArray {
    fun waysToSplitArray(nums: IntArray): Int {
        var r = nums.sumOf { it.toLong() }
        var l = 0L
        return (0..<nums.lastIndex).count {
            l += nums[it]
            r -= nums[it]
            l >= r
        }
    }
}
