package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/minimum-equal-sum-of-two-arrays-after-replacing-zeros
class MinimumEqualSumOfTwoArraysAfterReplacingZeros {
    fun minSum(nums1: IntArray, nums2: IntArray): Long {
        fun adjustedSum(arr: IntArray): Pair<Long, Boolean> {
            var sum = 0L
            var hasZero = false
            for (num in arr) {
                if (num == 0) {
                    sum += 1
                    hasZero = true
                } else {
                    sum += num
                }
            }
            return sum to hasZero
        }

        val (sum1, hasZero1) = adjustedSum(nums1)
        val (sum2, hasZero2) = adjustedSum(nums2)

        if ((!hasZero1 && sum2 > sum1) || (!hasZero2 && sum1 > sum2)) return -1

        return maxOf(sum1, sum2)
    }
}
