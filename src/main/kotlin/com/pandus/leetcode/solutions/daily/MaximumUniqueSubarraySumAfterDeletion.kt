package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion
class MaximumUniqueSubarraySumAfterDeletion {
    fun maxSum(nums: IntArray): Int {
        val positiveNums = nums.filter { it > 0 }.toSet()
        return if (positiveNums.isEmpty()) {
            nums.maxOrNull() ?: Int.MIN_VALUE // or throw if empty input not allowed
        } else {
            positiveNums.sum()
        }
    }
}
