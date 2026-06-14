package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-total-subarray-value-i
class MaximumTotalSubarrayValueI {
    fun maxTotalValue(nums: IntArray, k: Int): Long {
        var mn = nums[0]
        var mx = nums[0]
        for (v in nums) {
            if (v < mn) mn = v
            if (v > mx) mx = v
        }
        return (mx - mn).toLong() * k
    }
}
