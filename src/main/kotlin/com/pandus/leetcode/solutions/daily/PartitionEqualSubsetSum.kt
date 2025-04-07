package com.pandus.leetcode.solutions.daily

// Reference: https://leetcode.com/problems/partition-equal-subset-sum/
class PartitionEqualSubsetSum {
    fun canPartition(nums: IntArray): Boolean {
        val totalSum = nums.sum()
        // If the total sum is odd, can't partition into two equal subsets
        if (totalSum % 2 != 0) return false
        val target = totalSum / 2
        val dp = BooleanArray(target + 1)
        dp[0] = true // zero can always be formed with empty subset
        for (num in nums) {
            for (i in target downTo num) {
                dp[i] = dp[i] || dp[i - num]
            }
        }
        return dp[target]
    }
}
