package com.pandus.leetcode.solutions.daily

import kotlin.math.abs

// Reference: https://leetcode.com/problems/maximum-absolute-sum-of-any-subarray
class MaximumAbsoluteSumOfAnySubarray {
    fun maxAbsoluteSum(nums: IntArray): Int {
        var minPrefixSum = 0
        var maxPrefixSum = 0
        var prefixSum = 0
        var maxAbsSum = 0

        for (num in nums) {
            prefixSum += num
            maxAbsSum = maxOf(maxAbsSum, abs(prefixSum - minPrefixSum), abs(prefixSum - maxPrefixSum))
            minPrefixSum = minOf(minPrefixSum, prefixSum)
            maxPrefixSum = maxOf(maxPrefixSum, prefixSum)
        }

        return maxAbsSum
    }
}
