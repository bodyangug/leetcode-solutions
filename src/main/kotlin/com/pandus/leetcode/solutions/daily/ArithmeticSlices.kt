package com.pandus.leetcode.solutions.daily

//Reference: https://leetcode.com/problems/arithmetic-slices
class ArithmeticSlices {
    fun numberOfArithmeticSlices(nums: IntArray): Int {
        var maxSize = 0
        val dp = IntArray(nums.size) { 0 }
        for (index in 2..<nums.size) {
            if (nums[index] - nums[index - 1] == nums[index - 1] - nums[index - 2]) {
                dp[index] = dp[index - 1] + 1
                maxSize += dp[index]
            }
        }
        return maxSize
    }
}