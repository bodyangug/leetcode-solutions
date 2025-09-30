package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/find-triangular-sum-of-an-array
class FindTriangularSumOfArray {
    fun triangularSum(nums: IntArray): Int {
        val dp = IntArray(nums.size) { nums[it] }
        for (i in 1 until nums.size) {
            for (j in nums.size - 1 downTo i) {
                dp[j] = (dp[j - 1] + dp[j]) % 10
            }
        }
        return dp[nums.size - 1]
    }
}
