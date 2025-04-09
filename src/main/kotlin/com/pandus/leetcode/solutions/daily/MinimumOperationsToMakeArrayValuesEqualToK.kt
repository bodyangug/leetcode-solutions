package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k
class MinimumOperationsToMakeArrayValuesEqualToK {
    fun minOperations(nums: IntArray, k: Int): Int {
        if (nums.any { it < k }) return -1
        return nums.filter { it > k }.toSet().size
    }
}
