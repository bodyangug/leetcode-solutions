package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-ascending-subarray-sum
class MaximumAscendingSubarraySum {
    fun maxAscendingSum(nums: IntArray): Int {
        var sum = nums[0]
        var maxSum = sum
        for (i in 1 until nums.size) {
            sum = if (nums[i] > nums[i - 1]) sum + nums[i] else nums[i]
            maxSum = maxOf(maxSum, sum)
        }
        return maxSum
    }
}
