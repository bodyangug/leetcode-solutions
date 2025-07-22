package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-erasure-value
class MaximumErasureValue {
    fun maximumUniqueSubarray(nums: IntArray): Int {
        var left = 0
        var currSum = 0
        var maxSum = 0
        val seen = mutableSetOf<Int>()

        for (right in nums.indices) {
            while (nums[right] in seen) {
                seen.remove(nums[left])
                currSum -= nums[left]
                left++
            }
            seen.add(nums[right])
            currSum += nums[right]
            maxSum = maxOf(maxSum, currSum)
        }

        return maxSum
    }
}
