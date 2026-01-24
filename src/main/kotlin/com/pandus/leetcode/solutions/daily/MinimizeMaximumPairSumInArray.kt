package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimize-maximum-pair-sum-in-array
class MinimizeMaximumPairSumInArray {
    fun minPairSum(nums: IntArray): Int {
        nums.sort()
        var left = 0
        var right = nums.size - 1
        var maxPairSum = 0

        while (left < right) {
            val pairSum = nums[left] + nums[right]
            maxPairSum = maxOf(maxPairSum, pairSum)
            left++
            right--
        }
        return maxPairSum
    }
}
