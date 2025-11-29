package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-operations-to-make-array-sum-divisible-by-k
class MinimumOperationsToMakeArraySumDivisibleByK {
    fun minOperations(nums: IntArray, k: Int): Int {
        var sum = 0
        for (num in nums) {
            sum += num
        }
        return sum % k
    }
}
