package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/count-partitions-with-even-sum-difference
class CountPartitionsWithEvenSumDifference {
    fun countPartitions(nums: IntArray): Int {
        var totalSum = 0
        for (x in nums) {
            totalSum += x
        }
        return if (totalSum % 2 == 0) nums.size - 1 else 0
    }
}
