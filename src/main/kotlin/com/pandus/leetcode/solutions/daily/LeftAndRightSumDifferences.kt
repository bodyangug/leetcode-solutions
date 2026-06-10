package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/left-and-right-sum-differences
class LeftAndRightSumDifferences {
    fun leftRightDifference(nums: IntArray): IntArray {
        val leftSum = IntArray(nums.size)
        val rightSum = IntArray(nums.size)
        for (i in nums.indices) {
            leftSum[i] = if (i == 0) 0 else leftSum[i - 1] + nums[i - 1]
        }
        for (i in nums.size - 1 downTo 0) {
            rightSum[i] = if (i == nums.size - 1) 0 else rightSum[i + 1] + nums[i + 1]
        }
        val result = IntArray(nums.size)
        for (i in nums.indices) {
            result[i] = kotlin.math.abs(leftSum[i] - rightSum[i])
        }
        return result
    }
}
