package com.pandus.leetcode.solutions.daily

import kotlin.math.max
import kotlin.math.min

// Reference: https://leetcode.com/problems/maximum-subarray-sum-with-length-divisible-by-k
class MaximumSubarraySumWithLengthDivisibleByK {
    fun maxSubarraySum(nums: IntArray, k: Int): Long {
        val n = nums.size
        var prefixSum: Long = 0
        var maxSum = Long.MIN_VALUE
        val kSum = LongArray(k)
        for (i in 0..<k) {
            kSum[i] = Long.MAX_VALUE / 2
        }
        kSum[k - 1] = 0
        for (i in 0..<n) {
            prefixSum += nums[i].toLong()
            maxSum = max(maxSum, prefixSum - kSum[i % k])
            kSum[i % k] = min(kSum[i % k], prefixSum)
        }
        return maxSum
    }
}
